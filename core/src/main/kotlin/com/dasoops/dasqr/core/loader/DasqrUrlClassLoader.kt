package com.dasoops.dasqr.core.loader

import java.net.URLClassLoader

object DasqrUrlClassLoader : URLClassLoader(DasqrRunner.loadUrl)