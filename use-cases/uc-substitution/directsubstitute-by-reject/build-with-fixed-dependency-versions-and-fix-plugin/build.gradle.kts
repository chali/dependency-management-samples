plugins {
    `java-library`
}

apply { plugin<MyDependencyFixPlugin>() }

repositories {
    maven {
        setUrl("../../../repository/maven")
    }
}

dependencies {
    api("example.depman:platform-rejects:1.+")

    implementation("sustitutionrule:a:1.0.0")
    implementation("sustitutionrule:directsubstitute:2.0.0")
    implementation("sustitutionrule:arange0:1.0.0")
    implementation("sustitutionrule:arange1:1.0.0")
    implementation("sustitutionrule:asub:1.0.0")
}
