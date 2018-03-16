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

    //this could be published (see comments below), or rules could be be provided by plugin
    components {
        withModule("replacerule:replacee") {
            val version = id.version
            allVariants {
                withCapabilities {
                    addCapability("replacerule", "replacee", version) //latest 4.7 nightly would add this automatically (same GAV as module)
                }
            }
        }
        withModule("replacerule:replacement") {
            val version = id.version
            allVariants {
                withCapabilities {
                    addCapability("replacerule", "replacee", version) //if replacement knows that it replaces 'replacee', this can be published with replacement
                }
            }
        }
    }
}
