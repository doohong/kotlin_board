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
    fun findBoardByid(id: Long): BoardResponse{
        var board: Board = boardRepository.findById(id).orElseThrow()
        return BoardResponse(board.id!!,board.title,board.content,board.regMemberId,board.regDate)
    }
    fun insertBoard(boardReq: BoardRequest): BoardResponse{
        val board = boardRepository.save(Board(null,boardReq.title,boardReq.content,boardReq.regMemberId,boardReq.regDate));
        return BoardResponse(board.id!!,board.title,board.content,board.regMemberId,board.regDate)
    }
    fun updateBoard(boardReq: BoardRequest): BoardResponse{

        var board = boardRepository.findById(boardReq.id!!).orElseThrow()
        board.content = boardReq.content
        board.title = boardReq.title
        boardRepository.save(board)
        return BoardResponse(board.id!!,board.title,board.content,board.regMemberId,board.regDate)
    }
    fun deleteBoard(boardReq: BoardRequest): BoardResponse{
        val board = boardRepository.findById(boardReq.id!!).orElseThrow()
        boardRepository.deleteById(boardReq.id!!)
        return BoardResponse(board.id!!,board.title,board.content,board.regMemberId,board.regDate)
    }
}