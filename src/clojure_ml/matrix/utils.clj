(ns clojure-ml.matrix.utils
  (:use clojure.core.matrix)
  (:require [clatrix.core :as cl]))

(defn square-mat
  "Creates a square matrix of size n x n whose 
    elements are all e. Accepts an option argument 
    for the matrix implementation."
  [n e & {:keys [implementation]
          :or {implementation :persistent-vector}}]
  (let [repeater #(repeat n %)]
    (matrix implementation (-> e repeater repeater))))

(defn id-mat
  "Creates an identity matrix of n x n size"
  [n]
  (let [init (square-mat n 0 :implementation :clatrix)
        identity-f (fn [i j n]
                     (if (= i j) 1 n))]
    (cl/map-indexed identity-f init)))

(defn square-rand-mat
  "Generates a random matrix of size n x n"
  [n]
  (matrix (repeat n (repeat n (rand-int 100)))))