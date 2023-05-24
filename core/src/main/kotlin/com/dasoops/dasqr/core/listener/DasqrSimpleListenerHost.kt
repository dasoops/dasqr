package com.dasoops.dasqr.core.listener

import com.dasoops.common.core.util.resources.IgnoreResourcesScan
import com.dasoops.dasqr.core.exception.ExceptionHandlerPool
import net.mamoe.mirai.event.*
import kotlin.coroutines.CoroutineContext

@IgnoreResourcesScan
sealed interface DasqrListenerHost

/**
 * ListenerHost抽象类
 * @see [ExampleListenerHost]
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@IgnoreResourcesScan
abstract class DasqrSimpleListenerHost : SimpleListenerHost(), DasqrListenerHost {
    override fun handleException(context: CoroutineContext, exception: Throwable) {
        ExceptionHandlerPool.INSTANCE.handle(exception)
    }
}

/**
 * dsl example
 *  ```
 *  open class ExampleDslListenerHost : DslListenerHost({
 *      group("test") {
 *          "test" reply "group test ok"
 *      }
 *
 *      user("test") {
 *          "test" reply "user test ok"
 *      }
 *  })
 *  ```
 * @author DasoopsNicole@Gmail.com
 * @date 2023-04-24
 */
@IgnoreResourcesScan
abstract class DslListenerHost(val builder: suspend ListenerHostDslBuilder.() -> Unit) : DasqrListenerHost {
     suspend fun initAndGetMetaList() =
        ListenerHostDslBuilder().run {
            builder()
            metaDataList
        }

}

/**
 * 闭包eventHandler metaData
 */
sealed class DslEventHandlerMetaData(
    val name: String,
    val priority: EventPriority,
    val ignoreCancelled: Boolean,
    val concurrency: ConcurrencyKind,
)

class GroupDslEventHandlerMetaData(
    name: String,
    priority: EventPriority,
    ignoreCancelled: Boolean,
    concurrency: ConcurrencyKind,
    val func: GroupMessageSubscribersBuilder.() -> Unit
) : DslEventHandlerMetaData(name, priority, ignoreCancelled, concurrency)

class FriendDslEventHandlerMetaData(
    name: String,
    priority: EventPriority,
    ignoreCancelled: Boolean,
    concurrency: ConcurrencyKind,
    val func: FriendMessageSubscribersBuilder.() -> Unit
) : DslEventHandlerMetaData(name, priority, ignoreCancelled, concurrency)

class ListenerHostDslBuilder {
    val metaDataList = mutableSetOf<DslEventHandlerMetaData>()

    inline fun group(
        name: String,
        priority: EventPriority = EventPriority.NORMAL,
        ignoreCancelled: Boolean = true,
        concurrency: ConcurrencyKind = ConcurrencyKind.CONCURRENT,
        crossinline func: GroupMessageSubscribersBuilder.(name: String) -> Unit
    ) {
        metaDataList.add(
            GroupDslEventHandlerMetaData(
                name = name,
                priority = priority,
                ignoreCancelled = ignoreCancelled,
                concurrency = concurrency,
                func = {
                    func(name)
                },
            )
        )
    }

    inline fun friend(
        name: String,
        priority: EventPriority = EventPriority.NORMAL,
        ignoreCancelled: Boolean = true,
        concurrency: ConcurrencyKind = ConcurrencyKind.CONCURRENT,
        crossinline func: FriendMessageSubscribersBuilder.(name: String) -> Unit
    ) {
        metaDataList.add(
            FriendDslEventHandlerMetaData(
                name = name,
                priority = priority,
                ignoreCancelled = ignoreCancelled,
                concurrency = concurrency,
                func = {
                    func(name)
                },
            )
        )
    }
}