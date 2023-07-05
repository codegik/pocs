package myproject;

import com.pulumi.Pulumi;
import com.pulumi.asset.FileAsset;
import com.pulumi.aws.s3.Bucket;
import com.pulumi.aws.s3.BucketArgs;
import com.pulumi.aws.s3.BucketObject;
import com.pulumi.aws.s3.BucketObjectArgs;
import com.pulumi.aws.s3.BucketOwnershipControls;
import com.pulumi.aws.s3.BucketOwnershipControlsArgs;
import com.pulumi.aws.s3.BucketPublicAccessBlock;
import com.pulumi.aws.s3.BucketPublicAccessBlockArgs;
import com.pulumi.aws.s3.inputs.BucketOwnershipControlsRuleArgs;
import com.pulumi.aws.s3.inputs.BucketWebsiteArgs;
import com.pulumi.resources.CustomResourceOptions;

import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Pulumi.run(ctx -> {
            final String fileName = "index.html";

            // Create an AWS resource (S3 Bucket)
            var bucket = new Bucket("my-bucket", BucketArgs.builder()
                    .website(BucketWebsiteArgs.builder().indexDocument(fileName).build())
                    .build());

            // Create an S3 Bucket object
            try {
                final String filePath = Paths.get(App.class.getClassLoader().getResource(fileName).toURI()).toString();

                var ownershipControls = new BucketOwnershipControls("ownershipControls", BucketOwnershipControlsArgs.builder()
                        .bucket(bucket.id())
                        .rule(BucketOwnershipControlsRuleArgs.builder().objectOwnership("ObjectWriter").build())
                        .build());

                var publicAccessBlock = new BucketPublicAccessBlock("publicAccessBlock", BucketPublicAccessBlockArgs.builder()
                        .bucket(bucket.id())
                        .blockPublicAcls(false)
                        .build());

                new BucketObject(
                        fileName,
                        BucketObjectArgs.builder()
                        .bucket(bucket.id())
                        .source(new FileAsset(filePath))
                        .contentType("text/html")
                        .acl("public-read")
                        .build(),
                        CustomResourceOptions.builder()
                        .dependsOn(publicAccessBlock)
                        .build());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Export the name of the bucket
            ctx.export("bucketName", bucket.bucket());
            ctx.export("bucketEndpoint", bucket.websiteEndpoint().applyValue(websiteEndpoint -> String.format("http://%s", websiteEndpoint)));
        });
    }
}
