package com.ramitsuri.forumhub.shared.network.hn

import com.ramitsuri.forumhub.shared.network.NetworkResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HNStoryDetailResponse(
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

    @SerialName("points")
    val score: Int = 0,

    @SerialName("children")
    val children: List<HNCommentResponse> = emptyList()
) : NetworkResponse {

}
