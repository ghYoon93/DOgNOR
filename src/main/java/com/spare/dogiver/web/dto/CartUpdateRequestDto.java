package com.spare.dogiver.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartUpdateRequestDto {
    private int cartCnt;
    @Builder
    public CartUpdateRequestDto(int cartCnt) {
    	this.cartCnt = cartCnt;
    }
}