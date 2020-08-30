# Repro project for [KT-41321](https://youtrack.jetbrains.com/issue/KT-41321)

Repro steps:

1. cd into the child-lib and run ./gradlew publishToMavenLocal
2. cd in the main-lib and run ./gradlew compileKotlinIosX64

Seems to be something to do with (enum?) serializers across library boundaries on native.
