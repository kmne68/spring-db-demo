package com.kemery.dbdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

	private String id = "Default robot";
	private String speech = "hello";
	
	public void speak() {
		
		System.out.println(id + ": " + speech);
	}
	/*
	//@Autowired @Value("jdbc.user")
	public void setId( String id) {
		
		this.id = id;
	}
	
	
	//@Autowired @Value("jdbc.password")
	public void setSpeech( String speech) {
		
		this.speech = speech;
	} */
}
