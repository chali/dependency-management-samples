"Dependency substitution" is currently used to address a variety of use cases.
The [Nebula samples](https://github.com/nebula-plugins/example-project/blob/master/README.md#2-resolution-rules) mostly talk about replacing a deprecated/blacklisted version of a modules with a newer one.

There are two new features in Gradle's dependency management that could be utilized: _attributes_ and _rejected versions_ (both are work in progress).
Modelling deprecation/blacklisting as a _Lifecycle_ attribute seems to be the better modelling for such use cases.

Another aspect is the general approach for how and where dependency versions are defined and shared among multiple builds.
Here we illustrate several solutions utilizing both _attributes_ and _rejected versions_ for comparision:

- Using a **Lifecycle Attribute**:
  - [build-with-fixed-dependency-versions](substitute-by-deprecation/build-with-fixed-dependency-versions/build.gradle.kts)
  - [build-with-fixed-dependency-versions-and-fix-plugin](substitute-by-deprecation/build-with-fixed-dependency-versions-and-fix-plugin/build.gradle.kts)
  - [build-with-no-dependency-versions](substitute-by-deprecation/build-with-no-dependency-versions/build.gradle.kts)
  - [build-with-dependency-version-ranges](substitute-by-deprecation/build-with-dependency-version-ranges/build.gradle.kts)

- Using **Rejected Versions**:
  - [build-with-fixed-dependency-versions](substitute-by-reject/build-with-fixed-dependency-versions/build.gradle.kts)
  - [build-with-fixed-dependency-versions-and-fix-plugin](substitute-by-reject/build-with-fixed-dependency-versions-and-fix-plugin/build.gradle.kts)
  - [build-with-no-dependency-versions](substitute-by-reject/build-with-no-dependency-versions/build.gradle.kts)
  - [build-with-dependency-version-ranges](substitute-by-reject/build-with-dependency-version-ranges/build.gradle.kts)

