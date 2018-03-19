A new concept in Gradle's dependency management are _capabilities_.
A _capability_ allows you to express that two modules at different coordinates provide the same feature.
For example, `google-collections` and `guava` both provide the `google-collections` capability.
Gradle will then only choose one (or fail with conflict) if both modules are present in the dependency graph (this is work in progress).

**Use Case 1: A library author changes the GA coordinates of the library**

The library publishes the information that the module at the new GA provides the capability of the old GA.

**Use Case 2: Capability information is missing and a platform team wants to provide it**

The platform team provides a simple plugin that adds the missing capability information.
All builds apply the plugin.