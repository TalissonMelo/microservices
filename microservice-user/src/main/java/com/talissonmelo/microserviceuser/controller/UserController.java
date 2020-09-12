package com.talissonmelo.microserviceuser.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.microserviceuser.model.Role;
import com.talissonmelo.microserviceuser.model.User;
import com.talissonmelo.microserviceuser.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/registration")
	public ResponseEntity<?> save(@RequestBody User user){
		if(userService.findByUsername(user.getName()) != null) {
			log.info("Conflito username já cadastrado!.");
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		user.setRole(Role.USER);
		return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	}

	@GetMapping(value = "/login")
	public ResponseEntity<?> getUser(Principal principal){
		if(principal == null || principal.getName() == null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return ResponseEntity.ok(userService.findByUsername(principal.getName()));
	}
	
	@GetMapping(value = "/names")
	public ResponseEntity<?> getNames(@RequestBody List<Long> ids){
		return ResponseEntity.ok(userService.findByIdList(ids));
	}
	
	@GetMapping(value = "/test")
	public ResponseEntity<?> test(){
		return ResponseEntity.ok("Está Funcionando!.");
	}
}
