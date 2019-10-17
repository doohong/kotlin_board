package com.doohong.kotlin.board.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="tbl_board")
class Board{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_no")
    var id: Long? = null

    @Column(name = "b_title")
    var title: String? = null

    @Column(name = "b_content")
    var content: String? = null

    @Column(name = "reg_member_id")
    var regMemberId: String? = null

    @Column(name = "reg_date")
    var regDate: LocalDateTime? = null

}