const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  publicPath: './',
  outputDir:  '/var/lib/docker/volumes/nginx_data/_data/', //build之后静态文件输出路径
})
