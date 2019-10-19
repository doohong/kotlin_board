package com.doohong.kotlin.board.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="tbl_board")
data class Board(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "b_no")
        var id: Long?,

        @Column(name = "b_title")
        var title: String,

        @Column(name = "b_content")
        var content: String,

        @Column(name = "reg_member_id")
        var regMemberId: String,

        @Column(name = "reg_date")
        var regDate: LocalDateTime
)
