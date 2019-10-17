package com.doohong.kotlin.board.repository

import com.doohong.kotlin.board.domain.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository:JpaRepository<Board,Long> {
}