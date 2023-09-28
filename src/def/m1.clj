(ns def.m1
  (:require [def.multi :as mm]))

(defmethod mm/x 1 [v] (prn v))
