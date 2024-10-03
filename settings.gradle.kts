pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
}
rootProject.name = "cangjieplayground"

include(":shared")
include(":server")
include(":agent")
