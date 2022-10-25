#!/bin/sh

SHOP_URL="http://localhost:9090/shop/cart"
BASEDIR="$( cd -- "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"

if ls product/target/kotlin-resilience4j-product-*.jar 1> /dev/null 2>&1; then
    echo "skipping build for product"
else
  cd $BASEDIR/product
  mvn clean install
fi

if ls shop/target/kotlin-resilience4j-shop-*.jar 1> /dev/null 2>&1; then
    echo "skipping build for shop"
else
  cd $BASEDIR/shop
  mvn clean install
fi

cd $BASEDIR


startProduct() {
  nohup java -jar $BASEDIR/product/target/kotlin-resilience4j-product-*.jar > /dev/null 2>&1&
  echo $!
}

startShop() {
  nohup java -jar $BASEDIR/shop/target/kotlin-resilience4j-shop-*.jar > /dev/null 2>&1&
  echo $!
}


PRODUCT_PID=$(startProduct)
SHOP_PID=$(startShop)

echo "product pid = $PRODUCT_PID"
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
echo "### stopping product app ###"
kill -9 $PRODUCT_PID

for i in {6..10}; do
  echo ""
  echo ""
  echo "### trying number $i ###"
  curl -i $SHOP_URL
  sleep 3
done

echo ""
echo ""
echo "### starting product app ###"
PRODUCT_PID=$(startProduct)
echo "product pid = $PRODUCT_PID"

for i in {11..15}; do
  echo ""
  echo ""
  echo "### trying number $i ###"
  curl -i $SHOP_URL
  sleep 3
done

echo ""
echo ""
echo "### test complete: stopping all apps ###"
kill -9 $PRODUCT_PID
kill -9 $SHOP_PID

exit 0