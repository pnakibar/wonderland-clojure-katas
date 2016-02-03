(ns card-game-war.game-test
  (:require [clojure.test :refer :all]
            [card-game-war.game :refer :all]))


;; fill in  tests for your game
(deftest test-play-round
  (testing "the highest rank wins the cards in the round"
    (is (= 0 1)))
  (testing "queens are higher rank than jacks"
    (is (= :queen
           (compare-ranks :queen :jack)
          )))
  (testing "kings are higher rank than queens"
    (is (= :queen
           (compare-ranks :king :queen))))
  (testing "aces are higher rank than kings"
    (is (= :ace
           (compare-ranks :ace :king))))
  (testing "if the ranks are equal, clubs beat spades"
    (is (= [:club 2])
        (compare-cards [:club 2] [:spade 2]))
    )
  (testing "if the ranks are equal, diamonds beat clubs"
     (is (= [:diamond 2])
        (compare-cards [:club 2] [:diamond 2]))
    )
  (testing "if the ranks are equal, hearts beat diamonds"
    (is (= [:heart 2])
        (compare-cards [:heart 2] [:diamond 2]))
    )

  )

(deftest test-play-game
  (testing "the player loses when they run out of cards"))

