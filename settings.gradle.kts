pluginManagement {
    repositories {
        google()
        maven("https://jitpack.io")
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven("https://jitpack.io")
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "AlaskaSDK"
include(":app")
include(":AlaskaGemSdk")
