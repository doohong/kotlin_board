package com.doohong.kotlin.board

import com.doohong.kotlin.board.domain.Board
import com.doohong.kotlin.board.dto.BoardRequest
import com.doohong.kotlin.board.dto.BoardResponse
import com.doohong.kotlin.board.service.BoardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BoardController(
        private val boardService: BoardService){

    @GetMapping(value="/board/{id}")
    fun getBoard(@PathVariable("id")id: Long): ResponseEntity<Board> {
        return ResponseEntity.ok().body(boardService.findBoardByid(id));
    }

    @PostMapping(value="/board")
    fun setBoard(@RequestBody boardReq: BoardRequest):ResponseEntity<BoardResponse>{
        return ResponseEntity.ok().body(boardService.writeBoard(boardReq));
    }
}