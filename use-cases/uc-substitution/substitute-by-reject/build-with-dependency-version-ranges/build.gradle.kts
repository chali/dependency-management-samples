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

    // This fails as "a" is not published with a range for "substitute" - "sustitutionrule:substitute:[1.0.0,2.0.0))"
    // This scenario is to work with ranges consistently, so it should be published with a range
    // implementation("sustitutionrule:a:[1.0.0,2.0.0)")
    implementation("sustitutionrule:directsubstitute:[2.0.0,3.0.0)")
    // Same issues as above - "arange0" and "arange1" are not published with ranges in their dependencies
    // implementation("sustitutionrule:arange0:1.0.0")
    // implementation("sustitutionrule:arange1:1.0.0")
}
