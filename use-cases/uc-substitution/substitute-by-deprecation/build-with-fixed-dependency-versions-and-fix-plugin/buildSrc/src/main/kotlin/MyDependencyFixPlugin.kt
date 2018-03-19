
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.ConfigurationContainer
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

open class MyDependencyFixPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        // This information could be retrieved from an external service
        project.configurations.substitute("sustitutionrule", "directsubstitute", "2.0.0", "2.1.0")
        project.dependencies.substitute("sustitutionrule", "substitute", "1.0.0", "1.0.1")

        // Lists all known versions of "rangesubstitute"
        // A limitation is that this does not do range matching. That is, you can not just do substitute("[2.0.0,2.5.0]", "2.5.1") and it will
        // adjust all declaration that fit into the range.
        project.dependencies.substitute("sustitutionrule", "rangesubstitute", "2.0.0", "2.5.1")
        project.dependencies.substitute("sustitutionrule", "rangesubstitute", "2.2.0", "2.5.1")
    }

    /**
     * Fixing things in the build script.
     */
    private fun ConfigurationContainer.substitute(group: String, name: String, from: String, to: String) {
        all {
            withDependencies {
                filter { it is ExternalModuleDependency && it.group == group && it.name == name && it.version == from }.forEach { dependency ->
                    (dependency as ExternalModuleDependency).version {
                        prefer(to)
                    }
                    dependency.because("Build script auto-fix for $group.$name: substituted $from with $to")
                }
            }
        }
    }

    /**
     * Fixing things in external dependencies.
     */
    private fun DependencyHandler.substitute(group: String, name: String, from: String, to: String) {
        components.all {
            val currentModule = id
            allVariants {
                withDependencies {
                    filter { it.group == group && it.name == name && it.versionConstraint.preferredVersion == from }.forEach { dependency ->
                        dependency.version {
                            prefer(to)
                        }
                        dependency.because("$currentModule - published metadata fix for dependency $group.$name: substituted $from with $to")
                    }
                }
            }
        }
    }
}
