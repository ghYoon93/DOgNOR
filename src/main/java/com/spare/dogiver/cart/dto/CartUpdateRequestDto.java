package com.spare.dogiver.cart.dto;

import com.spare.dogiver.cart.domain.Cart;

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
    
    public Cart toEntity() {
    	return Cart.builder()
    			.build();		
    }
}
