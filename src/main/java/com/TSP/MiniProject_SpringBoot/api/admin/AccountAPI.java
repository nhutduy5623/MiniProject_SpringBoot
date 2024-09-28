package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.AccountDTO;
import com.TSP.MiniProject_SpringBoot.dto.AssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IAccountService;
import com.TSP.MiniProject_SpringBoot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AccountAPI {

    @Autowired
    IAccountService accountService;

    @PostMapping("/api/admin/account")
    public ResponseEntity<ResponseDTO<AccountDTO>> save(@RequestBody AccountDTO accountDTO, BindingResult bindingResult) {
        ResponseDTO<AccountDTO> responseDTO = new ResponseDTO<>();
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        responseDTO = accountService.save(accountDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/api/admin/account")
    public ResponseEntity<ResponseDTO<AccountDTO>> update(@RequestBody AccountDTO accountDTO, BindingResult bindingResult) {
        ResponseDTO<AccountDTO> responseDTO = new ResponseDTO<>();
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(accountDTO.getId() == null) {
            responseDTO.setStatus("400");
            responseDTO.setMessage("ID is required");
        }
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        responseDTO = accountService.save(accountDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/api/admin/account")
    public void delete(@RequestBody Long[] ids) {
        accountService.delete(ids);
    }

}
