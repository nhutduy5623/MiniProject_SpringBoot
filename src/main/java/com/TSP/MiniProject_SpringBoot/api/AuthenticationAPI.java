package com.TSP.MiniProject_SpringBoot.api;

import com.TSP.MiniProject_SpringBoot.dto.AccountDTO;
import com.TSP.MiniProject_SpringBoot.dto.JwtAuthenticaitonRespose;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.Authentication.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationAPI {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping(value = "/login")
    public ResponseEntity<?> authentication(@RequestBody AccountDTO accountDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(accountDTO.getEmail(), accountDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtProvider.generateToken(authentication.getName());
            ResponseDTO<JwtAuthenticaitonRespose> responseDTO = new ResponseDTO<>("Success", new JwtAuthenticaitonRespose(token));
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO<?> errorResponse = new ResponseDTO<>("Error", "Authentication failed: " + e.getMessage());
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    // Phương thức đăng xuất
    @DeleteMapping("/logout")
    public ResponseEntity<?> logout() {
        // Thực hiện các bước cần thiết để đăng xuất
        // Trong trường hợp này, không cần làm gì trên server, chỉ cần client xoá token

        return ResponseEntity.ok("Logged out successfully");
    }
}
