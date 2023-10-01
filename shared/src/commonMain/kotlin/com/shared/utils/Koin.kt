package com.shared.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.core.qualifier.Qualifier
import utils.getSingle

@Composable
inline fun <reified T> rememberKoin(qualifier: Qualifier? = null) =
    remember<T> { getSingle(qualifier) }