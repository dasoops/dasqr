package com.dasoops.dasqr.core.loader

import java.net.URL
import java.net.URLClassLoader

open class DasqrUrlClassLoader(vararg url: URL) : URLClassLoader(url)