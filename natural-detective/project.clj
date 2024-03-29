(defproject natural-detective "0.1.0-SNAPSHOT"
            :description "A Serious Game for Learning Natural Deduction in Propositional Logic"
            :url "https://github.com/adjl/NaturalDetective"
            :dependencies [[org.clojure/clojure "1.8.0"]
                           [org.clojure/clojurescript "1.9.293"]
                           [org.clojure/core.match "0.3.0-alpha4"]
                           [org.clojure/tools.namespace "0.2.11"]
                           [org.clojure/tools.nrepl "0.2.12"]
                           [com.cemerick/piggieback "0.2.1"]
                           [cljsjs/phaser "2.6.1-0"]
                           [proto-repl "0.3.1"]]
            :plugins [[lein-cljsbuild "1.1.4"]
                      [lein-figwheel "0.5.8"]]
            :aliases {"update" ["do" "clean," "deps," "check"]
                      "cljstest" ["do" "clean," "cljsbuild" "auto" "test"]}
            :clean-targets ^{:protect false} [".lein-failures"
                                              "figwheel_server.log"
                                              "resources/public/js"
                                              "resources/test/game-test.js"
                                              :target-path]
            :cljsbuild {:builds
                        {:dev {:source-paths ["src"]
                               :figwheel true
                               :compiler {:main "game.core"
                                          :output-to "resources/public/js/game.js"
                                          :output-dir "resources/public/js"
                                          :asset-path "js"}}
                         :test {:source-paths ["src" "test"]
                                :notify-command ["bin/phantomjs"
                                                 "resources/test/test.js"
                                                 "resources/test/test.html"]
                                :compiler {:output-to "resources/test/game-test.js"
                                           :optimizations :whitespace}}}
                        :test-commands {"test" ["bin/phantomjs"
                                                "resources/test/test.js"
                                                "resources/test/test.html"]}}
            :figwheel {:css-dirs ["resources/public/css"]
                       :builds-to-start [:dev]
                       :nrepl-host "localhost"
                       :nrepl-port 7888
                       :validate-interactive :fix})
