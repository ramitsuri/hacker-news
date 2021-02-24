package com.ramitsuri.forumhub.shared.network.reddit

import com.ramitsuri.forumhub.shared.network.NetworkApi
import com.ramitsuri.forumhub.shared.network.NetworkResponse
import io.ktor.client.request.*
import io.ktor.client.statement.*
/*


class RedditApi : NetworkApi() {
    private val baseEndpoint = "https://www.reddit.com/"

    override suspend fun getItemsSkeleton(): List<NetworkResponse> {
        get()
        return listOf()
    }

    suspend fun get() {
        val response = httpClient.get<HttpResponse>("$baseEndpoint.json")

        println(response.readText())
    }
}*/
