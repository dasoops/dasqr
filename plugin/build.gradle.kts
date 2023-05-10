dependencies {
    api(project(":plugin:plugin-core"))
}

subprojects {
    tasks.named<Jar>("jar") {
        manifest.attributes["Plugin-Name"] = "No Name"
        manifest.attributes["Plugin-Author"] = "No Author"
        manifest.attributes["Plugin-Version"] = "No Version"
        manifest.attributes["Plugin-Description"] = "No Description"
    }
    tasks.withType<Jar> {
        this.doLast {
            val workingDir = rootProject.ext["dasqrWorkingDir"] as String
            outputs.files.forEach {
                it.copyTo(File("$workingDir/plugin/${it.name}"))
            }
        }
    }
}


