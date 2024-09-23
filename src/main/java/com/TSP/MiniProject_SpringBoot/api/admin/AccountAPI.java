package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.AccountDTO;
import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IAccountService;
import com.TSP.MiniProject_SpringBoot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AccountAPI {

    @Autowired
    IAccountService accountService;

    @PostMapping("/api/admin/account")
    public ResponseDTO<AccountDTO> save(@RequestBody AccountDTO accountDTO) {
        ResponseDTO<AccountDTO> responseDTO = accountService.save(accountDTO);
        return responseDTO;
    }

    @PutMapping("/api/admin/account")
    public ResponseDTO<AccountDTO> update(@RequestBody AccountDTO accountDTO) {
        ResponseDTO<AccountDTO> responseDTO = accountService.save(accountDTO);
        return responseDTO;
    }

    @DeleteMapping("/api/admin/account")
    public void delete(@RequestBody Long[] ids) {
        accountService.delete(ids);
    }

}
