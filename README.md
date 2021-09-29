# -Quiz: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', here you’ll need to try to determine if the input string is valid.

**There is a problem with my lein environment configuration. It may not be able to package and run. However, the code realizes the function by calling the function hello1, followed by parameters.

(ns clojure.examples.hello
    (:gen-class))

(defn display [str]
    (println str))

(defn hello1 [str]
    
    (def flags 0)
    (def big 0)
    (def middle 0)
    (def small 0)

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

