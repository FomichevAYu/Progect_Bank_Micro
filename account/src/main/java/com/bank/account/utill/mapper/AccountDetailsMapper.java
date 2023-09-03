package com.bank.account.utill.mapper;

import com.bank.account.dto.AccountDetailsDTO;
import com.bank.account.entity.AccountDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountDetailsMapper {
    AccountDetailsDTO accountDetailsToDto(AccountDetails accountDetails);

    AccountDetails accountDetailsDtoToAccountDetails(AccountDetailsDTO accountDetailsDTO);

}
