(ns commission-sell.core
  (:gen-class))

(defrecord Sale [salesman amount commission])

(defn calculate [sales]
  (for [[sale commission] (map list (sort-by :amount > sales) [41 31 21])] 
    (->Sale (:salesman sale) (:amount sale) (/ (* (:amount sale) commission) 100))))

(defn -main [& args]
  (println "Please run lein test"))