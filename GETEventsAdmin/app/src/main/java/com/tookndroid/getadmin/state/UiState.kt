package com.tookndroid.getadmin.ui.state

import com.tookndroid.getadmin.tools.TYPE_AFFICHER

data class UiState(
    var typeAfficher: TYPE_AFFICHER = TYPE_AFFICHER.EVENEMENT,
    val isLoading : Boolean = false,
    val error : String? = null,
    var data : List<Any> = emptyList()
)
