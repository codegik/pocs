(ns clojure-hobbits.core-test
  (:require [clojure.test :refer :all]
            [clojure-hobbits.core :refer :all])
  (:import (clojure_hobbits.core Sale)))

(deftest a-test
  (testing "sell book2 to elfs"
    (let [price (sellBook "book2" 2 elfs)]
      (is (= price 19.4))))

  (testing "sell book2 to orcs"
    (let [price (sellBook "book2" 2 orcs)]
      (is (= price 20.0))))

  (testing "sell book3 to hobbits"
    (let [price (sellBook "book3" 2 hobbits)]
      (is (= price 24.0))))

  (testing "top buyer"
    (let [sales
          (list
            (Sale. "elfs"     (sellBook "book2" 2 elfs))
            (Sale. "humans"   (sellBook "book2" 3 humans))
            (Sale. "trees"    (sellBook "book2" 4 trees))
            (Sale. "wizards"  (sellBook "book2" 4 wizards))
            (Sale. "hobbits"  (sellBook "book2" 3 hobbits))
            (Sale. "orcs"     (sellBook "book2" 5 orcs)))]
      (is (= (:kindStr (topBuyer sales)) "orcs"))))
  )
