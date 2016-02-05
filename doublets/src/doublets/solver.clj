(ns doublets.solver
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def words (-> "words.edn"
               (io/resource)
               (slurp)
               (read-string)))

(defn map-different-letters
  [word-1 word-2]
  (map = word-1 word-2)
  )
(defn different-letters-words
  [word-1 word-2]
  (reduce (fn [acc, e]
            (if (not e)
              (+ acc 1)
              acc
              )
            ) 0 (map-different-letters word-1 word-2))
  )

(defn level-of-equality
  [word-1 word-2]
  (reduce +
          (map (fn [c1 c2] (if (= c1 c2) 1 0)) word-1 word-2)
          )
  )

(defn words-like
  [word]
  (filter #(= (count word) (count %))                       ; same size
          (filter #(= (different-letters-words % word) 1) words) ; one letter difference
          )
  )

(defn vector-contains?
  [vector value]
  (
    (comp not empty?) (filter #(= value %) vector)
    )

  )

(defn words-not-like-previous
  [previous-words word]
  (filter #(not (vector-contains? previous-words %)) (words-like word))
  )

(defn select-best-word
  [possible-words objective-word]
  (last (sort-by #(level-of-equality objective-word %) possible-words))
  )




(defn doublets
  [start-word stop-word]
  (loop [current-word start-word
         previous-words []]
    (let [new-word (select-best-word (words-not-like-previous previous-words current-word) stop-word)]
      (if (= new-word stop-word)
        (conj previous-words current-word new-word)
        (recur new-word (conj previous-words current-word))
        )
      )
    )
  )
