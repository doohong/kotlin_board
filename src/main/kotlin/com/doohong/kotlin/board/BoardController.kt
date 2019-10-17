package com.doohong.kotlin.board

import com.doohong.kotlin.board.domain.Board
import com.doohong.kotlin.board.service.BoardService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(
        private val boardService: BoardService){

    @GetMapping(value="/board/{id}")
    fun getBoard(@PathVariable("id")id: Long): ResponseEntity<Board> {
        return ResponseEntity.ok().body(boardService.findBoardByid(id));
    }
}