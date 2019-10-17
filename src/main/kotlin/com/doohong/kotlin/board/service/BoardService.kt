package com.doohong.kotlin.board.service

import com.doohong.kotlin.board.domain.Board
import com.doohong.kotlin.board.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(
        private val boardRepository: BoardRepository
){
    fun findBoardByid(id: Long): Board{
        var board: Board = boardRepository.findById(id).orElseThrow()
        return board
    }
}