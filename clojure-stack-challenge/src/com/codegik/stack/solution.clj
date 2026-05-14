(ns com.codegik.stack.solution
  (:require [com.codegik.stack.fakestack :as stack]))

;; test with [3, 1, 5, 4] and >
(defn find-boundaries [numbers compare-fn]
  ;; Uses monotonic stack to find for each element:
  ;; - prev[i]: index of previous element where compare-fn is true
  ;; - next[i]: index of next element where compare-fn is false
  ;; For max: finds range where numbers[i] is maximum
  ;; For min: finds range where numbers[i] is minimum
  (let [size (count numbers)
        ;; atom creates mutable arrays
        ;; [-1, -1, -1, -1] [-1, -1, -1, -1] [-1, 0, -1, -1] [-1, 0, -1, -1] [-1, 0, -1, 2]
        prev (atom (vec (repeat size -1)))
        ;; [4, 4, 4, 4]     [4, 4, 4, 4]     [4, 4, 4, 4]    [2, 2, 4, 4]    [2, 2, 4, 4]
        next (atom (vec (repeat size size)))
        ;; st = the box
        ;; @st = what's inside the box
        ;; swap! = replace what's in the box
        ;; []               [0]              [0, 1]          [2]             [2, 3]
        st (atom (stack/create))]
    (doseq [i (range size)]
      ;; For max, checks if stack top value > current value, If false, pop stack (current element is larger)
      ;; For min, checks if stack top value < current value, If false, pop stack (current element is smaller)
      ;; numbers[0]=3 > numbers[1]=1? YES → keep in stack
      ;; numbers[1]=1 > numbers[2]=5? NO → Set next[1] = 2 and pop index 1
      ;; numbers[0]=3 > numbers[2]=5? NO → Set next[0] = 2 and pop index 0
      ;; numbers[2]=5 > numbers[3]=4? YES → keep in stack
      (while (and (not (stack/empty? @st))
                  (not (compare-fn (nth numbers (stack/peek @st)) (nth numbers i))))
        (swap! next assoc (stack/peek @st) i)
        (swap! st stack/pop))
      ;; Sets prev[i] to the index of the previous element
      ;; After popping elements from the stack, the stack might be empty, so prev[i] should stay -1
      (when (not (stack/empty? @st))
        (swap! prev assoc i (stack/peek @st)))
      ;; Push current index
      (swap! st stack/push i))
    [@prev @next]))

;; Index 0 (value 3): No larger prev element (-1), stops being max at index 2
;; Index 1 (value 1): Larger element at index 0, stops being max at index 2
;; Index 2 (value 5): No larger prev element (-1), no next boundary (stays 4)
;; Index 3 (value 4): Larger element at index 2, no next boundary (stays 4)
;; prev = [-1, 0, -1, 2]
;; next = [2, 2, 4, 4]
;; numbers = [3, 1, 5, 4]
;; k = 2,
;; compare-fn = >
(defn calculate-sum [numbers k compare-fn]
  (let [[prev next] (find-boundaries numbers compare-fn)]
    ;; sums all the individual contributions into a single total.
    (reduce +
      ;; For each position i, we'll count how many subarrays have numbers[i] as their min/max value.
      ;; const results = []
      ;; for (let i = 0; i < numbers.length; i++) {
      ;;   for (let left = prev[i] + 1; left <= i; left++) {
      ;;     const right = Math.min (next[i] - 1, left + k - 1)
      ;;     if (right >= i) {
      ;;       results.push (numbers [i] * (right - i + 1))
      ;; }}}
      (for [i (range (count numbers))
            left (range (inc (nth prev i)) (inc i))
            ;; right is determining the ending index of a potential subarray
            :let [right (min (dec (nth next i )) (+ left k -1))] ;; -1 to avoid index not found since k is the length of the subarray
            :when (>= right i)]
        ;; Right is an index, and (right - i + 1) is the count
        ;; count how many different ending positions exist for subarrays starting at left.
        (* (nth numbers i) (inc (- right i)))))))

(defn minmax-subarray-sum [numbers k]
  ;; Main function: returns difference between sum of maximums and sum of minimums
  ;; calculate-sum with > finds max contribution
  ;; calculate-sum with < finds min contribution
  (- (calculate-sum numbers k >)
     (calculate-sum numbers k <)))



