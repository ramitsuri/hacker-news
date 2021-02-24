package com.ramitsuri.forumhub.shared.network.hn

import com.ramitsuri.forumhub.shared.network.NetworkResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class HNBaseResponse(
    @SerialName("id")
    open val id: Int,

    @SerialName("by")
    override val author: String,

    @SerialName("time")
    override val creationTime: Long,

    @SerialName("type")
    override val subForum: String,
) : NetworkResponse {

}