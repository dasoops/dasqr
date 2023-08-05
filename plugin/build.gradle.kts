dependencies {
    api(project(":plugin:plugin-core"))
}

subprojects {
    val workingDir = rootProject.ext["dasqrWorkingDir"] as String
    tasks.withType<Jar> {
        manifest.attributes["Plugin-Name"] = "No Name"
        manifest.attributes["Plugin-Author"] = "No Author"
        manifest.attributes["Plugin-Version"] = "No Version"
        manifest.attributes["Plugin-Description"] = "No Description"
        archiveFileName.set("dasqr-${this@subprojects.name}.jar")
        this.doLast {
            try {
                if (ext.get("noPlugin") != true) {
                    copy(workingDir)
                }
            } catch (e: ExtraPropertiesExtension.UnknownPropertyException) {
                copy(workingDir)
            }
            var log = ""
            copy {
                if (project.name == "plugin-core") return@copy
                from(project.configurations.runtimeClasspath)
                exclude {
                    it.file.name.run {
                        contains("dasqr-plugin")
                    }.apply {
                        if (!this) log += "${it.file.name}\n"
                    }
                }
                into("$workingDir/plugin/libs")
            }
            File("$workingDir/plugin/libs/log").mkdirs()
            File("$workingDir/plugin/libs/log/${project.name}.log").apply {
                createNewFile()
                writeText(log)
            }
        }
    }
}


fun Task.copy(workingDir: String) {
    outputs.files.forEach {
        it.copyTo(File("$workingDir/plugin/${it.name}"), true)
    }
}