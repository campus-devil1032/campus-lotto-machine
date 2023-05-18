package controller;

import exception.IllegalMoneyException;
import exception.LackOfMoneyException;
import model.Player;
import service.MoneyService;

import java.io.IOException;
import java.util.Arrays;

public class MoneyController {
    private MoneyService moneyService = new MoneyService();

    /**
     * 사용자 로또 금액 입력
     * @throws IOException
     */
    public Player getMoneyByUser() throws IOException {
        Player player;

        try {
            player = moneyService.doGetMoneyByUser();
        } catch (LackOfMoneyException e) {
            throw new RuntimeException(e);
        } catch (IllegalMoneyException e) {
            throw new RuntimeException(e);
        }
        return player;
    }
}
