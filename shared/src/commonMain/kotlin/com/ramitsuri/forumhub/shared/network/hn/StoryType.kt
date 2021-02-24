package com.ramitsuri.forumhub.shared.network.hn

enum class StoryType(val apiType: String) {
    NEW("newstories"),
    TOP("topstories"),
    BEST("beststories"),
    ASK("askstories"),
    JOB("jobstories"),
    SHOW("showstories")
}