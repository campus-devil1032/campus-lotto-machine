package com.multicampus.lottomachine.domain;

import java.util.TreeSet;

import com.multicampus.lottomachine.exception.DuplicationNubersException;
import com.multicampus.lottomachine.exception.NumberOutOfBoundException;

/** 사용자 입력을 처리하는 모델 */
public class CustomerLottoVO implements LottoVo{
	private TreeSet<Integer> customerNumbers = new TreeSet<Integer>();	//사용자 데이터를 입력할 TreeSet
	private String[] inputs;		//사용자 입력값을 쪼개서 넣을 배열
	public CustomerLottoVO(String input) {// 1,2,3,3,5,7
		inputs = input.split(",");		// 입력값을 ','을 기준으로 배열에 넣습니다.
		setList();					// 배열의 값을 Treeset에 저장
	}
	
	public void setList() throws NumberFormatException{	//사용자 값을 Treeset에 넣기
		//에러포인트1 : 6개 초과, 미만으로 입력했을때
		if(inputs.length!=6) {
			throw new NumberFormatException("번호는 6개를 입력해주세요");
		}
		for(String number : inputs) {
			//에러포인트2 : 숫자가 아닌경우 - NumberFormatException
			int lottoNumber = Integer.parseInt(number);	
			
			//에러포인트3 : 로또번호는 1~45입니다. 
			if(lottoNumber<1||lottoNumber>45) {
				customerNumbers=null;
				throw new NumberOutOfBoundException("로또 번호는 1~45까지 가능합니다."); 
			}
			
			//에러포인트4 : 로또 번호는 중복 체크 
			if(customerNumbers.contains(lottoNumber)) {	//
				customerNumbers=null;
				throw new DuplicationNubersException("입력값이 중복되었습니다.");
			}
			customerNumbers.add(lottoNumber);
		}
	}
	
	public TreeSet<Integer> getList(){	//입력된 사용자 데이터 가져오기 
		if(this.customerNumbers.size()< 0) {
			throw new NullPointerException("사용자 로또 번호가 없습니다.");//사용자정의에러3 - 입력값이 없습니다. 
		}
		return this.customerNumbers;
	}
	
}
