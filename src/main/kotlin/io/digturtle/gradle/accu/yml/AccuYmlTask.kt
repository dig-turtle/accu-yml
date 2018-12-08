package io.digturtle.gradle.accu.yml

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

/**
 * The primary task of the accu-yml plugin. It receives a [ymlPluginProperties] and [factory] from Gradle via the [AccuYmlPlugin].
 *
 * It binds itself to the verification group.  The [ymlPluginProperties] is an input, and will cause the plugin to re-do it's work if they change.
 * // TODO: Make all *.yml & *.yaml files @Input's.
 */
class AccuYmlTask internal constructor(@Input val ymlPluginProperties: YmlPluginProperties, private val factory: Factory) : DefaultTask() {
/**
 * These are examples of inputs / outputs to the task, that would cause gradle to not re-run if they haven't changed.
 *
    @OutputFile
    val outputFile: File = File(project.testKitDir(), "file-we-write.txt")
    @Input
    val configuration: Configuration = project.configurations.getByName(Configurations.property)
    @Input
    var destinationJar = "${project.buildDir}/build/some.jar"
    */
    init {
        group = "verification"
        description = "Validates the format of all specified yml files."
    }

    /**
     * This is the entry point of the task, and is the entry point of all the validation work by Gradle.
     */
    @TaskAction
    fun validateYmlFiles() {
        // TODO: Actual plugin work is done here.
        // TODO: Only do anything GRADLE specific in this file.
    }
}