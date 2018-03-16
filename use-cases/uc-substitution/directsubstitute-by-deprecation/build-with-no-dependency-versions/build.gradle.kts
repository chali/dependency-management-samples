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
    api("example.depman:platform-rich:1.+")

    implementation("sustitutionrule:directsubstitute")
    implementation("sustitutionrule:a")
    implementation("sustitutionrule:arange0")
    implementation("sustitutionrule:arange1")
}
