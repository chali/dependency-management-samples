plugins {
    `java-library`
}

repositories {
    maven {
        setUrl("../../repository/maven")
    }
}

dependencies {
    implementation("excluderule:goodlibrary:1.0.0")

    // A component metadata rule allow a library to be "fixed" everywhere (in contrast to an exclude on a dependency). The rule could be provided by a plugin.
    components {
        withModule("excluderule:goodlibrary") {
            allVariants {
                withDependencies {
                    removeAll { it.group == "excluderule" && it.name == "badlibrary" }
                }
            }
        }
    }
}
