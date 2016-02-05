(ns doublets.solver-test
  (:require [clojure.test :refer :all]
            [doublets.solver :refer :all]))


(deftest different-letters-words-test
  (testing "comparation"
    (is (= 0
           (different-letters-words "asd" "asd")
           ))
    (is (= 1
       (different-letters-words "asd" "asx")
       ))
    ))

(deftest words-not-like-previous
  (testing "the new collection does not contain any of the previous words"
    (is (contains?
          (words-not-like-previous ["door"] "boor")
          "door"))

    )

  )

(deftest solver-test
  (testing "with word links found"
    (is (= ["head" "heal" "teal" "tell" "tall" "tail"]
           (doublets "head" "tail")))

    (is (= ["door" "boor" "book" "look" "lock"]
           (doublets "door" "lock")))

    (is (= ["bank" "bonk" "book" "look" "loon" "loan"]
           (doublets "bank" "loan")))

    (is (= ["wheat" "cheat" "cheap" "cheep" "creep" "creed" "breed" "bread"]
           (doublets "wheat" "bread"))))

  (testing "with no word links found"
    (is (= []
           (doublets "ye" "freezer")))))
