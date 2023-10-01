package utils

import org.koin.core.qualifier.Qualifier
import org.koin.mp.KoinPlatformTools

inline fun <reified T : Any> getSingle(qualifier: Qualifier? = null): T =
    KoinPlatformTools.defaultContext().get().get(qualifier)