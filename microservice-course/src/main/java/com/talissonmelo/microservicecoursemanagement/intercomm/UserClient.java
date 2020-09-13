package com.talissonmelo.microservicecoursemanagement.intercomm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user-service")
public interface UserClient {

	@RequestMapping(method = RequestMethod.POST, value = "/users/names",  consumes = "application/json")
	List<String> getUsername(@RequestBody List<Long> ids);
}
