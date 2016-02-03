(ns card-game-war.game)

;; feel free to use these cards or use your own data structure
(def suits [:spade :club :diamond :heart])
(def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
(def cards
  (for [suit suits
        rank ranks]
    [suit rank]))


(defn compare-positions
  [val-1 val-2 coll]
  (if (> (.indexOf coll val-1) (.indexOf coll val-2))
    val-1
    val-2
    )
  )

(defn compare-ranks
  [rank-1 rank-2]
  (compare-positions rank-1 rank-2 ranks)
  )

(defn compare-suits
  [suit-1 suit-2]
  (compare-positions suit-1 suit-2 suits)
  )

(defn compare-cards
  [card-1 card-2]
  (let [card-1-rank (second card-1)
        card-2-rank (second card-2)
        card-1-suit (first card-1)
        card-2-suit (second card-2)]
    (println card-1-rank)

    (if (= card-1-rank card-2-rank)
      [(compare-suits card-1-suit card-2-suit) card-1-rank] ;;same rank
      (if (= card-1-rank (compare-ranks card-1-rank card-2-rank)) ;;not same rank
        card-1
        card-2
        )
      )
    )
  )

(defn play-round [player1-card player2-card])

(defn play-game [player1-cards player2-cards])
