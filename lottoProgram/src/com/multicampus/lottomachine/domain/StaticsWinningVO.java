package com.multicampus.lottomachine.domain;

import java.util.TreeSet;
//해당 회차에 당첨 정보를 입력함
public class StaticsWinningVO {
	private int roundNumber;	//회차번호
	private TreeSet<Integer> customList;//사용자 선택값
	private TreeSet<Integer> winningList;//당첨 로또번호
	private TreeSet<Integer> resultList;//당첨 정보값
	private int numberOfWinning;// 당첨 갯수
	private double staticsLottoWinning;// 당첨 확률
	
	public StaticsWinningVO(int roundNumber, TreeSet<Integer> customList, TreeSet<Integer> winningList,
			TreeSet<Integer> resultList) {
		this.roundNumber=roundNumber;	//회차정보 셋팅
		this.customList = customList;	//사용자 입력값 셋팅
		this.winningList = winningList;		//당첨번호 셋팅
		this.resultList = resultList;	//당첨 내역 셋팅
		setNumberOfWinning();	//Question 같은 클래스 내의 메서드를 호출할 때 this를 써주어야 하나?
		setStaticsLottoWinning();	//당첨 확률 지정
	}

	public int getRoundNumber() { return roundNumber;	} 	//회차정보 가져오기
	public TreeSet<Integer> getCustomerList() { return this.customList; } //사용자 입력값 가져오기
	public TreeSet<Integer> getWinningList() { 	return this.winningList; 	}	// 당첨번호 가져오기
	public TreeSet<Integer> getResultList() { return this.resultList;	}//당첨내역 가져오기
	public int getNumberOfWinning() { 	return this.numberOfWinning;	}	//당첨개수 가져오기
	public double getStaticsLottoWinning() { return this.staticsLottoWinning;	}	//당첨 확률 가져오기
	
	public void setNumberOfWinning() {  //당첨 개수 셋팅
		this.numberOfWinning = this.resultList.size();  //당첨 리스트의 사이즈를 입력
	} 

	public void setStaticsLottoWinning() {	//당첨 확률 셋팅
		double value = (double)numberOfWinning;
		this.staticsLottoWinning = (value/6.0)*100;	//정확하지 않음
	}
	
}
