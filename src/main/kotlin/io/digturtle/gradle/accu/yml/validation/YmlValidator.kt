package io.digturtle.gradle.accu.yml.validation

/**
 * Represents a worker responsible for validating yml files.
 */
internal interface YmlValidator {
    /**
     * Will detect if a yml file is valid or not.
     */
    fun validate()
}

/**
 * Singleton instance of a [YmlValidator]
 */
internal object YmlValidatorImpl : YmlValidator {
    /**
     * Dummy validation method that claims everything is valid.
     */
    override fun validate() {
        println("Everything is valid unless proven otherwise!")
    }
}