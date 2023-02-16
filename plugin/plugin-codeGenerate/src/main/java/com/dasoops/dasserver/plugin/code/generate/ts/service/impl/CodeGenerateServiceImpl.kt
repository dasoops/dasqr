package com.dasoops.dasserver.plugin.code.generate.ts.service.impl

import cn.hutool.core.util.TypeUtil
import com.alibaba.fastjson2.JSON
import com.alibaba.fastjson2.contains
import com.dasoops.common.entity.param.base.BaseFastBuildParam
import com.dasoops.common.entity.param.base.BaseParam
import com.dasoops.common.entity.param.base.IParam
import com.dasoops.common.entity.vo.base.IVo
import com.dasoops.common.util.Assert
import com.dasoops.dasserver.plugin.code.generate.ts.entity.dto.EntityInfo
import com.dasoops.dasserver.plugin.code.generate.ts.entity.dto.ExportCodeInfo
import com.dasoops.dasserver.plugin.code.generate.ts.entity.dto.FieldInfo
import com.dasoops.dasserver.plugin.code.generate.ts.entity.dto.RequestInfo
import com.dasoops.dasserver.plugin.code.generate.ts.entity.enums.ClassTypeEnum
import com.dasoops.dasserver.plugin.code.generate.ts.entity.param.GetExportCodeDataParam
import com.dasoops.dasserver.plugin.code.generate.ts.service.CodeGenerateService
import com.github.xiaoymin.knife4j.annotations.ApiSupport
import io.swagger.annotations.Api
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import io.swagger.annotations.ApiOperation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.io.File
import java.lang.reflect.Field
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.net.URL
import java.util.*
import java.util.jar.JarFile
import java.util.stream.Collectors

const val GENERATE_TYPE_PLACEHOLDER = "_Variable";

/**
 * @Title: CodeGenerateServiceImpl
 * @ClassPath com.dasoops.dasserver.plugin.code.generate.ts.service.impl.CodeGenerateServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/15
 * @Version 1.0.0
 * @Description: 编号生成服务impl
 * @see [CodeGenerateServiceImpl]
 */
@Service
class CodeGenerateServiceImpl : CodeGenerateService {

    val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun getExportCodeData(param: GetExportCodeDataParam): ExportCodeInfo {
        Assert.getInstance().allMustNotNull(param.basePath)
        log.info("开始获取导出代码信息,basePath: ${param.basePath}")

        //构建路径
        val basePath = buildBasePath(param.basePath!!)
        log.info("构建路径,path: $basePath")

        //扫描所有Class,获取实体类和接口
        val classLoader = this::class.java.classLoader
        val (entitySet, controllerSet) = scanClassSaveToSet(classLoader, basePath)

        return ExportCodeInfo().apply {
            val entityMap = resloveEntity(entitySet)
            entityList.addAll(entityMap.values.toList())
            requestList.addAll(resloveRequest(controllerSet, entityMap))
            log.info("entityList: ${JSON.toJSONString(entityList)}")
            log.info("requestList: ${JSON.toJSONString(requestList)}")
        }
    }

    /**
     * 构建基本路径
     * @param [basePath] 基本路径
     * @return [String]
     */
    private fun buildBasePath(basePath: String): String {
        val path = with(basePath) {
            removeSuffix("/")
        }
        return path.replace(".", "/")
    }

    /**
     * 扫描路径保存到set
     * @param [classLoader] 类加载器
     * @param [basePath] 基本路径
     * @return [Pair<Set<Class<*>>, Set<Class<*>>>] [Pair<entitySet,RequestSet>]
     */
    private fun scanClassSaveToSet(
        classLoader: ClassLoader,
        basePath: String
    ): Pair<Set<Class<*>>, Set<Class<*>>> {
        val classSet = HashSet<Class<*>>()

        //根据url类型获取资源
        val resources: Enumeration<URL> = classLoader.getResources(basePath)
        while (resources.hasMoreElements()) {
            val url = resources.nextElement()
            if (url.protocol == "file") {
                val file = File(url.file)
                scanClassSaveToSet(classLoader, basePath, file, classSet)
            } else if (url.protocol == "jar") {
                //去除前缀和后面的路径
                val filePath = with(url.file) {
                    this.substring(6, this.lastIndexOf("!"))
                }
                val file = File(filePath)
                scanJarSaveToSet(classLoader, basePath, file, classSet)
            }
        }

        //分类
        val entitySet = HashSet<Class<*>>()
        val requestSet = HashSet<Class<*>>()

        classSet.forEach {
            when (getClassType(it)) {
                ClassTypeEnum.ENTITY -> {
                    log.debug("load entity:${it.name}")
                    entitySet.add(it)
                }

                ClassTypeEnum.REQUEST -> {
                    log.debug("load request:${it.name}")
                    requestSet.add(it)
                }

                ClassTypeEnum.UNDEFINED -> {}
            }
        }

        return entitySet to requestSet
    }

    /**
     * 扫描jar保存到集合
     * @param [classLoader] 类加载器
     * @param [basePath] 基本路径
     * @param [file] 文件
     * @param [classSet] 类集合
     */
    private fun scanJarSaveToSet(classLoader: ClassLoader, basePath: String, file: File, classSet: MutableSet<Class<*>>) {
        val jarEntries = JarFile(file).entries()
        jarEntries.toList()
            //包名匹配 .class后缀过滤 目录过滤
            .filter {
                with(it.name) {
                    startsWith(basePath) && endsWith(".class") && !it.isDirectory
                }
            }
            //转为可使用的类路径
            .map { it.name.replace("/", ".").removeSuffix(".class") }
            //添加到集合
            .forEach {
                try {
                    classSet.add(Class.forName(it, false, classLoader))
                } catch (e: ClassNotFoundException) {
                    log.error("class not found: $it")
                }
            }

    }


    /**
     * 扫描路径保存来设置
     * @param [classLoader] 类加载器
     * @param [basePath] 基本路径
     * @param [file] 文件
     * @param [classSet] 类集合
     */
    private fun scanClassSaveToSet(
        classLoader: ClassLoader,
        basePath: String,
        file: File,
        classSet: MutableSet<Class<*>>
    ) {
        //log.debug("scan: $basePath")
        //目录递归
        if (file.exists() && file.isDirectory) {
            Arrays.stream(file.list() ?: return).forEach {
                scanClassSaveToSet(classLoader, "$basePath/$it", File("${file.path}/$it"), classSet)
            }
            return
        }
        classSet.add(loadClass(classLoader, basePath) ?: return)
    }

    /**
     * 获取类类型
     * @param [clazz] clazz
     * @return [ClassTypeEnum]
     */
    private fun getClassType(clazz: Class<*>): ClassTypeEnum {
        val annotationArray = clazz.annotations
        return if (Arrays.stream(annotationArray).anyMatch { it is Api } && Arrays.stream(annotationArray).anyMatch { it is ApiSupport }) {
            ClassTypeEnum.REQUEST
        } else if (Arrays.stream(annotationArray).anyMatch { it is ApiModel }) {
            ClassTypeEnum.ENTITY
        } else {
            ClassTypeEnum.UNDEFINED
        }
    }

    /**
     * 加载类
     * @param [classLoader] 类加载器
     * @param [path] 路径
     * @return [Class<*>?]
     */
    private fun loadClass(classLoader: ClassLoader, path: String): Class<*>? {
        //焯水
        val realPath = with(path) {
            this.replace("/", ".")
                .removeSuffix(".class")
        }

        //下锅
        return try {
            classLoader.loadClass(realPath)
        } catch (e: Exception) {
            log.error("error: ", e)
            null
        }
    }

    /**
     * 解析请求
     * @param [requestSet] 请求集合
     * @param [entityMap] 实体映射集合
     * @return [List<RequestInfo>]
     */
    private fun resloveRequest(requestSet: Set<Class<*>>, entityMap: Map<Class<*>, EntityInfo>): List<RequestInfo> {
        return requestSet.stream().flatMap { requestClass ->
            //类基路径
            val basePath = requestClass.getAnnotation(RequestMapping::class.java)?.value?.get(0) ?: ""
            Arrays.stream(requestClass.methods)
                //过滤
                .filter { it.isAnnotationPresent(ApiOperation::class.java) && (it.isAnnotationPresent(GetMapping::class.java) || it.isAnnotationPresent(PostMapping::class.java)) }
                .map { method ->
                    //构建
                    RequestInfo().apply {
                        if (method.isAnnotationPresent(GetMapping::class.java)) {
                            method.getAnnotation(GetMapping::class.java).also {
                                type = RequestMethod.GET
                                path = "/${basePath.removeSuffix("/").removePrefix("/")}/${it.value[0].removePrefix("/")}"
                            }
                        } else {
                            method.getAnnotation(PostMapping::class.java).also {
                                type = RequestMethod.POST
                                path = "/${basePath.removeSuffix("/").removePrefix("/")}/${it.value[0].removePrefix("/")}"
                            }
                        }

                        val apiOperation = method.getAnnotation(ApiOperation::class.java)
                        description = apiOperation.value

                        //构建resultInfo
                        //获取返回值类型(Result<?> ?处)
                        val returnType = TypeUtil.getReturnType(method)
                        //没有泛型就过,simpleResult交给ftl部分
                        TypeUtil.getTypeArgument(returnType)?.let { returnClass ->
                            //根据返回类型获取返回值entityInfo
                            val resultEntityInfo = entityMap[returnClass]
                            //字段集合不为空则尝试填充泛型
                            resultEntityInfo?.fieldList?.let { fieldInfoList ->
                                resultEntityInfo.fieldList = buildGenerateTypeFieldList(fieldInfoList, returnType)
                            }
                            resultInfo = resultEntityInfo
                        }

                        //构建paramInfo
                        //请求参数取一个,多了不适配,反正自己用
                        paramInfo = method.parameters.firstOrNull()?.type?.let { paramClass ->
                            //根据类获取entityInfo
                            val entityInfo = entityMap[paramClass]
                            //字段集合不为空则尝试填充泛型
                            entityInfo?.fieldList?.let {
                                entityInfo.fieldList = buildGenerateTypeFieldList(it, paramClass)
                            }
                            entityInfo
                        }
                        log.debug("buildRequestInfo :${JSON.toJSONString(this)}")
                    }
                }
        }.toList()
    }

    private fun buildGenerateTypeFieldList(
        fieldList: List<FieldInfo>,
        clazz: Type
    ): List<FieldInfo> {
        return fieldList
            .map {
                if (it.tsType!!.run { contains(GENERATE_TYPE_PLACEHOLDER) || equals(GENERATE_TYPE_PLACEHOLDER) }) {
                    val typeArgument = (TypeUtil.getTypeArgument(clazz) as Class<*>).simpleName
                    it.tsType = it.tsType?.replace(GENERATE_TYPE_PLACEHOLDER, typeArgument)
                }
                it
            }.toList()
    }

    /**
     * 解析实体
     * @param [entitySet] 实体设置
     * @return [Map<Class<*>, EntityInfo>]
     */
    private fun resloveEntity(entitySet: Set<Class<*>>): Map<Class<*>, EntityInfo> {
        return entitySet.stream()
            //仅扫描ApiModel
            .filter {
                it.isAnnotationPresent(ApiModel::class.java) &&
                        (IParam::class.java.isAssignableFrom(it) || IVo::class.java.isAssignableFrom(it))
            }
            .map { clazz ->
                //获取字段信息集合
                //ReflectUtil.getFields(clazz) { IResult::class.java.isAssignableFrom(it.declaringClass) }
                val fieldInfoList = Arrays.stream(clazz.declaredFields)
                    //过滤无ApiModelProperty注解的
                    .filter { it.isAnnotationPresent(ApiModelProperty::class.java) }
                    //构建fieldInfo集合
                    .map {
                        val apiModelProperty = it.getAnnotation(ApiModelProperty::class.java)
                        //类的泛型
                        FieldInfo().apply {
                            name = it.name
                            javaType = TypeUtil.getClass(it)
                            tsType = getTsTypeByField(it)
                            description = apiModelProperty.value
                            example = apiModelProperty.example
                            required = apiModelProperty.required
                        }
                    }.toList()

                val apiModel = clazz.getAnnotation(ApiModel::class.java)
                val api = clazz.getAnnotation(Api::class.java)
                clazz to EntityInfo().apply {
                    fieldList = fieldInfoList
                    description = apiModel.description
                    name = clazz.simpleName
                    extend = if (BaseFastBuildParam::class.java.isAssignableFrom(clazz.superclass)) {
                        BaseParam::class.java
                    } else {
                        clazz.superclass
                    }
                    group = api?.value ?: "Default"
                    isParam = IParam::class.java.isAssignableFrom(clazz)
                    log.debug("buildEntityInfo :${JSON.toJSONString(this)}")
                }
            }.collect(Collectors.toMap(
                { it.first },
                { it.second }
            ))
    }

    /**
     * 从字段获取ts类型
     * @param [field] 字段
     * @return [String]
     */
    private fun getTsTypeByField(field: Field): String {
        //为空不是基本数据类型,判断是否为集合(迭代器)
        return getTsTypeByJavaType(field.type) ?: if (Iterable::class.java.isAssignableFrom(field.type)) {
            val javaType = TypeUtil.getType(field)

            when (val clazz = TypeUtil.getTypeArgument(javaType)) {
                is Class<*> -> {
                    "${getTsTypeByJavaType(clazz) ?: clazz.simpleName}[]"
                }

                is ParameterizedType -> {
                    "${(clazz.rawType as Class<*>).simpleName}[]"
                }

                else -> "$GENERATE_TYPE_PLACEHOLDER[]"
            }
        } else {
            GENERATE_TYPE_PLACEHOLDER
        }
    }

    /**
     * 通过java类型获取ts类型
     * @param [javaType] java类型
     * @return [String]
     */
    private fun getTsTypeByJavaType(javaType: Class<*>): String? {
        return if (Number::class.java.isAssignableFrom(javaType)) {
            "number"
        } else if (String::class.java.isAssignableFrom(javaType)) {
            "string"
        } else if (Date::class.java.isAssignableFrom(javaType)) {
            "date"
        } else {
            null
        }
    }
}