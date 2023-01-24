const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    lintOnSave: false,
    publicPath: './',
    outputDir: '/folder/docker/nginx_data/dasServer', //build之后静态文件输出路径
    configureWebpack: {
        experiments: {
            topLevelAwait: true,
        }
    }
})