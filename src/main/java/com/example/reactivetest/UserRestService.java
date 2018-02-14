package com.example.reactivetest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class UserRestService {
	@Autowired
	UserRepository repository;

	@GetMapping("/sync")
	public Collection<User> syncList(@RequestParam(defaultValue="500", value = "delay", required = false) int delay)
			throws InterruptedException {
		return repository.getUsersSync(delay);
	}

	@GetMapping("/async")
	public Flux<User> asyncList(@RequestParam(defaultValue="500", value = "delay", required = false) int delay) {
		return repository.getUsersAsync(delay);
	}

}
