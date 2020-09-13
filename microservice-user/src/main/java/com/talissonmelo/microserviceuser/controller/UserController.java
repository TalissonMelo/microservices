package com.talissonmelo.microserviceuser.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
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
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private Environment environment;
	
	@Value("${spring.application.name}")
	private String serviceId;
	
	@GetMapping(value = "/port")
	public String getPort() {
		return "Serviço na porta número: " + environment.getProperty("local.server.port");
	}
	
	@GetMapping(value = "/instances")
	public ResponseEntity<?> getInstance(){
		return new ResponseEntity<>(discoveryClient.getInstances(serviceId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/services")
	public ResponseEntity<?> getServices(){
		return new ResponseEntity<>(discoveryClient.getServices(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/registration")
	public ResponseEntity<?> save(@RequestBody User user){
		if(userService.findByUsername(user.getName()) != null) {
			log.info("Conflito username já cadastrado!.");
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		user.setRole(Role.USER);
		return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> getUser(Principal principal){
		if(principal == null || principal.getName() == null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return ResponseEntity.ok(userService.findByUsername(principal.getName()));
	}
	
	@PostMapping(value = "/names")
	public ResponseEntity<?> getNames(@RequestBody List<Long> ids){
		return ResponseEntity.ok(userService.findByIdList(ids));
	}
	
	@GetMapping(value = "/test")
	public ResponseEntity<?> test(){
		return ResponseEntity.ok("Está Funcionando!.");
	}
}
