package com.myapp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.demo.config.JwtTokenUtil;
import com.myapp.demo.dto.AuthResponseDto;
import com.myapp.demo.dto.LoginDto;
import com.myapp.demo.service.JwtUserDetailsService;




@CrossOrigin
public class JwtAuthenticationController {


	

	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUserDetailsService jwtInMemoryUserDetailsService;

	JwtTokenUtil jwtAuthUtil;

	

	public JwtAuthenticationController(AuthenticationManager authenticationManager,
			JwtUserDetailsService jwtInMemoryUserDetailsService, JwtTokenUtil jwtAuthUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtInMemoryUserDetailsService = jwtInMemoryUserDetailsService;
		this.jwtAuthUtil = jwtAuthUtil;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<?> CreateAuthToken(@RequestBody LoginDto loginDto) throws Exception {
		String token;
		Authentication authentication;
		try {
			 authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword()));
			//SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println(authentication.isAuthenticated());

		} catch (DisabledException e) {
			System.out.println("USER_DISABLED "+e);
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			System.out.println("BadCredentialsException "+e);
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(loginDto.getUserName());
		token = jwtAuthUtil.GenerateToken(userDetails);
		return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);

	}
}
