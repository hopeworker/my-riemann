(def foo-stream
  (where (service "foo")
    (tap :foo)))

(tests
  (deftest foo-test
    ;; inject in foo-stream only
    (let [result (inject! [riemann.config/foo-stream]
                   [{:host "localhost"
                     :service "foo"
                     :metric 10}])]
      (is (= [{:host "localhost"
               :service "foo"
               :metric 10}]
              (:foo result))))))