package com.multicampus.lottomachine.exception;

/** 입력된 숫자가 범위에 맞지 않을 때 사용하는 에러 */
public class NumberOutOfBoundException extends RuntimeException {	
	public NumberOutOfBoundException(String message) {
		super(message);
	}
}
