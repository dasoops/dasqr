package com.dasoops.dasqr.plugin.config

import cn.hutool.cache.Cache
import cn.hutool.cache.CacheUtil
import cn.hutool.cache.impl.*
import kotlin.reflect.KClass

/**
 * 缓存
 * 全基于hutool实现,就是存起来方便管理
 * @see CacheUtil
 * @author DasoopsNicole@Gmail.com
 * @date 2023/05/15
 */
object Cache {
    val cacheMap = mutableMapOf<KClass<*>, Cache<*, *>>()

    fun clear() {
        cacheMap.forEach {
            it.value.clear()
        }
    }

    fun <K, V> newFIFOCache(key: KClass<*>, capacity: Int, timeout: Long): FIFOCache<K, V> =
        FIFOCache<K, V>(capacity, timeout).also { cacheMap[key] = it }

    fun <K, V> newFIFOCache(key: KClass<*>, capacity: Int): FIFOCache<K, V> =
        FIFOCache<K, V>(capacity).also { cacheMap[key] = it }

    fun <K, V> newLFUCache(key: KClass<*>, capacity: Int, timeout: Long): LFUCache<K, V> =
        LFUCache<K, V>(capacity, timeout).also { cacheMap[key] = it }

    fun <K, V> newLFUCache(key: KClass<*>, capacity: Int): LFUCache<K, V> =
        LFUCache<K, V>(capacity).also { cacheMap[key] = it }

    fun <K, V> newLRUCache(key: KClass<*>, capacity: Int, timeout: Long): LRUCache<K, V> =
        LRUCache<K, V>(capacity, timeout).also { cacheMap[key] = it }

    fun <K, V> newLRUCache(key: KClass<*>, capacity: Int): LRUCache<K, V> =
        LRUCache<K, V>(capacity).also { cacheMap[key] = it }

    fun <K, V> newTimedCache(key: KClass<*>, timeout: Long): TimedCache<K, V> =
        TimedCache<K, V>(timeout).also { cacheMap[key] = it }

    fun <K, V> newWeakCache(key: KClass<*>, timeout: Long): WeakCache<K, V> =
        WeakCache<K, V>(timeout).also { cacheMap[key] = it }

    fun <K, V> newNoCache(key: KClass<*>): NoCache<K, V> =
        NoCache<K, V>().also { cacheMap[key] = it }
}