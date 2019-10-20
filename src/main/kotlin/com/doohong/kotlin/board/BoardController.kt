package com.doohong.kotlin.board

import com.doohong.kotlin.board.domain.Board
import com.doohong.kotlin.board.dto.BoardRequest
import com.doohong.kotlin.board.dto.BoardResponse
import com.doohong.kotlin.board.service.BoardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value="/board")
class BoardController(
        private val boardService: BoardService){

    @GetMapping(value="/view_board/{id}")
    fun getBoardDetail(@PathVariable("id")id: Long): ResponseEntity<BoardResponse> {
        return ResponseEntity.ok().body(boardService.findBoardByid(id));
    }

    @PostMapping(value="/insert_board")
    fun insertBoard(@RequestBody boardReq: BoardRequest):ResponseEntity<BoardResponse>{
        return ResponseEntity.ok().body(boardService.insertBoard(boardReq));
    }

    @PostMapping(value="/update_board")
    fun updateBoard(@RequestBody boardReq: BoardRequest): ResponseEntity<BoardResponse>{
        return ResponseEntity.ok().body(boardService.updateBoard(boardReq))
    }
    @PostMapping(value="/delete_board")
    fun deleteBoard(@RequestBody boardReq: BoardRequest): ResponseEntity<BoardResponse>{
        return ResponseEntity.ok().body(boardService.deleteBoard(boardReq))
    }
}