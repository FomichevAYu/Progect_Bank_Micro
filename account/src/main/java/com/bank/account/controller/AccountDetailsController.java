package com.bank.account.controller;

import com.bank.account.dto.AccountDetailsDTO;
import com.bank.account.entity.AccountDetails;
import com.bank.account.exception.EmptyListException;
import com.bank.account.exception.EntityNotFoundException;
import com.bank.account.service.Impl.AccountDetailsServiceImpl;
import com.bank.account.utill.mapper.AccountDetailsMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * CRUD controller for Account_Details
 */

@RestController
@Tag(name = "Account Details", description = "Account Details API")
@RequiredArgsConstructor
public class AccountDetailsController {

    private AccountDetailsServiceImpl accountDetailsService;
    private AccountDetailsMapper mapper;

    @Autowired
    public AccountDetailsController(AccountDetailsServiceImpl accountDetailsService, AccountDetailsMapper mapper) {
        this.accountDetailsService = accountDetailsService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get all account details", tags = "Account Details")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AccountDetailsDTO.class)))
    @GetMapping("/account-details")
    public ResponseEntity<List<AccountDetailsDTO>> getAllAccountDetails() {
        List<AccountDetailsDTO> list = accountDetailsService.getAllAccountDetails().stream()
                .map(a -> mapper.accountDetailsToDto(a))
                .toList();
        if (list.isEmpty()) {
            throw new EmptyListException("Account Details not found");
        }
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "get account details by id", tags = "Account Details")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AccountDetailsDTO.class)))
    @GetMapping("/account-details/{id}")
    public ResponseEntity<AccountDetailsDTO> getAccountDetailsById(@PathVariable("id") long id) {
        AccountDetails optional = accountDetailsService.getAccountDetailsById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return ResponseEntity.ok().body(mapper.accountDetailsToDto(optional));
    }

    @Operation(summary = "create account details", tags = "Account Details")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AccountDetailsDTO.class)))
    @PostMapping("/account-details")
    public ResponseEntity<AccountDetailsDTO> createAccountDetails(@Valid @RequestBody AccountDetailsDTO accountDetailsDTO) {
        accountDetailsService.createAccountDetails(mapper.accountDetailsDtoToAccountDetails(accountDetailsDTO));
        return ResponseEntity.ok().body(accountDetailsDTO);
    }

    @Operation(summary = "update account details", tags = "Account Details")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AccountDetailsDTO.class)))
    @PutMapping("/account-details/{id}")
    public ResponseEntity<AccountDetailsDTO> updateAccountDetails(@Valid @RequestBody AccountDetailsDTO accountDetailsDTO,
                                                                  @PathVariable("id") long id) {
        AccountDetails optional = accountDetailsService.getAccountDetailsById(id).orElseThrow(() -> new EntityNotFoundException(id));
        accountDetailsService.updateAccountDetails(mapper.accountDetailsDtoToAccountDetails(accountDetailsDTO));
        return ResponseEntity.ok().body(accountDetailsDTO);
    }

    @Operation(summary = "delete account details", tags = "Account Details")
    @ApiResponse(responseCode = "200", description = "OK",
            content = @Content(schema = @Schema(implementation = AccountDetailsDTO.class)))
    @DeleteMapping("/account-details/{id}")
    public ResponseEntity<AccountDetailsDTO> deleteAccountDetails(@PathVariable("id") long id) {
        AccountDetails optional = accountDetailsService.getAccountDetailsById(id).orElseThrow(() -> new EntityNotFoundException(id));
        accountDetailsService.deleteAccountDetails(optional);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
