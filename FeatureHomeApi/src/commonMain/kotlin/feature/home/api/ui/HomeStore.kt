package feature.home.api.ui

import core.store.Action
import core.store.State
import core.store.Store

abstract class HomeStore : Store<HomeStore.HomeState, HomeStore.HomeAction>() {

    data class HomeState(
        val empty: String = ""
    ) : State

    sealed interface HomeAction : Action

    data object OpenBottomSheet : HomeAction
    data object OpenBottomSheet2 : HomeAction

}