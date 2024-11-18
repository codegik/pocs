#!/bin/sh

brew install lua luarocks
luarocks install pegasus
luarocks install uuid

docker rm envoy
docker run -d --name envoy -p 10000:10000 -p 9901:9901 envoyproxy/envoy:dev-7f4416f164b48d57e682a5a06ef0905f7989920d
