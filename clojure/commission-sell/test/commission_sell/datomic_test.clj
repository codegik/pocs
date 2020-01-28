(ns commission-sell.datomic-test
  (:require [clojure.test :refer :all]
    [datomic.client.api :as d]))

(def cfg {:server-type :peer-server
                 :access-key "admin"
                 :secret "datomic"
                 :endpoint "localhost:4334"
                 :validate-hostnames false})

(def client (d/client cfg))
(def conn (d/connect client {:db-name "hello"}))

(def movie-schema [
  {:db/ident :movie/title
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "The title of the movie"}

  {:db/ident :movie/genre
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/doc "The genre of the movie"}

  {:db/ident :movie/release-year
    :db/valueType :db.type/long
    :db/cardinality :db.cardinality/one
    :db/doc "The year the movie was released in theaters"}])

(defn add-movie []
  (d/transact conn [{:movie/title "shrek 3" 
                     :movie/genre "commedy" 
                     :movie/release-year "2015"}]))

(deftest testDatomic
  (d/transact conn {:tx-data movie-schema})
  )
