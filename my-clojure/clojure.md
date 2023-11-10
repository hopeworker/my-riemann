


## Basic structure

### Put together
```clojure
(+ 1 (- 5 2) (+ 3 4))
(+ 1 3       (+ 3 4))
(+ 1 3       7)
11
```

The single quote ' escapes a sentence
A quote says “Rather than evaluating this expression’s text, 
simply return the text itself, unchanged.”


A sentence in Lisp is a list. 
It starts with a verb, and is followed by zero or more objects for that verb to act on. Each part of the list can itself be another list, in which case that nested list is evaluated first, just like a nested clause in a sentence.



## Types

### Put together

```clojure
{:title "Chocolate chip cookies"
 :ingredients {"flour"           [(+ 2 1/4) :cup]
               "baking soda"     [1   :teaspoon]
               "salt"            [1   :teaspoon]
               "butter"          [1   :cup]
               "sugar"           [3/4 :cup]
               "brown sugar"     [3/4 :cup]
               "vanilla"         [1   :teaspoon]
               "eggs"            2
               "chocolate chips" [12  :ounce]}}
```

### Symbols

Symbols can have either short or full names. The short name is used to refer to things locally. The fully qualified name is used to refer unambiguously to a symbol from anywhere.
Symbol names are separated with a /. For instance, the symbol str is also present in a family called clojure.core; the corresponding full name is clojure.core/str

```clojure
user=> (class 'str)
clojure.lang.Symbol

user=> (= str clojure.core/str)
true
```

### Keyword

which begin with a : 
Keywords are like strings in that they’re made up of text, but are specifically intended for use as labels or identifiers.
```clojure
user=> (type :cat)
clojure.lang.Keyword
user=> (str :cat)
":cat"
user=> (name :cat)
"cat"
```

### List

```clojure
user=> (type '(1 2 3))
clojure.lang.PersistentList
```
Remember, we quote lists with a ' to prevent them from being evaluated. 

You can also construct a list using list:
```clojure
user=> (list 1 2 3)
(1 2 3)

(first (list 1 2 3))
(second (list 1 2 3))
(nth (list 1 2 3) 2)

```

### Vector
```clojure
[1 2 3]

(first [1 2 3])
(rest [1 2 3])
(count [1 2 3])
(conj [1 2 3] 4)
([:a :b :c] 1)
```


### Set

```clojure
#{:a :b :c}
```

### Map
```clojure
user=> {:name "mittens" :weight 9 :color "black"}
{:weight 9, :name "mittens", :color "black"}

(get {:a 1 :b 2} :a)

({"amlodipine" 12 "ibuprofen" 50} "ibuprofen")

(:raccoon {:weasel "queen" :raccoon "king"})

user=> (assoc {:bolts 1088} :camshafts 3)
{:camshafts 3 :bolts 1088}
user=> (assoc {:camshafts 3} :camshafts 2)
{:camshafts 2}

```

## Function

### Let

```clojure
user=> (let [person   "joseph"
             num-cats 186]
         (str person " has " num-cats " cats!"))
"joseph has 186 cats!"

user=> (let [cats 3
             legs (* 4 cats)]
         (str legs " legs all together"))
"12 legs all together"
```


### function

```clojure
((fn [x] 
    (+ x 1) 
    (println "after first expression")
    (println "x is" x)) 2)

user=> (let [twice (fn [x] (* 2 x))]
         (+ (twice 1)
            (twice 3)))
8
```

#### Shorthand for writing functions

#(+ % 1) is equivalent to (fn [x] (+ x 1)). 
% takes the place of the first argument to the function. 
You’ll sometime see %1, %2, etc.


### Var

```clojure
user=> (def cats 5)
#'user/cats
user=> (type #'user/cats)
clojure.lang.Var
user=> user/cats
5

```

### Define function

```clojure
user=> (def half (fn [number] (/ number 2)))
#'user/half
user=> (half 6)
3
```

defn, short for def fn

#### Handle multiple arities

```clojure
user=> (defn half
         ([]  1/2)
         ([x] (/ x 2)))
user=> (half)
1/2
user=> (half 10)
5
```

#### take any number of arguments

```clojure
user=> (defn vargs
         [x y & more-args]
         {:x    x
          :y    y
          :more more-args})
#'user/vargs
user=> (vargs 1)

ArityException Wrong number of args (1) passed to: user$vargs  clojure.lang.AFn.throwArity (AFn.java:437)
user=> (vargs 1 2)
{:x 1, :y 2, :more nil}
user=> (vargs 1 2 3 4 5)
{:x 1, :y 2, :more (3 4 5)}
```

### See source

(source type)