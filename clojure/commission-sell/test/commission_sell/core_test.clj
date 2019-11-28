(ns commission-sell.core-test
  (:require [clojure.test :refer :all]
            [commission-sell.core :refer :all]))

(deftest sortTop3SellersAndCalculateTheCommission
  (is (=  (list
            (->Sale "Peter" 99.99 40.9959)
            (->Sale "Brad" 98.78 30.621799999999997)
            (->Sale "Mary" 50.50 10.605))
          (calculate (list 
            (->Sale "Brad" 98.78 0.0) 
            (->Sale "Jhon" 28.78 0.0) 
            (->Sale "Peter" 99.99 0.0) 
            (->Sale "Mary" 50.50 0.0))))))

(deftest sortTop2SellersAndCalculateTheCommission
  (is (=  (list
            (->Sale "Peter" 99.99 40.9959)
            (->Sale "Mary" 50.50 15.655))
          (calculate (list 
            (->Sale "Mary" 50.50 0.0)
            (->Sale "Peter" 99.99 0.0))))))
