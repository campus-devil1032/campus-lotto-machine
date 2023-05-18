package com.multicampus.lottomachine.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.multicampus.lottomachine.domain.StaticsWinningVO;
import com.multicampus.lottomachine.service.LottoMachineService;
import com.multicampus.lottomachine.view.LottoMachineView;

// 로또 프로그램 컨트롤러 : 프로그램의 분기를 처리 
public class LottoMachineController {
	private LottoMachineService lottoService = new LottoMachineService();	// 로또 서비스 처리 객체
	private LottoMachineView lottoView = new LottoMachineView(); //로또 뷰 처리 객체
	public void showProgramMenu() {	//로또 프로그램 시작 메뉴 보여줌
		lottoView.showProgramMenu();
	}

	public void setCustomNumberList() throws IOException{	//사용자 입력값을 셋팅하고 게임을 진행할 것인지 물음
		lottoView.showCustomerInputMessage();	//사용자에게 입력값을 넣어달라고 요청하는 메세지 출력
		//TODO 2단계 : 입력값에서 자동/수동 을 선택할 수 있게
		lottoService.setCustomList(); 							//사용자에게 받은 입력값을 객체에 넣을 메서드
		lottoView.showCustomerSetting(lottoService.getCustomList()); 		//사용자 입력값을 다시 한번 보여줌
		lottoView.showStartGameMenu();				//로또 게임을 진행할 것인지 묻는 메서드
	}
	
	public boolean isRunningGame() throws IOException{	//사용자의 게임 진행 여부를 받아 true/false로 반환 
		return lottoService.isRunnningGames();
	}
	
	public void startLottoGame() {	//게임 시작을 선택하면 로또 번호를 생성하고 결과값을 저장
		lottoService.checkLottoNumber();	//로또 당첨 번호 생성, 당첨번호 저장
		lottoView.showWinningResult(lottoService.getWinningList(), lottoService.getResultIntNumber(),
				lottoService.getResultList());	//로또 당첨 번호 및 내 당첨 번호 보여주기
	}
	
	public void showStaticsLottoWinning() {		// 사용자 당첨 정보 보여주기
		lottoView.showStaticsWinning(lottoService.getWinningStaticsInfo());					//뷰에 당첨정보 전달해서 출력
	}
}
