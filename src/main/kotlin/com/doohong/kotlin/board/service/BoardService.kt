package com.doohong.kotlin.board.service

import com.doohong.kotlin.board.domain.Board
import com.doohong.kotlin.board.dto.BoardRequest
import com.doohong.kotlin.board.dto.BoardResponse
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
    fun writeBoard(boardReq: BoardRequest): BoardResponse{

        val board = boardRepository.save(Board(null,boardReq.title,boardReq.content,boardReq.regMemberId,boardReq.regDate));
        return BoardResponse(board.id!!,board.title,board.content,board.regMemberId,board.regDate)
    }
}