Excluding a "bad module" can be done by using a component metadata rule, which removes all (or selected) dependencies to that modules before resolution starts.
Such rules can be shared among builds via simple plugins.

**Use Case: A platform team provides fix rules**

The rules can be applied by a simple plugin using the component metadata rules API.
The plugin can read information from an external service to update the rules without updating the plugin itself.
