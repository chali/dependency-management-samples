plugins {
    `java-library`
}

apply { plugin<AlignPlugin>() }

repositories {
    maven {
        setUrl("../../repository/maven")
    }
}

dependencies {
    implementation("example.depman:platform-rejects:1.+")

    //currently fails, but will be fixed
    implementation("rejectrule:reject:1.+")
}
