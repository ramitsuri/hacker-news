package com.ramitsuri.forumhub.shared.network

interface NetworkResponse {
    val subForum: String
    val author: String
    val title: String
    val creationTime: Long
    val url: String
}