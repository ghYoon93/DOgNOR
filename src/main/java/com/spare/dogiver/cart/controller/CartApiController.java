package com.spare.dogiver.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spare.dogiver.cart.service.CartService;
import com.spare.dogiver.cart.dto.CartResponseDto;
import com.spare.dogiver.cart.dto.CartSaveRequestDto;
import com.spare.dogiver.cart.dto.CartUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CartApiController {
	private final CartService cartService;
	
	@GetMapping("/api/v1/cart")
	public ResponseEntity<List<CartResponseDto>> getList(HttpSession session){
		String email = (String)session.getAttribute("memEmail");
		List<CartResponseDto> cart = cartService.getCart(email);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}
	
	@PostMapping("/api/v1/cart")
	public Long save(@RequestBody CartSaveRequestDto requestDto, HttpSession session) {
		String email = (String)session.getAttribute("memEmail");
		
		return cartService.save(email, requestDto);
	}
	
	@GetMapping("/api/v1/cart/{cartId}")
	public CartResponseDto findBytId(@PathVariable Long cartId) {
		return cartService.findById(cartId);
	}
	
	@PutMapping("/api/v1/cart/{cartId}")
	public Long update(@PathVariable Long cartId,
			@RequestBody CartUpdateRequestDto requestDto) {
		return cartService.update(cartId, requestDto);
	}
	
	@DeleteMapping("/api/v1/cart")
	public void delete(@RequestBody List<Long> cartIds) {
		cartService.deleteByIdIn(cartIds);
	}
}
