(ns def.m2
  (:require [def.multi :as mm]))

(defmethod mm/x 2 [v] (prn v))
