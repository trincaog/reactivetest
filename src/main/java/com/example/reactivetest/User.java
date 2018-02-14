package com.example.reactivetest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private long id;
	private String email;
	private String name;
	private String phoneNr;
}
