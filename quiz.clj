(ns quiz.quiz)
(ns firstclojure.core
    (:gen-class
      :methods [#^{:static true} [hello [String] String]]))

;;定义三个变量
(def big 0)                                                 ;
(def middle 0)                                              ;
(ns clojure.examples.hello
    (:gen-class))

(defn display [str]
      (println str))

(defn hello1 [str]

      (def flags 0)
      (def big 0)
      (def middle 0)
      (def small 0)
      ;(+ middle 1)

      (loop [i 0]
            (when (and (< i (count str)) (= 0 flags))
                  (case (subs str i (inc i))
                        "(" (def small (inc small))
                        ")" (def small (dec small))
                        "[" (def middle (inc middle))
                        "]" (def middle (dec middle))
                        "{" (def big (inc big))
                        "}" (def big (dec big))
                        (println "is over!"))
                  (if ( or (> 0 big) (or (> 0 small) (> 0 middle)) )
                    (def flags (dec flags)))
                  ;; (display small)
                  ;; (display middle)
                  ;; (display big)
                  ;; (println i)
                  ;; (println flags)
                  (recur (inc i)))
            )
      ;;如果flags小于0，说明有括号位置不对
      (if (> 0 flags)
        (println "false")
        (if (and (= 0 big) (and (= 0 small) (= 0 middle)))
          (println "true")
          (println "false"))
        )
      )
(hello1 "{[")



