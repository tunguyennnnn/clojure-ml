(ns clojure-ml.core
  (:gen-class))

(require '[clojure-ml.matrix.utils :as matrix-utils])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (matrix-utils/id-mat 3))
