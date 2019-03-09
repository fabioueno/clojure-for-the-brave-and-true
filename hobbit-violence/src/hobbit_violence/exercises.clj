(ns hobbit-violence.exercises)

;; Exercise 01: Use the str, vector, list, hash-map and hash-set functions.

;; str: with no arguments returns an empty string.
;; str: with one argument returns its toString().
;; str: with two or more arguments returns the concatenations of its strings representations.
(str)
(str 0)
(str 0 0)

;; vector: with no arguments returns an empty vector.
;; vector: with one or more arguments returns a vector with them.
(vector)
(vector "a" 1 {} [] #{})

;; list: returns a list with given arguments.
(list "a" 1 {} [] #{})

;; hash-map: with no arguments returns an empty map.
;; hash-map: with a pair number of arguments returns their key-value map.
(hash-map)
(hash-map "a" 1 {} [])

;; hash-set: with no arguments returns an empty set.
;; hash-set: with one or more arguments returns a set with them.
(hash-set)
(hash-set "a" "a" 1 {} [])

;; Exercise 02: Write a function that takes a number and adds 100 to it.

(defn inc-maker
  [increment]
  #(+ % increment))

(def inc100 (inc-maker 100))

(inc100 0)
(inc100 100)

;; Exercíse 03: Write a function, dec-maker, that works exactly like the function inc-maker except with subtraction.

(defn dec-maker
  [decrement]
  #(- % decrement))

(def dec9 (dec-maker 9))

(dec9 10)

;; Exercise 04: Write a function, mapset, that works like map except the return value is a set.

(defn mapset [fn coll]
  (set (map fn coll)))

(mapset inc [1 1 2 2])

;; Exercise 05: Create a function that's similar to symmetrize-body-parts except that it has to work with weird space
;; aliens with radial symmetry. Instead of two eyes, arms, legs, and so on, they have five.

(def asym-alien-body-parts [{:name "head" :size 3}
                            {:name "1-eye" :size 1}
                            {:name "1-ear" :size 1}
                            {:name "mouth" :size 1}
                            {:name "nose" :size 1}
                            {:name "neck" :size 2}
                            {:name "1-shoulder" :size 3}
                            {:name "1-upper-arm" :size 3}
                            {:name "chest" :size 10}
                            {:name "back" :size 10}
                            {:name "1-forearm" :size 3}
                            {:name "abdomen" :size 6}
                            {:name "1-kidney" :size 1}
                            {:name "1-hand" :size 2}
                            {:name "1-knee" :size 2}
                            {:name "1-thigh" :size 4}
                            {:name "1-lower-leg" :size 3}
                            {:name "1-achilles" :size 1}
                            {:name "1-foot" :size 2}])

(defn matching-parts
  [part]
  [{:name (clojure.string/replace (:name part) #"^1-" "2-")
    :size (:size part)}
   {:name (clojure.string/replace (:name part) #"^1-" "3-")
    :size (:size part)}
   {:name (clojure.string/replace (:name part) #"^1-" "4-")
    :size (:size part)}
   {:name (clojure.string/replace (:name part) #"^1-" "5-")
    :size (:size part)}])

(defn symmetrize-alien-parts
  [asym-alien-parts]
  (reduce (fn [final-parts part]
            (into final-parts
                  (set (flatten
                         (seq [part (matching-parts part)]))))) [] asym-alien-parts))

;; Exercise 06: Create a function that generalizes symmetrize-body-parts and the function you created in Exercise 5.
;; The new function should take a collection of body parts and the number of matching body parts to add. If you're
;; completely new to List languages and functional programming, it probably won't be obvious how to do this. If you get
;; stuck, just move on to the next chapter and revisit the problem later.

(defn generic-matching-parts
  [part quantity]
  (loop [counter 1
         parts []]
    (if (<= counter quantity)
      (recur (inc counter) (conj parts {:name (clojure.string/replace (:name part) #"^1-" (str counter "-"))
                                        :size (:size part)}))
      parts)))

(defn symmetrize-generic-parts
  [asym-parts quantity]
  (reduce (fn [final-parts part]
            (into final-parts
                  (set (flatten
                         (seq [part (generic-matching-parts part quantity)]))))) [] asym-parts))