#!/bin/sh

echo "===> starting apps" 
cd node-app && npm install 
node index.js 4000 & 
node index.js 5000 & 
node index.js 6000 & 
cd -

sleep 5

echo ""
echo "===> starting container" 
docker rm envoy
docker run -d --name envoy -p 10000:10000 -p 9901:9901 envoyproxy/envoy:dev-7f4416f164b48d57e682a5a06ef0905f7989920d
