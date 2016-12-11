(ns game.rules-of-replacement)

;; Premise Backus-Naur Form
;; <Premise> ::= <Statement>
;; 						 | [<Not> <Premise>]
;; 						 | [<Connective> <Premise> <Premise>]
;; <Statement> ::= :A | :B | ...
;; <Not> ::= :not
;; <Connective> ::= :and | :or

;; Rules of Replacement (Rules of Equivalence)
;; - Double Negation: Introduction, Elimination
;; - Tautology
;; - Commutativity
;; - Associativity
;; - Distributivity
;; - De Morgan's Laws (De Morgan's Rule)
;; - Transposition
;; - Material Implication
;; - Exportation?
;; - Negation introduction?

(defn double-negation-introduction
  "P → ¬¬P"
  [P]
  [:not [:not P]])

(defn double-negation-elimination
  "¬¬P → P"
  [P]
  (let [P (flatten P)]
    (if (odd? (count P))
      (last P)
      (->> P (take-last 2) vec))))

(defn tautology
  "(P ∧ P) → P
   (P ∨ P) → P"
  [[_ P P]]
  P)

(defn commutativity
  "(P ∧ Q) ↔ (Q ∧ P)
   (P ∨ Q) ↔ (Q ∨ P)"
  [[connective P Q]]
  [connective Q P])

;; References
;; https://en.wikipedia.org/wiki/Rule_of_replacement, 11/12/16
;; https://en.wikipedia.org/wiki/Double_negation, 11/12/16
;; https://en.wikipedia.org/wiki/Tautology_(rule_of_inference), 11/12/16
;; https://en.wikipedia.org/wiki/Commutative_property, 11/12/16

;; https://en.wikipedia.org/wiki/Rule_of_inference, 11/12/16
;; https://en.wikipedia.org/wiki/Premise, 11/12/16

;; https://en.wikipedia.org/wiki/List_of_logic_symbols, 11/12/16
;; https://en.wikipedia.org/wiki/Proposition, 11/12/16
