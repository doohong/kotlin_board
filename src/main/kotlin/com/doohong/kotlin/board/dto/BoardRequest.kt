package com.doohong.kotlin.board.dto

import java.time.LocalDateTime

data class BoardRequest(
        val id: Long? = null,
        val title: String,
        val content: String,
        val regMemberId: String,
        val regDate: LocalDateTime = LocalDateTime.now()
)