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

**Use Case 1: A platform team forbids/blacklist a certain version of a module**

See: [uc-reject](../uc-reject/README.md)

**Use Case 2: A platform team wants to deprecate a version of a module**

All builds apply a [deprecation plugin](substitute-by-deprecation/build-with-no-dependency-versions/buildSrc/src/main/kotlin/MyDeprecationPlugin.kt).
The plugin uses attributes to mark selected module versions as deprecated.
The plugin can read information from an external service to update the deprecations without updating the plugin itself.
The deprecation can break an existing build, which the build author has to update. 
If necessary, an opt-out (using a deprecated version) is possible, but needs to be explicitly declared in the build.

**Use Case 3: Following up a blacklisting/deprecation, a platform team wants to provide an automatic fix**

_If builds use no versions or version ranges and the platform team provides a platform with dependency constraints:_
The platform team publishes a new version of the platform with updated versions.

_If builds use fixed versions but still fixes should be provided_:
The platform team publishes a [plugin](substitute-by-deprecation/build-with-fixed-dependency-versions-and-fix-plugin/buildSrc/src/main/kotlin/MyDependencyFixPlugin.kt) with "fix" rules that replace certain versions.

**Feedback / Questions**

How to solve substitution of one module by another module? Original example sub-all -> sub-core.
Substitution range to one version (Deprecate the whole range) is not implemented. Will it be or we have to do it?
Right now we are proving fixes for deprecation as part of our rule. Do we need deprecation or just applying fix plugin would work? My understanding is that after all features are implemented FixPlugin won't be neccessary.
Example how to opt out from the platform provided rule (prefer is probably easy. how about reject, strict?)

