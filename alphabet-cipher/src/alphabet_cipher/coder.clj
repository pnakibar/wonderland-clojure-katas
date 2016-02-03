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

(def table
  (reduce (fn [table key]
            (conj table [(char key) ((comp tilt-1-left second last) table)]
                  )
            )

          {\a alphabet}
          (range (+ 1 alphabet-lower-bound) alphabet-higher-bound))
  )

(defn get-row
  [key]
  (get table key))

(defn to-column
  [char]
  (- (int char) alphabet-lower-bound)
  )

(defn get-cipher-letter
  [original-char cipher-char]
  (nth (get-row cipher-char) (to-column original-char))
  )

(defn repeat-word
  [word n]
  (take n (repeat word))
  )

(defn new-keyword
  [keyword message]
  (let [keyword-size (count keyword)
        message-size (count message)
        quantity-keyword ((comp inc int /) message-size keyword-size)]

    (if (< (count keyword) (count message))
      (clojure.string/join (repeat-word keyword quantity-keyword))
      keyword
      )
    )
  )

(defn encode [keyword message]
  (clojure.string/join
    (map get-cipher-letter (new-keyword keyword message) message)
    )
  )

(defn decode [keyword message]
  "decodeme"
  (clojure.string/join
    (map (fn [char-keyword char-encoded]
           (char (+ alphabet-lower-bound (.indexOf (get table char-keyword) char-encoded)))
           )
         (clojure.string/join (take (count message) (new-keyword keyword message)))
         message
         )

    )
  )


(defn decipher [cipher message]
  "decypherme")

