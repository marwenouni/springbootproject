package com.myapp.demo.dto;

public class AuthResponseDto {

	private String accesToken;
	private String accessTokenType="Bearer ";
	
	public AuthResponseDto(String accessToken) {
        this.accesToken = accessToken;
    }
	public String getAccesToken() {
		return accesToken;
	}
}
