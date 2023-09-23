package com.synchev.dm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform