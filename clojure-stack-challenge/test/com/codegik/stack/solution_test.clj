(ns com.codegik.stack.solution-test
  (:require [clojure.test :refer :all]
            [com.codegik.stack.solution :refer :all]))

(deftest test-minmax-subarray-sum
  (testing "basic case with k=3"
    (is (= 4 (minmax-subarray-sum [1 2 3] 3))))

  (testing "case with k=2"
    (is (= 7 (minmax-subarray-sum [3 1 5 4] 2))))

  (testing "single element"
    (is (= 0 (minmax-subarray-sum [5] 1))))

  (testing "two elements with k=1"
    (is (= 0 (minmax-subarray-sum [1 2] 1))))

  (testing "two elements with k=2"
    (is (= 1 (minmax-subarray-sum [1 2] 2))))

  (testing "all same elements"
    (is (= 0 (minmax-subarray-sum [5 5 5] 2))))

  (testing "decreasing sequence"
    (is (= 4 (minmax-subarray-sum [5 4 3 2 1] 2))))

  (testing "increasing sequence"
    (is (= 4 (minmax-subarray-sum [1 2 3 4 5] 2))))

  (testing "larger k than array size"
    (is (= 4 (minmax-subarray-sum [1 2 3] 5))))

  (testing "all negative numbers"
    (is (= 4 (minmax-subarray-sum [-5 -4 -3 -2 -1] 2))))

  (testing "mixed positive and negative"
    (is (= 14 (minmax-subarray-sum [-2 3 -1 4] 2))))

  (testing "negative, zero, and positive"
    (is (= 2 (minmax-subarray-sum [-1 0 1] 2))))

  (testing "large negative numbers"
    (is (= 75 (minmax-subarray-sum [-100 -50 -25] 2))))

  (testing "single negative element"
    (is (= 0 (minmax-subarray-sum [-5] 1))))

  (testing "alternating positive and negative"
    (is (= 26 (minmax-subarray-sum [1 -1 2 -2 3] 3)))))

(defn -main []
  (run-tests 'com.codegik.stack.solution-test))
