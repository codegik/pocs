(ns com.codegik.stack.fakestack
  (:refer-clojure :exclude [empty? peek pop]))

(defn create []
  [])

(defn empty? [stack]
  (= 0 (count stack)))

;; Returns the top element of the stack without modifying it.
;; If the stack is empty, it returns nil.
(defn peek [stack]
  (when-not (empty? stack)
    (nth stack (dec (count stack)))))

;; Removes the top element from the stack and returns the new stack
;; without that element.
(defn pop [stack]
  (if (empty? stack)
    stack
    (subvec stack 0 (dec (count stack)))))

;; Adds a new element to the top of the stack and returns
;; the new stack with that element.
(defn push [stack item]
  (conj stack item))  ; conj stands for "conjoin" (meaning to join or combine)
