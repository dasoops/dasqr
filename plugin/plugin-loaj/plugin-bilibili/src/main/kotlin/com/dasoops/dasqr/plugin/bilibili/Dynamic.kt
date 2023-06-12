package com.dasoops.dasqr.plugin.bilibili

import cn.hutool.core.date.DateTime

sealed interface Dynamic {
    val id: Long
    val authorName: String
    val time: DateTime
}

data class Share(
    val title: String,
    val link: String,
    val imageLink: String,
    override val id: Long,
    override val authorName: String,
    override val time: DateTime,
) : Dynamic

data class Message(
    val description: String,
    val imageLinkList: List<String>,
    override val id: Long,
    override val authorName: String,
    override val time: DateTime,
) : Dynamic

data class Video(
    val title: String,
    val description: String,
    val link: String,
    override val id: Long,
    override val authorName: String,
    override val time: DateTime,
) : Dynamic

data class Column(
    val title: String,
    val description: String,
    val imageLinkList: List<String>,
    override val id: Long,
    override val authorName: String,
    override val time: DateTime,
) : Dynamic