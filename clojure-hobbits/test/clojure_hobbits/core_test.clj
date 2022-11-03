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

  (testing "features"
    ; anonymous functions
    (fn [message] (println message))
    (#(filter even? %) [1 2 3 4 5 6])

    (def evens (fn [coll] (filter even? coll)))
    (evens [1 2 3 4 5 6])

    ; filter
    (filter even? (range 10)) ; (0 2 4 6 8)

    ; filter string length == 1
    (filter (fn [x] (= (count x) 1)) ["a" "aa" "b" "n" "f" "lisp" "clojure" "q" ""]) ; ("a" "b" "n" "f" "q")

    ; reduce
    (reduce + [1 2 3 4 5])                                  ; 15

    ;; reduce - Add one collection to another
    (reduce conj [1 2 3] [4 5 6])                           ; [1 2 3 4 5 6]

    ; map - sum two collections
    (map + [1 2 3] [4 5 6])                                 ; (5 7 9)

    ; map - apply function on collection
    (map #(str "Hello " % "!" ) ["Ford" "Arthur" "Tricia"]) ; ("Hello Ford!" "Hello Arthur!" "Hello Tricia!")
    )
  )
