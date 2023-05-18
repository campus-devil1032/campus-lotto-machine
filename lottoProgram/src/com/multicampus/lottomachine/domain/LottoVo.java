package com.multicampus.lottomachine.domain;

import java.util.TreeSet;
/**
 * 로또 번호를 다루는 모델
 * 1 getNumbers : TreeSet에 저장된 로또번호를 가져옴
 * 2.setNumbers : TreeSet에 모델에 맞게 번호를 구현함. 파라미터가 없어 생성자 등에서 별도 구현 필요
 *  */
public interface LottoVo {//결합을 끊어줌
	public TreeSet<Integer> getList();	/** 로또 넘버 가져오기 */
	public void setList();				/** 로또 넘버 셋팅하기 */
}
