package com.multicampus.lottomachine;

import com.multicampus.lottomachine.service.AppService;

public class Main {
	public static void main(String[] args) {
		AppService appservice = new AppService(); //appservice 객체생성
		appservice.start();  //appservice 시작
	}
}
