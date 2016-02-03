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

(def generate-table
  (reduce (fn [table key]
            (conj table [(char key) ((comp tilt-1-left second last) table)]
                  )
            )

          {\A alphabet}
          (range (+ 1 ALPHABET-lower-bound)  ALPHABET-higher-bound))
  )






(defn encode [keyword message]
  "encodeme")

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

