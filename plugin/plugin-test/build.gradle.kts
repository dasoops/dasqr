ext["noPlugin"] = true


dependencies {
    rootProject.childProjects["plugin"]!!.childProjects.values.flatMap { it.childProjects.values }.forEach {
        api(it)
    }
}