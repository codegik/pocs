(ns commission-sell.core
  (:gen-class))

(defn toDoubleArray [sales]
  (map #(Double. %) sales))

(defn calculateCommission [sales]
  (keep-indexed (fn [index item]
                  (when < index (count sales))
                    (println (type (nth sales index)))
                    (/ (* (nth (sort > sales) index) item) 100)) [41 31 21]))

(defn -main [& args]
  (println (calculateCommission (toDoubleArray args))))
