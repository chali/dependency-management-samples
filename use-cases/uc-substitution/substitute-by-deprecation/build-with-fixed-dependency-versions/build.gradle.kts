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
    // This fails (as expected)
    // Note that the error message in the report (it currently just says FAILED in dependencyInsight) will be improved.
    // You already get a more descriptive error if you run a "./gradlew build"
    implementation("sustitutionrule:a:1.0.0")
    implementation("sustitutionrule:directsubstitute:2.0.0")
    implementation("sustitutionrule:arange0:1.0.0")
    implementation("sustitutionrule:arange1:1.0.0")
}
