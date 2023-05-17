package com.dasoops.dasqr.core.loader

import com.dasoops.common.core.util.resources.Resources
import java.io.File

fun Resources.get(name: String) =
    File(System.getProperty("user.dir") + "/resources/" + name)
