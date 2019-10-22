package com.doohong.kotlin.account.service

import com.doohong.kotlin.account.domain.Account
import com.doohong.kotlin.account.repository.AccountRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository,
                     private val passwordEncoder: PasswordEncoder): UserDetailsService {

    fun saveAccount(account: Account): Account {
        account.password = this.passwordEncoder.encode(account.password)
        return accountRepository.save(account)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        return accountRepository.findByEmail(username)?.getAuthorities()
                ?: throw UsernameNotFoundException("$username Can Not Found")
    }
}