plugins {
    `java-library`
}

repositories {
    maven {
        setUrl("../../repository/maven")
    }
}

dependencies {
    implementation("replacerule:replacementex0:1.0.0")
    implementation("replacerule:replacementex1:1.0.0")

    // the information added in this metadata rule could be published (see comments below),
    // or the rule could be be provided by a plugin
    components {
        withModule("replacerule:replacement") {
            val version = id.version
            allVariants {
                withCapabilities {
                    // If replacement knows that it replaces 'replacee' when it is published,
                    // this capability can be published
                    addCapability("replacerule", "replacee", version)
                }
            }
        }
    }
}
