(ns clojure-hobbits.core
  (:gen-class))

(def orcs     {1 0, 2 0, 3 0, 4 0, 5 0})
(def elfs     {1 0, 2 3, 3 7, 4 15, 5 20})
(def humans   {1 1, 2 2, 3 5, 4 10, 5 12})
(def trees    {1 3, 2 4, 3 8, 4 12, 5 20})
(def wizards  {1 10, 2 15, 3 20, 4 25, 5 30})
(def hobbits  {1 15, 2 20, 3 30, 4 45, 5 50})
(def books    {"book1" 23.0, "book2" 10.0, "book3" 15.0, "book4" 32.5})


(defn sellBook [book amount kind]
  (let [discount (get kind amount)]
    (let [value (get books book)]
      (let [total (* value amount)]
        (- total (/ (* total discount) 100))))))

(defn topBuyer [sales]
  (first (sort-by :price > sales)))

(defrecord Sale [kindStr price])


(defn -main
  [& args]
  (println "run the tests please"))