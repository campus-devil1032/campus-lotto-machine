package controller;

import exception.IllegalMoneyException;
import exception.LackOfMoneyException;
import model.Lotto;
import service.LottoService;

import java.io.IOException;
import java.util.Arrays;

public class LottoController {
    private LottoService lottoService = new LottoService();

    public void doLottoGame() {
        try {
            lottoService.run();
        } catch (LackOfMoneyException e) {
            System.out.println(e.getMessage());
        } catch (IllegalMoneyException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void doSysLotto() {
        // lotto 난수 생성
        int[] lottos = new int[6];
        for (int i = 0; i < 6; i++) {
            int num = (int) ((Math.random() * 45) + 1);
            lottos[i] = num;
        }


        System.out.println("lotto " + Arrays.toString(lottos));
    }
}
