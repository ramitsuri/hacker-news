package com.ramitsuri.forumhub.shared.network.hn

import com.ramitsuri.forumhub.shared.network.NetworkApi
import com.ramitsuri.forumhub.shared.network.Result
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@KtorExperimentalAPI
class HNApi : NetworkApi() {

    private val baseIdEndpoint = "https://hacker-news.firebaseio.com/v0/"
    private val baseItem = "item/"
    private val baseFormat = ".json?print=pretty"
    private val baseDetailEndpoint = "https://hn.algolia.com/api/v1/"
    private val baseItems = "items/"

    suspend fun getStoryIds(type: StoryType): Result<List<Int>, String> {
        val response = getResponse("$baseIdEndpoint${type.apiType}$baseFormat")
        response?.let {
            return if (it.status == HttpStatusCode.OK) {
                val ids: List<Int> = it.receive()
                Result.success(ids)
            } else {
                Result.error("Invalid data returned")
            }
        }
        return Result.error("No data returned")
    }

    suspend fun getStories(ids: List<Int>): Result<List<HNStoryResponse>, String> {
        val stories = mutableListOf<HNStoryResponse>()
        for (id in ids) {
            CoroutineScope(Dispatchers.Default).launch {
                val response = getResponse("$baseIdEndpoint$baseItem$id$baseFormat")
                response?.let {
                    if (it.status == HttpStatusCode.OK) {
                        stories.add(it.receive())
                    }
                }
            }
        }
        return Result.success(stories)
    }

    suspend fun getStoryDetail(id: Int): Result<HNStoryDetailResponse, String> {
        val response = getResponse("$baseDetailEndpoint$baseItems$id")
        response?.let {
            return if (it.status == HttpStatusCode.OK) {
                val detail: HNStoryDetailResponse = it.receive()
                Result.success(detail)
            } else {
                Result.error("Invalid data returned")
            }
        }
        return Result.error("No data returned")
    }

    private suspend fun getResponse(url: String): HttpResponse? {
        return httpClient.get(url)
    }

}