package com.doohong.kotlin.board.dto

import java.time.LocalDateTime

data class BoardResponse(

        val id: Long,
        val title: String,
        val content: String,
        val regMemberId: String,
        val regDate: LocalDateTime
)