package com.TSP.MiniProject_SpringBoot.api.web;

import com.TSP.MiniProject_SpringBoot.dto.AccountDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountAPI_WEB {
    @Autowired
    IAccountService accountService;

    @GetMapping(value = "/api/admin/account")
    public ResponseDTO<AccountDTO> homePage(@RequestParam(value = "search", required = false) String search,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "limit", required = false) Integer limit) {
        if(search == "")
            search = null;
        if(page == null)
            page = 1;
        if(limit == null)
            limit = 5;
        PageRequest pageRequest = PageRequest.of(page-1, limit);
        AccountDTO accountCondition = new AccountDTO();
        accountCondition.setEmployee_name(search);
        ResponseDTO<AccountDTO> responseDTO = accountService.findBySpecification(accountCondition, pageRequest);
        return responseDTO;
    }

    @GetMapping(value = "/api/admin/account/{code}")
    public ResponseDTO<AccountDTO> findByCode(@PathVariable String code) {
        ResponseDTO<AccountDTO> responseDTO = accountService.findOneByCode(code);
        return responseDTO;
    }

    @GetMapping(value = "/api/admin/account_id/{id}")
    public ResponseDTO<AccountDTO> findByCode(@PathVariable Long id) {
        ResponseDTO<AccountDTO> responseDTO = accountService.findOne(id);
        return responseDTO;
    }
}
