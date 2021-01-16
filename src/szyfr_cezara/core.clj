(ns szyfr-cezara.core
  (:use [clojure.string :only (join)]))

(defn rotate [n coll]
  (take (count coll) (drop (mod n (count coll)) (cycle coll))))

(def znaki (str "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                "abcdefghijklmnopqrstuvwxyz"))

(def cezar-znaki (zipmap znaki (rotate -3 znaki)))



(defn -main
  ([& args]
  (let [tekst (first args)
        decode (fn [alph txt]
                 (join (replace cezar-znaki txt)))]
    (doseq [elem args] (println (decode znaki elem)))))
    ([] (do (println "Podaj tekst do odszyfrowania") (-main (read-line)))))