package sample

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

val reference = Foo.ONE
/**
 * Defined set of build flags, different from the feature flag or entitlement strings received from the digest downloads
 */
@Serializable
public enum class Bar {
    ONE,
    TWO
}

expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    fun name(): String
}

fun hello(): String = "Hello from ${Platform.name()}"