package utils;

import enums.MainMenu;
import exception.IllegalMoneyException;
import exception.LackOfMoneyException;
import view.LottoView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class UserInputRouter {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private LottoView lottoView = new LottoView();

    /**
     * 사용자 로또 금액 입력 및 검증 로직
     * @return
     * @throws IOException
     * @throws LackOfMoneyException
     * @throws IllegalMoneyException
     */
    public int getUserMoney() throws IOException, LackOfMoneyException, IllegalMoneyException {
        System.out.println("---------------------------------");
        System.out.println("로또를 진행할 금액을 입력해 주세요");
        System.out.println("---------------------------------");

        String userInput = br.readLine();

        if (!isInteger(userInput)) {
            throw new NumberFormatException();
        }

        int money = getParseIntByUser(userInput);

        // money < 1000
        if (money < 1000) {
            throw new LackOfMoneyException("1000원 이하의 금액을 입력하셨습니다! 돈이 부족해요 !");
        }

        // 1000원 이하 로또 단위 입력시
        if (money % 1000 != 0) {
            throw new IllegalMoneyException("금액을 잘못 입력하셨습니다. 1000원 단위로 입력해주세요");
        }

        return money;
    }



    public int getUserManualLottoCount() throws IOException {
        System.out.println("수동 로또 갯수를 입력해주세요. 0개면 0을 입력해 주세요.");
        String userInput = br.readLine();

        if (!isInteger(userInput)) {
            throw new NumberFormatException();
        }

        return getParseIntByUser(userInput);
    }

    public MainMenu getMainMenu() throws IOException {
        lottoView.mainMenuMsg();
        String userInput = br.readLine();

        if (userInput.equals("1")) {
            return MainMenu.AUTO;
        } else if (userInput.equals("2")) {
            return MainMenu.MANUAL;
        } else if (userInput.equals("3")) {
            return MainMenu.EXIT;
        }

        throw new IllegalArgumentException("잘못된 입력을 하셨습니다. 입력값을 다시 한번 확인해 주세요");
    }


    public TreeSet<Integer> getUserManualLotto() throws IOException, NumberFormatException {
        // 사용자 입력 받기
        System.out.println("공백을 기준으로 로또 번호 6개를 입력해 주세요 ! ");
        System.out.println("(예) 1 4 15 19 22 50 11");

        //String userInput = br.readLine();
        // String[] userInputs = userInput.split(" ");
        String[] userInputs = new String[] {"1", "3", "5", "7", "9", "11"};
        TreeSet<Integer> lottoSet = new TreeSet<>();

        for (int i = 0; i < userInputs.length; i++) {
            lottoSet.add(getParseIntByUser(userInputs[i]));
        }

        return lottoSet;
    }

    // TODO: validation 분류
    public boolean isInteger(String s) {
        try {
            getParseIntByUser(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int getParseIntByUser(String userInput) {
        return Integer.parseInt(userInput);
    }
}
