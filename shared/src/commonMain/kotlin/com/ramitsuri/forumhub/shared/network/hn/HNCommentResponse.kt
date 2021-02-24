package com.ramitsuri.forumhub.shared.network.hn

import com.ramitsuri.forumhub.shared.network.NetworkResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HNCommentResponse(
    @SerialName("id")
    val id: Int,

    @SerialName("created_at_i")
    override val creationTime: Long = 0L,

    @SerialName("type")
    override val subForum: String = "",

    @SerialName("author")
    override val author: String = "",

    @SerialName("title")
    override val title: String = "",

    @SerialName("url")
    override val url: String = "",

    @SerialName("text")
    val text: String = "",

    @SerialName("children")
    val children: List<HNCommentResponse> = emptyList()
) : NetworkResponse {
}