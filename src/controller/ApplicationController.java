package controller;

import exception.IllegalMoneyException;
import exception.LackOfMoneyException;
import model.LottoWinNumbers;
import model.Player;
import service.MoneyService;
import view.LottoView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class ApplicationController {
    private Player player = new Player();
    private LottoWinNumbers lottoWinNumbers = new LottoWinNumbers();

    private MoneyController moneyController = new MoneyController();
    private LottoController lottoController = new LottoController();

    private LottoView lottoView = new LottoView();

    public void startLottoApplication() throws IOException {
        lottoView.mainMenuMsg();

        // 사용자에게 로또 금액 및 자동, 수동 갯수 입력받는다.
        player = moneyController.getMoneyByUser();

        // 로또 리스트
        player.setLottoSetList(new ArrayList<>());
        ArrayList<TreeSet<Integer>> lottoSetList = player.getLottoSetList();

        // 로또 게임 시작
        // TODO : Lotto Controller 에 옮기는게 좋을까? 너무 많음..

        // 수동 갯수가 있다면 여기서 수동 로또 생성
        if (player.getManualLotto() != 0) {
            lottoController.doManualLottoGame(player, player.getManualLotto());
        }

        // 자동 갯수만큼 로또 만둘기
        if (player.getAutoLotto() != 0) {
            lottoController.doAutoLottoGame(player, player.getAutoLotto());
        }

        // 로또 당첨번호 생성
        lottoWinNumbers.setLottoSet(lottoController.doLottoWinNumber());

        // 로또 비교
        lottoController.doCheckLottoWinnings(player, lottoWinNumbers);


        System.out.println("lottoWinNumbers = " + lottoWinNumbers);
        System.out.println("player = " + player.toString());
    }


    public void doLottoGame() {

    }

    public void run() {

    }
}
