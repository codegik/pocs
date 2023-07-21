package myproject;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.core.Output;
import com.pulumi.docker.Container;
import com.pulumi.docker.ContainerArgs;
import com.pulumi.docker.Network;
import com.pulumi.docker.NetworkArgs;
import com.pulumi.docker.RemoteImage;
import com.pulumi.docker.RemoteImageArgs;
import com.pulumi.docker.inputs.ContainerNetworksAdvancedArgs;
import com.pulumi.docker.inputs.ContainerPortArgs;
import com.pulumi.resources.CustomResourceOptions;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Pulumi.run(App::stack);
    }

    private static void stack(Context ctx) {
        // Get configuration values
        final var config = ctx.config();
        final var frontendPort = config.requireInteger("frontendPort");
        final var backendPort = config.requireInteger("backendPort");
        final var mongoPort = config.requireInteger("mongoPort");
        final var mongoHost = config.require("mongoHost");
        final var database = config.require("database");
        final var nodeEnvironment = config.require("nodeEnvironment");
        final var protocol = config.require("protocol");

        final var stackName = ctx.stackName();

        // Pull the backend image
        final String backendImageName = "backend";
        final var backendImage = new RemoteImage(
                backendImageName,
                RemoteImageArgs.builder()
                        .name(String.format("pulumi/tutorial-pulumi-fundamentals-%s:latest", backendImageName))
                        .build()
        );

        // Pull the frontend image
        final String frontendImageName = "frontend";
        final var frontendImage = new RemoteImage(
                frontendImageName,
                RemoteImageArgs.builder()
                        .name(String.format("pulumi/tutorial-pulumi-fundamentals-%s:latest", frontendImageName))
                        .build()
        );

        // Pull the MongoDB image
        final var mongoImage = new RemoteImage(
                "mongoImage",
                RemoteImageArgs.builder()
                        .name("pulumi/tutorial-pulumi-fundamentals-database-local:latest")
                        .build()
        );

        // Create a Docker Network
        final var network = new Network(
                "network",
                NetworkArgs.builder()
                        .name(String.format("services-%s", stackName))
                        .build()
        );

        // Create the MongoDB container
        final var mongoContainer = new Container(
                "mongoContainer",
                ContainerArgs.builder()
                        .name(String.format("mongo-%s", stackName))
                        .image(mongoImage.repoDigest())
                        .ports(ContainerPortArgs.builder()
                                .internal(mongoPort)
                                .external(mongoPort)
                                .build())
                        .networksAdvanced(ContainerNetworksAdvancedArgs.builder()
                                .name(network.name())
                                .aliases("mongo")
                                .build()
                        )
                        .build()
        );

        // Create the frontend container
        final var frontendContainer = new Container(
                "frontendContainer",
                ContainerArgs.builder()
                        .name(String.format("frontend-%s", stackName))
                        .image(frontendImage.repoDigest())
                        .ports(ContainerPortArgs.builder()
                                .internal(frontendPort)
                                .external(frontendPort)
                                .build())
                        .envs(List.of(
                                String.format("PORT=%d", frontendPort),
                                String.format("HTTP_PROXY=backend-%s:%d", stackName, backendPort),
                                String.format("PROXY_PROTOCOL=%s", protocol)
                        ))
                        .networksAdvanced(ContainerNetworksAdvancedArgs.builder()
                                .name(network.name())
                                .build())
                        .build()
        );

        // Create the backend container
        final var backendContainer = new Container(
                "backendContainer",
                ContainerArgs.builder()
                        .name(String.format("backend-%s", stackName))
                        .image(backendImage.repoDigest())
                        .ports(ContainerPortArgs.builder()
                                .internal(backendPort)
                                .external(backendPort)
                                .build())
                        .envs(List.of(
                                String.format("DATABASE_HOST=%s", mongoHost),
                                String.format("DATABASE_NAME=%s", database),
                                String.format("NODE_ENV=%s", nodeEnvironment)
                        ))
                        .networksAdvanced(ContainerNetworksAdvancedArgs.builder()
                                .name(network.name())
                                .build()
                        )
                        .build(),
                CustomResourceOptions.builder()
                        .dependsOn(mongoContainer)
                        .build()
        );

        ctx.export("link", Output.of("http://localhost:3001"));
    }
}
