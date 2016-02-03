(ns alphabet-cipher.coder)

(def ALPHABET-lower-bound 65)
(def ALPHABET-higher-bound 91)
(def alphabet-lower-bound 97)
(def alphabet-higher-bound 123)
(def alphabet (into [] (map char (range alphabet-lower-bound alphabet-higher-bound))))


(defn tilt-1-left
  "tilt the array 1 unit left"
  [coll]
  (conj (into [] (rest coll)) (first coll))
  )

(def generateTable
  (reduce (fn [table newLine]
            (conj table (tilt-1-left (last table)))
            )
          [alphabet]
          (range ALPHABET-lower-bound (- ALPHABET-higher-bound 1)))
  )






(defn encode [keyword message]
  "encodeme")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

