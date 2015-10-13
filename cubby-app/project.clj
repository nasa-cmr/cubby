(defproject nasa-cmr/cmr-cubby-app "0.1.0-SNAPSHOT"
  :description "Provides a centralized caching service for the CMR. See README for details."
  :url "***REMOVED***projects/CMR/repos/cmr/browse/cubby-app"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [nasa-cmr/cmr-common-lib "0.1.1-SNAPSHOT"]
                 [nasa-cmr/cmr-common-app-lib "0.1.0-SNAPSHOT"]
                 [nasa-cmr/cmr-transmit-lib "0.1.0-SNAPSHOT"]
                 [compojure "1.4.0"]
                 [ring/ring-core "1.4.0" :exclusions [clj-time]]
                 [ring/ring-json "0.4.0"]
                 [org.clojure/tools.nrepl "0.2.11"]
                 [nasa-cmr/cmr-elastic-utils-lib "0.1.0-SNAPSHOT"]
                 [nasa-cmr/cmr-acl-lib "0.1.0-SNAPSHOT"]]
  :plugins [[lein-test-out "0.3.1"]
            [lein-exec "0.3.2"]]
  :repl-options {:init-ns user}
  :profiles
  {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]
                        [org.clojars.gjahad/debug-repl "0.3.3"]
                        [pjstadig/humane-test-output "0.7.0"]
                        [nasa-cmr/cmr-mock-echo-app "0.1.0-SNAPSHOT"]]
         :source-paths ["src" "dev" "test" "int_test"]
         :injections [(require 'pjstadig.humane-test-output)
                      (pjstadig.humane-test-output/activate!)]}
   :uberjar {:main cmr.cubby.runner
             :aot :all}}
  :test-paths ["int_test"]
  :aliases {;; Prints out documentation on configuration environment variables.
            "env-config-docs" ["exec" "-ep" "(do (use 'cmr.common.config) (print-all-configs-docs) (shutdown-agents))"]})


