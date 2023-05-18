dependencies {
    api(project(":plugin:plugin-core"))
}

subprojects {
    val workingDir = rootProject.ext["dasqrWorkingDir"] as String
    tasks.named<Jar>("jar") {
        manifest.attributes["Plugin-Name"] = "No Name"
        manifest.attributes["Plugin-Author"] = "No Author"
        manifest.attributes["Plugin-Version"] = "No Version"
        manifest.attributes["Plugin-Description"] = "No Description"
    }
    tasks.withType<Jar> {
        this.archiveFileName.set("${this@subprojects.name}.jar")
        this.doLast {
            try {
                if (ext.get("noPlugin") != true) {
                    outputs.files.forEach {
                        it.copyTo(File("$workingDir/plugin/${it.name}"), true)
                    }
                }
            } catch (e: ExtraPropertiesExtension.UnknownPropertyException) {
                outputs.files.forEach {
                    it.copyTo(File("$workingDir/plugin/${it.name}"), true)
                }
            }
        }
    }
}


