(defproject hobbit-violence "0.1.0-SNAPSHOT"
  :description "Application created in the 'Clojure for the brave and true' book"
  :url "https://www.github.com/fabioueno/clojure-for-the-brave-and-true"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot hobbit-violence.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})