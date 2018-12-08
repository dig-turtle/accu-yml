package io.digturtle.gradle.accu.yml

internal data class YmlPluginProperties(val paths: List<String> = emptyList(), val duplicateKeys: Boolean = false, val recursive: Boolean = false)

internal object Tasks {
    const val check = "check"
    const val accuYml = "accuYml"
}

