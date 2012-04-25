(ns graphcycles.test.core
  (:use [graphcycles.core])
  (:use [clojure.test]))



;; no cycle

(def g1 `((1 2)
          (2 3)
          (1 5)))

;;has a cycle
(def g2  `((1 2)
           (2 3)
           (1 5)
           (3 1)))

;;also has a cycle
(def g3  `((1 2)
           (1 3)
           (1 5)
           (3 1)))


(comment
  (find-cycle g1 nil 1 1)
  ()

  (find-cycle g2 nil 1 1)
  (Cycle 1 (1 2 3 1))

  (find-cycle g3 nil 1 1)
  (Cycle 1 (1 3 1))

)
