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

    (if (= card-1-rank card-2-rank)
      [(compare-suits card-1-suit card-2-suit) card-1-rank] ;;same rank
      (if (= card-1-rank (compare-ranks card-1-rank card-2-rank)) ;;not same rank
        card-1
        card-2
        )
      )
    )
  )

(defn play-round [player1-card player2-card]
  )

(defn who-won-game?
  [player-1-cards player-2-cards]
  (cond
    (empty? player-1-cards) :player-2
    (empty? player-2-cards) :player-1
    :else nil
    )
  )

(defn resolve-hands
  [hand-1 hand-2]
  (let [card-1 (first hand-1)
        card-2 (first hand-2)
        won-card (compare-cards card-1 card-2)
        ]
    (if (= card-1 won-card)
      [(conj (rest hand-1) card-1 card-2) (rest hand-2)]
      [(rest hand-1) (conj (rest hand-2) card-2 card-1)]
      )
    )
  )

(def give-cards
  (split-at (/ (count cards) 2) (shuffle cards))
  )

(def p-1-cards (first give-cards))
(def p-2-cards (second give-cards))


(defn play-game
  [player-1-cards player-2-cards]
  (loop
    [player-1-cards player-1-cards
     player-2-cards player-2-cards]
    (if (who-won-game? player-1-cards player-2-cards)
      (who-won-game? player-1-cards player-2-cards)
      (let [hands-decided (resolve-hands player-1-cards player-2-cards)]
        (recur (first hands-decided) (second hands-decided))
        )
      )
    )
  )


