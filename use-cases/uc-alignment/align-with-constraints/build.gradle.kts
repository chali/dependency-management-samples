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
    constraints {
        implementation("alignmentrule:alignforce0:2.0.0")
     }

    implementation("alignmentrule:b0:1.+")
    implementation("alignmentrule:b1:1.+")
    implementation("alignmentrule:direct-align0:1.0.1")
    implementation("alignmentrule:direct-align1:1.1.0")
    implementation("alignmentrule:exclude-b0:1.+")
    implementation("alignmentrule:exclude-b1:1.+")
    implementation("alignmentrule:exclude-b2:1.+")
    implementation("alignmentrule:bforce0:[1.0.0,2.0.0)")
    implementation("alignmentrule:bforce1:[1.0.0,2.0.0)")
}
