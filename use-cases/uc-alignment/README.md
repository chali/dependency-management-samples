Version alignment can be solved by using dependency constraints.
For that we group modules that should be aligned into a _module set_.
Then we a add constraints between each module of a set and its siblings.

This pattern can be encapsulated in a [simple plugin](align-with-constraints/buildSrc/src/main/kotlin/AlignPlugin.kt).
Other features (like exclude) can also be modelled.
