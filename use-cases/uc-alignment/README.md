Version alignment can be solved by using dependency constraints.
For that we group modules that should be aligned into a _module set_.
Then we a add constraints between each module of a set and its siblings.

**Use Case 1: Alignment is enforced by the modules themselves**

If the author of a set of modules knows that they should always be aligned, the constraints can directly be published as part of the metadata of each module.


**Use Case 2: Alignments are provided by a platform team**

The alignment pattern can be encapsulated in a [simple plugin](align-with-constraints/buildSrc/src/main/kotlin/AlignPlugin.kt).
Other features (like exclude) can also be modelled.
The plugin can read information from an external service to update the rules without updating the plugin itself.

**Feedback / Questions**

Output of `./gradlew dependencies`. Why `alignmentrule:align0:1.0.1 -> 1.1.0` shows dependencies underneath? Similar case can be seen in direct dependencies alingment. Only force is not showing like this.

    +--- alignmentrule:b0:1.+ -> 1.0.0
    |    \--- alignmentrule:align0:1.0.1 -> 1.1.0
    |         \--- alignmentrule:align1:1.1.0
    |              \--- alignmentrule:align0:1.1.0 (*)
    +--- alignmentrule:b1:1.+ -> 1.0.0
    |    \--- alignmentrule:align1:1.1.0 (*)

Do we know how the Use Case 1: would look like?