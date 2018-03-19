plugins {
    `java-library`
    `maven-publish`
}

group = "example.depman"
version = "1.0.0"

dependencies {
    constraints {
        add("api", "sustitutionrule:substitute") {
            version { reject("1.0.0") }
            because("version 1.0.0 is blacklisted because it was accidentally released from dev_branch")
        }
        add("api", "sustitutionrule:directsubstitute") {
            version { reject("2.0.0") }
            because("version 2.0.0 is blacklisted because it was accidentally released from dev_branch")
        }
        add("api", "sustitutionrule:rangesubstitute") {
            version { reject("[2.0.0,2.5.0]") }
            because("range is blacklisted because it contains a bug")
        }
        add("api", "sustitutionrule:rangesubstitute") {
            version { reject("[2.0.0,2.5.0]") }
            because("range is blacklisted because it contains a bug")
        }
        add("api", "sustitutionrule:sub-all") {
            version { rejectAll() }
            because("sub-all is pure evil")
        }
        add("api", "rejectrule:reject") {
            version { reject("1.0.1") }
        }
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["javaLibraryPlatform"])
    }
    repositories {
        maven {
            name = "example"
            setUrl("../repository/maven")
        }
    }
}