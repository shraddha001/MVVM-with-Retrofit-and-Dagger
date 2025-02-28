pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MVVM with dagger"
include(":app")
include(":api")
include(":repository")
include(":database")

project(":api").projectDir = File(rootDir, "base/api")
project(":repository").projectDir = File(rootDir, "base/repository")
project(":database").projectDir = File(rootDir, "base/database")
