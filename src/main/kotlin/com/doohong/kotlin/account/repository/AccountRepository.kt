package com.doohong.kotlin.account.repository

import com.doohong.kotlin.account.domain.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long> {
    fun findByEmail(email: String): Account?
}