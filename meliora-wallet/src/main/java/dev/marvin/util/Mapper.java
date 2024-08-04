package dev.marvin.util;

import dev.marvin.dto.WalletResponse;
import dev.marvin.model.Wallet;

public class Mapper {

    public static WalletResponse mapToWalletResponse(Wallet wallet){
        return WalletResponse.builder().build();
    }
}
