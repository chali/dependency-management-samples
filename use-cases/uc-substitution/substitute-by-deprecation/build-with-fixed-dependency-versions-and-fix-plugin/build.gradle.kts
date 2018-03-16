plugins {
    `java-library`
}

apply {
    plugin<MyDeprecationPlugin>()
    plugin<MyDependencyFixPlugin>()
}

repositories {
    maven {
        setUrl("../../../repository/maven")
    }
}

dependencies {
    implementation("sustitutionrule:a:1.0.0")
    implementation("sustitutionrule:directsubstitute:2.0.0")
    implementation("sustitutionrule:arange0:1.0.0")
    implementation("sustitutionrule:arange1:1.0.0")
}
