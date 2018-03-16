plugins {
    `java-library`
}

repositories {
    maven {
        setUrl("../../../repository/maven")
    }
}

dependencies {
    api("example.depman:platform-rejects:1.+")
    api("example.depman:platform-rich:1.+")

    implementation("sustitutionrule:a")
    implementation("sustitutionrule:directsubstitute")
    implementation("sustitutionrule:arange0")
    implementation("sustitutionrule:arange1")
    implementation("sustitutionrule:asub")

    //We don't need the fix plugin for the above, because the rich platform provides unified versions for
    //all builds, reducing the potential for conflict.
    //However this means that everyone will use the "highest" version from the rich platform.
    //This means that all lower versions are replaces (no matter if they are rejected or nor)

    //This rule can also go into a plugin
    components {
        withModule("sustitutionrule:asub") {
            allVariants {
                withDependencies {
                    val subAll = find {it.name == "sub-all"}!!
                    add("${subAll.group}:sub-core:${subAll.versionConstraint.preferredVersion}") {
                        because("sub-all is forbidden and we can work with sub-core here")
                    }
                    remove(subAll)
                }
            }
        }
    }
}
