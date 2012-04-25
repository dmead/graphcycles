(ns graphcycles.core)




(defn in?
  "true if seq contains elm"
  [seq elm]
  (some #(= elm %) seq))

(defn connection-from [node [left right]]
  (= node left))


(defn goes-to [ [left right]]
  right)

(defn connections-of [node edgelist]
 (map (fn [edge] (goes-to edge))
      (filter (fn [edge]
                (connection-from node edge)) edgelist)))


(defn find-cycle  [edgelist history start current ]
  (cond (in? history current) (list 'Cycle start  (reverse  (cons current  history)))
        (empty? edgelist) false
        :more
        (apply concat  (map (fn  next-level [next ]
                              (find-cycle edgelist
                                         (cons current history)
                                         start next))
                            (connections-of current edgelist)))))


