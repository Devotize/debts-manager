package core.store

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow

abstract class Store<S : State, A : Action> :
    CoroutineScope by CoroutineScope(Dispatchers.Default) {

    abstract val state: StateFlow<S>

    abstract fun dispatch(action: A)

}