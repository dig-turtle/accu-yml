package io.digturtle.gradle.accu.yml

import io.digturtle.gradle.accu.yml.validation.YmlValidator
import io.digturtle.gradle.accu.yml.validation.YmlValidatorImpl

/**
 * This factory is responsible for providing instances of other classes to the gradle plugin code to allow it to be testable.
 */
internal interface Factory {
    /**
     * Factory method for a [YmlValidator]
     */
    fun validator(): YmlValidator
}

/**
 * A singleton instance of a factory.
 */
internal object ObjectFactory : Factory {

    /**
     * Return a singleton instance of the [YmlValidator]
     */
    override fun validator(): YmlValidator {
        return YmlValidatorImpl
    }

}