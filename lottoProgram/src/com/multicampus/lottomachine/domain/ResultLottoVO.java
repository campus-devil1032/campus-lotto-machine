package com.multicampus.lottomachine.domain;

import java.util.TreeSet;

public class ResultLottoVO implements LottoVo {	// 당첨 내역 생성
	private TreeSet<Integer> resultList = new TreeSet<Integer>();		//당첨정보를 저장할 리스트
	private TreeSet<Integer> customerList;	//사용자 리스트
	private TreeSet<Integer> winningList;	//당첨 리스트
	private int resultNumber;	//당첨 개수를 저장할 리스트
	
	public ResultLottoVO(TreeSet<Integer> customNumbers,TreeSet<Integer> winningNumbers ) {
		this.customerList = customNumbers;
		this.winningList = winningNumbers;
		this.setList();	//당첨 정보 셋팅
	}
	
	@Override
	public TreeSet<Integer> getList() {
		if(customerList==null || winningList == null) {
			throw new NullPointerException("사용자 입력이나 당첨번호가 없습니다. 결과값을 반환할 수 없습니다.");
		}
		return this.resultList;
	}

	@Override
	public void setList() {
		for(Integer number:this.customerList) {		//향상된 for문으로 winning리스트에 사용자 번호가 있는지 확인
			if(this.winningList.contains(number)) {
				this.resultList.add(number);
			}
		}
		setResultNumber();	//당첨 개수 셋팅
	}
	
	private void setResultNumber() {	//당첨 개수 셋팅
		this.resultNumber = resultList.size();	//당첨 개수에 리스트 사이즈 입력
	}
	
	public int getResultNumber() {	//당첨 개수 반환
		return this.resultNumber;
	}
}
