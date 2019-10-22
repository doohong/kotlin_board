package com.doohong.kotlin.board.service

import com.doohong.kotlin.board.domain.Board
import com.doohong.kotlin.board.dto.BoardRequest
import com.doohong.kotlin.board.dto.BoardResponse
import com.doohong.kotlin.board.repository.BoardRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class BoardService(
        private val boardRepository: BoardRepository
){
    fun findBoardList():List<BoardResponse>{
        var boardList: List<Board> = boardRepository.findAll()
        return boardList.stream().map{x->x.getBoardResponse()}.collect(Collectors.toList())
    }
    fun findBoardByid(id: Long): BoardResponse{
        var board: Board = boardRepository.findById(id).orElseThrow()
        return board.getBoardResponse()
    }
    fun insertBoard(boardReq: BoardRequest): BoardResponse{
        val board = boardRepository.save(Board(null,boardReq.title,boardReq.content,boardReq.regMemberId,boardReq.regDate));
        return board.getBoardResponse()
    }
    fun updateBoard(boardReq: BoardRequest): BoardResponse{

        var board = boardRepository.findById(boardReq.id!!).orElseThrow()
        board.content = boardReq.content
        board.title = boardReq.title
        boardRepository.save(board)
        return board.getBoardResponse()
    }
    fun deleteBoard(boardReq: BoardRequest): BoardResponse{
        val board = boardRepository.findById(boardReq.id!!).orElseThrow()
        boardRepository.deleteById(boardReq.id!!)
        return board.getBoardResponse()
    }
}