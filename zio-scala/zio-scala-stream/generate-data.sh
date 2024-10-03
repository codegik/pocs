#!/bin/sh

set -e

output_file="./src/main/resources/input-data.csv"
num_lines=100000000
i=1

truncate -s 0 $output_file

while [ $i -le $num_lines ]; do
  echo "$i;test-data-$i" >> $output_file
  i=$((i + 1))
done