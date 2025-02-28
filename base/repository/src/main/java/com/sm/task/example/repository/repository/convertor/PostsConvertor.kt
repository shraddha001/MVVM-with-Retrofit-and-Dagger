package com.sm.task.example.repository.repository.convertor

import com.sm.task.example.api.dto.PostsDto
import com.sm.task.example.api.dto.PostsResultDto
import com.sm.task.example.api.dto.ReactionsDto
import com.sm.task.example.repository.repository.model.Posts
import com.sm.task.example.repository.repository.model.PostsResult
import com.sm.task.example.repository.repository.model.Reactions

fun PostsResultDto.toPostResult() = PostsResult(posts.map { it.toPosts() })

fun PostsDto.toPosts() = Posts(id, title, body, tags, reactions?.toReaction(), views, userId)

fun ReactionsDto.toReaction() = Reactions(likes, dislikes)