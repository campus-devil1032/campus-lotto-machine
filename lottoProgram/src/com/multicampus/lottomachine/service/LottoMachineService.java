package com.multicampus.lottomachine.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

import com.multicampus.lottomachine.domain.CustomerLottoVO;
import com.multicampus.lottomachine.domain.ResultLottoVO;
import com.multicampus.lottomachine.domain.StaticsWinningVO;
import com.multicampus.lottomachine.domain.WinningLottoVO;

// Controller가 요청한 서비스를 처리하는 서비스
// TODO 2단계 : 당첨 개수를 받아서 상금을 처리(금액 및 수익률)하는 메서드 추가
public class LottoMachineService {
	private CustomerLottoVO customVo;		//사용자 값을 저장하는 객체
	private WinningLottoVO winningVO;		//당첨 정보를 저장하는 객체
	private ResultLottoVO resultVO;				//당첨 결과를 저장하는 객체
	private StaticsWinningVO winningStatics;	//해당 회차의 통계 정보를 저장하는 객체
	private ArrayList<StaticsWinningVO> winningList = new ArrayList<StaticsWinningVO>();	//사용자의 당첨정보가 누적될 리스트
	private int roundNumber;	//회차 정보
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//사용자 입력받기
	
	//TODO 2단계 : 보너스 번호 추가
	public void checkLottoNumber() {	//당첨번호 생성후 당첨 여부 저장
		winningVO = new WinningLottoVO();	//로또 번호 만들기 
		resultVO = new ResultLottoVO(customVo.getList(), winningVO.getList());	//당첨정보객체 생성
		this.roundNumber+=1;		//회차 회수를 올린다. 
		winningStatics =new StaticsWinningVO(this.roundNumber,customVo.getList(),
				winningVO.getList(),resultVO.getList());	//회차 당첨정보 객체 생성
		winningList.add(winningStatics);	//리스트에 회차정보 추가
	}
	
	public TreeSet<Integer> getCustomList() { return customVo.getList(); }	//입력된 사용자 값을 가져오기
	public TreeSet<Integer> getWinningList(){ return winningVO.getList();	}	//당첨 정보 가져오기
	public TreeSet<Integer> getResultList() {	return resultVO.getList(); }	//사용자 이번 회차 당첨정보 가져오기
	public int getResultIntNumber() {	return resultVO.getResultNumber(); }	//당첨 갯수 가져오기
	public ArrayList<StaticsWinningVO> getWinningStaticsInfo() { 	// 당첨 통계 가져오기
		if(roundNumber==0) {	// 회차가 0이면 게임을 한 적이 없음
			throw new NullPointerException("게임 내역이 없습니다.");
		}
		return this.winningList; 
	}
	
	//TODO 2단계 : 최대 5장 까지 입력 가능하게 변경
	public void setCustomList() throws IOException{ 	//사용자 입력된 로또 값을 데이터에 입력
		String inputCustomerNumber = br.readLine();
		customVo = new CustomerLottoVO(inputCustomerNumber); 
	}
	//TODO 2단계 :  이 부분에서 돈이 빠져나간다.
	public boolean isRunnningGames()  throws IOException{	//게임을 계속 진행할 것인지 묻는 메서드 
		String isRunning = br.readLine();	//진행여부를 물어봄
		if(isRunning.toLowerCase().equals("yes")||isRunning.toLowerCase().equals("y")) {	//진행여부가 yes인 경우에만 true반환
			return true;
		}
		return false;
	}
}
