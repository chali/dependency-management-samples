A new concept in Gradle's dependency management are _capabilities_.
A _capability_ allows you to express that two modules at different coordinates provide the same feature.
For example, `google-collections` and `guava` both provide the `google-collections` capability.
Gradle will then only choose one (or fail with conflict) if both modules are present in the dependency graph (this is work in progress).
