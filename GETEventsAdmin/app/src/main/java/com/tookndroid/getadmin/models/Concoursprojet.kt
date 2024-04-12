package com.tookndroid.getadmin.models

data class Concoursprojet(
    var id: Int,
    val title: String,
    val lieu: String,
    val description: String,
    val date: String,
    var jurry: String,
    var createdAt: String,
    var updtatedAt: String,
    var evenementId: Int,
    var miniprojets: List<Miniprojet>
)
