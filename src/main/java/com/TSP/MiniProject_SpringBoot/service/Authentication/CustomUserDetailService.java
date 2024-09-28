package com.TSP.MiniProject_SpringBoot.service.Authentication;

import com.TSP.MiniProject_SpringBoot.dto.UserSecurity;
import com.TSP.MiniProject_SpringBoot.entity.AccountEntity;
import com.TSP.MiniProject_SpringBoot.repository.IAccountRepository;
import java.util.List;

import com.TSP.MiniProject_SpringBoot.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailService  implements UserDetailsService {

    @Autowired
    IAccountRepository accountRepository;

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountRepository.findOneByEmail(email);
        if(accountEntity == null) {
            throw new UsernameNotFoundException("User Not Found!");
        } else {
            if(accountEntity.getStatus() == 0) {
                throw new UsernameNotFoundException("Account has been locked!");
            } else {
                String userName = accountEntity.getCode();
                if (accountEntity.getEmployee() != null)
                    accountEntity.getEmployee().getFull_name();
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(accountEntity.getRole()));
                UserSecurity userSecurity = new UserSecurity(accountEntity.getId(), accountEntity.getEmail(), accountEntity.getPassword(), accountEntity.getEmployee().getFull_name(), accountEntity.getCode(), true, true, true, true, authorities);
                return userSecurity;
            }
        }
    }

}
