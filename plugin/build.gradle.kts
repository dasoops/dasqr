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
    this.ext.set("aoe",true)
    tasks.withType<Jar> {
        this@subprojects.name
        this.archiveFileName.set("${this@subprojects.name}.jar")
        this.doLast {
            outputs.files.forEach {
                it.copyTo(File("$workingDir/plugin/${it.name}"), true)
            }
        }
    }
}


