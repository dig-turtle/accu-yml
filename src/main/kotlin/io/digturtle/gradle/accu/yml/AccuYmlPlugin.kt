package io.digturtle.gradle.accu.yml

import org.gradle.api.Plugin
import org.gradle.api.Project

import io.digturtle.gradle.accu.yml.Tasks.check
import io.digturtle.gradle.accu.yml.Tasks.accuYml

class AccuYmlPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            val ymlPluginProperties = extensions.create("accu-yml", YmlPluginProperties::class.java)
            @Suppress("UnstableApiUsage") // this create() is incubating.
            val accuYmlTask = tasks.create(accuYml, AccuYmlTask::class.java, ymlPluginProperties, ObjectFactory)
            tasks.all {
                if (it.name == check){
                    it.dependsOn(accuYmlTask)
                }
            }
        }
    }

}