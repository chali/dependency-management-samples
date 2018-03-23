A new concept in Gradle's dependency management are _rejected versions_.
_Dependency constraints_ that utilise _reject_ can be used to exclude selected versions from a range (this is work in progress).

**Use Case: A platform team forbids a certain version of a module**

The platform team publishes a platform (metadata with constraints).
All builds depend on this platform.
The platform team adds a reject for the blacklisted version.
The builds use version ranges and will automatically match other versions that are not rejected.
If no version can be found after a reject was added, a build author needs to update the corresponding build.

**Feedback / Questions**

Do we have any escape path for project which would like to go agains platform recommendation?