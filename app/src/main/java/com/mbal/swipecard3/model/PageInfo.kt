package com.mbal.swipecard3.model

//Created for pagination. Not used!
data class PageInfo(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?
)