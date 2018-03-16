plugins {
    `java-library`
    `maven-publish`
}

group = "example.depman"
version = "1.0.0"

dependencies {
    constraints {
        add("api", "sustitutionrule:a") {
            version { prefer("1.0.0") }
        }
        add("api", "sustitutionrule:arange0") {
            version { prefer("1.0.0") }
        }
        add("api", "sustitutionrule:arange1") {
            version { prefer("1.0.0") }
        }
        add("api", "sustitutionrule:asub") {
            version { prefer("1.0.0") }
        }
        add("api", "sustitutionrule:substitute") {
            version { prefer("1.0.1") }
            because("Older versions are outdated or buggy")
        }
        add("api", "sustitutionrule:directsubstitute") {
            version { prefer("2.1.0") }
            because("Older versions are outdated or buggy")
        }
        add("api", "sustitutionrule:rangesubstitute") {
            version { prefer("2.5.1") }
            because("Older versions are outdated or buggy")
        }
        add("api", "sustitutionrule:sub-core") {
            version { prefer("1.0.0") }
            because("User sub-core (and never sub-all)")
        }
    }
}

publishing {
    publications.create("maven", MavenPublication::class.java) {
        from(components.get("javaLibraryPlatform"))
    }
    repositories {
        maven {
            name = "example"
            setUrl("../repository/maven")
        }
    }
}