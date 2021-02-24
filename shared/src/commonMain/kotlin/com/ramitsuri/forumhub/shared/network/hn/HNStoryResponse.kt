package com.ramitsuri.forumhub.shared.network.hn

import com.ramitsuri.forumhub.shared.network.NetworkResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HNStoryResponse(
    @SerialName("id")
    val id: Int,

    @SerialName("time")
    override val creationTime: Long = 0,

    @SerialName("type")
    override val subForum: String = "",

    @SerialName("by")
    override val author: String = "",

    @SerialName("title")
    override val title: String = "",

    @SerialName("url")
    override val url: String = "",

    @SerialName("score")
    val score: Int = 0,

    @SerialName("kids")
    val children: List<Int> = listOf(),

    @SerialName("descendants")
    val numDescendants: Int = 0
) : NetworkResponse {

}