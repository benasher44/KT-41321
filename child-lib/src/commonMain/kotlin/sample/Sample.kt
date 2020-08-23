package sample

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Foo {
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