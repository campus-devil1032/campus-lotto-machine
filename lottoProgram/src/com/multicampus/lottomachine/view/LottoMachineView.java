package com.multicampus.lottomachine.view;

import java.util.ArrayList;
import java.util.TreeSet;

import com.multicampus.lottomachine.domain.StaticsWinningVO;
//화면에 출력할 메뉴 보여주기
public class LottoMachineView {
	public void showProgramMenu() {//전체 메뉴
		System.out.println("===================================================");
		System.out.println("\t\t로또 프로그램 입니다.");
		System.out.println("===================================================");
		System.out.println("원하는 메뉴를 선택해주세요.");
		System.out.println("Lotto. 로또게임");
		System.out.println("Statics. 로또게임 통계");
	}
	public void showCustomerInputMessage() {//입력값 요청
		System.out.print("로또 번호 6개를 입력해주세요. 번호는 1~45입니다 : ");		
	}
	public void showStartGameMenu() {//게임 진행 여부
		System.out.println("로또게임을 시작하시겠습니까? yes(y), no(n)");
	}
	public void showCustomerSetting(TreeSet<Integer> customerNumbers) {	//사용자 입력값 보여주기
		System.out.println("입력하신 번호는 : "+customerNumbers+"입니다.");
	}
	public void showWinningResult(TreeSet<Integer> winningNumber, int resultIntNumber, TreeSet<Integer> resultNumbers) {//당첨정보 보여주기
		System.out.println("당첨 번호는 : "+winningNumber+"입니다.");
		System.out.println("귀하는 총 "+resultIntNumber+"개가 당첨되었습니다. 당첨내역"+resultNumbers);
	}
	public void showStaticsWinning(ArrayList<StaticsWinningVO> winningStatics) {	//당첨통계 보여주기
		System.out.println("===================================================");
		System.out.println("\t\t로또 내역 입니다.");
		System.out.println("===================================================");
		for(StaticsWinningVO vo:winningStatics) {
			System.out.print(vo.getRoundNumber()+"회차 사용자 번호 : "+vo.getCustomerList());
			System.out.print(" 당첨번호 : "+vo.getWinningList()+"당첨 개수 :"
			+vo.getNumberOfWinning()+" - "+vo.getResultList());
			System.out.printf(" 당첨확률 : %.3f\n",vo.getStaticsLottoWinning());
		}
	}
}
