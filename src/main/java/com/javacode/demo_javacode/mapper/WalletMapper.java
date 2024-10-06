package com.javacode.demo_javacode.mapper;

import com.javacode.demo_javacode.dto.WalletResponseDto;
import com.javacode.demo_javacode.entity.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * Маппер для сущности {@link Wallet}
 *
 * @author Vladislav Azamat
 */
@Mapper(componentModel = SPRING)
public interface WalletMapper {

    @Mapping(target = "walletId",source = "id")
    WalletResponseDto  toWalletResponseDto(Wallet wallet);

}
