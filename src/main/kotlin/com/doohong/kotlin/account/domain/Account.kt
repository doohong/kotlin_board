package com.doohong.kotlin.account.domain

import org.hibernate.annotations.CreationTimestamp
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import java.time.LocalDateTime
import java.util.stream.Collectors
import javax.persistence.*

@Entity
@Table(name="tbl_account")
data class Account(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "a_no")
        var id: Long,

        @Column(name = "a_email")
        var email: String,

        @Column(name = "a_password")
        var password: String,

        @Column(name = "a_roles")
        @Enumerated(EnumType.STRING)
        @ElementCollection(fetch = FetchType.EAGER)
        var roles: MutableSet<AccountRole>,

        @Column(name = "reg_date")
        @CreationTimestamp
        var regDate: LocalDateTime = LocalDateTime.now()

) {
    fun getAuthorities(): User {
        return User(
                this.email, this.password,
                this.roles.stream().map { role -> SimpleGrantedAuthority("ROLE_$role") }.collect(Collectors.toSet())
        )
    }
}