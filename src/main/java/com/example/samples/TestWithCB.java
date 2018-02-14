package com.example.samples;

import com.example.reactivetest.User;

public class TestWithCB {
	public void asyncWithCallbacks(int id) {
		getUserFromDB(id, user -> {
			convertUser(user, convertedUser -> {
				processResult(convertedUser, processedUser -> {
					showResult(processedUser);
				});
			});
		});
	}

	public void getUserFromDB(int id, DbResult result) {
		// ...
	}

	public void convertUser(User user, ConvertStatus status) {
		// ...
	}

	public void processResult(User user, ProcessStatus status) {
		// ...
	}

	private void showResult(User user) {
		// ...
	}

	public interface DbResult {
		public void onResult(User user);
	}

	public interface ProcessStatus {
		public void onResult(User user);
	}

	public interface ConvertStatus {
		public void onResult(User user);
	}
}
