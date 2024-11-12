FROM mcr.microsoft.com/dotnet/aspnet:8.0 AS base
WORKDIR /app
RUN apt-get update
RUN apt-get install -y zip curl
ARG OTEL_VERSION=1.8.0
RUN curl -sSfL https://github.com/open-telemetry/opentelemetry-dotnet-instrumentation/releases/download/v${OTEL_VERSION}/otel-dotnet-auto-install.sh -O
USER app
EXPOSE 8080
EXPOSE 8081

FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
ARG BUILD_CONFIGURATION=Release
WORKDIR /src
COPY . .
RUN dotnet build "./dotnet-opentelemetry.csproj" -c $BUILD_CONFIGURATION -o /app/build

FROM build AS publish
ARG BUILD_CONFIGURATION=Release
RUN dotnet publish "./dotnet-opentelemetry.csproj" -c $BUILD_CONFIGURATION -o /app/publish /p:UseAppHost=false

FROM base AS final
COPY --from=publish /app/publish .
RUN sh /app/otel-dotnet-auto-install.sh 
RUN chmod +x $HOME/.otel-dotnet-auto/instrument.sh
ENTRYPOINT ["/home/app/.otel-dotnet-auto/instrument.sh", "dotnet", "/app/dotnet-opentelemetry.dll"]