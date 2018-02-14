package com.example.samples;

import com.example.reactivetest.User;

import reactor.core.publisher.Flux;

public class TestWithReactive {
	public void asyncWithReactive(int id) {
		getUserFromDBAsync(id)
			.map(user -> convertUser(user))
			.map(user -> processResult(user))
			.subscribe(user -> showResults(user));
	}

	public void sync(int id) {
		User user = getUserFromDBSync(id);
		user = convertUser(user);
		user = processResult(user);
		showResults(user);
	}

	public Flux<User> getUserFromDBAsync(int id) {
		return Flux.just(new User(id, null, null, null));
	}

	public User getUserFromDBSync(int id) {
		return new User(id, null, null, null);
	}

	public User convertUser(User user) {
		return user;
	}

	public User processResult(User user) {
		return user;
	}

	private void showResults(User user) {
	}

}
