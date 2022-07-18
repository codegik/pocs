#!/bin/sh

SHOP_URL="http://localhost:9090/shop/default-cart"
BASEDIR="$( cd -- "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"

if ls shop/target/kotlin-resilience4j-shop-*.jar 1> /dev/null 2>&1; then
    echo "skipping build for shop"
else
  cd $BASEDIR/shop
  mvn clean install
fi

cd $BASEDIR

java -jar $BASEDIR/shop/target/kotlin-resilience4j-shop-*.jar &
SHOP_PID=$(echo $!)

echo "shop pid = $SHOP_PID"

sleep 5

for i in {1..5}; do
  echo ""
  echo ""
  echo "### trying number $i ###"
  curl -i $SHOP_URL
  sleep 3
done

echo ""
echo ""
echo "### test complete: stopping app ###"
kill -9 $SHOP_PID

exit 0