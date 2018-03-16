plugins {
    `java-library`
}

apply { plugin<MyDeprecationPlugin>() }

repositories {
    maven {
        setUrl("../../../repository/maven")
    }
}

dependencies {
    //Note: this works as we have a higher version as the deprecated one.
    //If we would deprecate the highest version it currently (Gradle 4.6) does not work
    //But we are currently adding this functionality (selecting a lower version if the highest does not fit)
    implementation("sustitutionrule:directsubstitute:[2.0,3.0)")

    // This fails as "a" is not published with a range for "substitute" - "sustitutionrule:substitute:[1.0.0,2.0.0))"
    // This scenario is to work with ranges consistently, so it should be published with a range
    // implementation("sustitutionrule:a:[1.0.0,2.0.0)")

    // Same issues as above - "arange0" and "arange1" are not published with ranges in their dependencies
    // implementation("sustitutionrule:arange0:1.0.0")
    // implementation("sustitutionrule:arange1:1.0.0")
}
