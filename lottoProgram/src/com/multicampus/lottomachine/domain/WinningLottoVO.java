package com.multicampus.lottomachine.domain;

import java.util.Random;
import java.util.TreeSet;

public class WinningLottoVO implements LottoVo{
	/** 당첨 번호 리스트 , 재정의 불가 */
	private final TreeSet<Integer> winningVo =new TreeSet<>(); 	//	Question final을 붙일 때 컬렉션은 함수로 보고, 함수 오버로딩 불가하다 생각해야 하는가?
	/** 당첨 번호 생성자, 랜덤함수 호출 */
	public WinningLottoVO() { setList(); }
	
	@Override
	/** 당첨 번호 가져오기 */
	public TreeSet<Integer> getList() {
		return this.winningVo;
	}
	
	@Override
	/** 당첨 번호 생성 */
	public void setList() {
		//TODO 2단계 : 보너스볼 추가 , 보너스 변수 필요 -> 당첨금액이 다름
		//winningNumbers=null; --final때문에 재정의 불가
		if(winningVo.size() == 6) {	// 한번 생성한 경우 더이상 추가하거나 빼지 않음
			throw new NullPointerException("로또번호는 이미 생성되었습니다.");
		}
		Random rd = new Random();
		for(int i = 0 ; winningVo.size() <6 ; i++) {
			winningVo.add(rd.nextInt(45)+1);
		}
	}
}
