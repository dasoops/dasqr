package com.dasoops.dasqr.plugin.roll

import net.mamoe.mirai.contact.Member

class RollInfo : HashMap<Member, Int>() {
    /**
     * 砝码
     */
    var weight: Int = 0

    /**
     * 是否为过期触发
     */
    var expire = true
}