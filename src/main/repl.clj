(ns main.repl
  (:require [def.multi :as mm]
            [def.m1]
            [def.m2]))

(defn reload-mm [mm-var]
  (let [current-var mm-var
        current-ns (.name (.ns current-var))
        current-sym (.sym current-var)

        namespaces-to-reload
        (into [current-ns]
              (when (instance? clojure.lang.MultiFn @current-var)
                (-> @current-var methods vals
                    (->> (map #(-> % class .getName Compiler/demunge
                                   (.split "/") first symbol))))))]
    (printf "Undefining %s/%s\n" current-ns current-sym)
    (ns-unmap current-ns current-sym)
    (run! (fn [ns-sym]
            (println " Reloading" ns-sym)
            (require ns-sym :reload))
          namespaces-to-reload)))

(comment
  (mm/x {:x 1})
  (reload-mm #'mm/x)
  (mm/x {:x {:type 1}})
  clojure.lang.MultiFn
  )
