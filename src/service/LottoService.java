package service;
import exception.IllegalMoneyException;
import exception.LackOfMoneyException;
import utils.UserInputRouter;
import view.LottoView;

import java.io.IOException;
import java.util.TreeSet;

public class LottoService {
    private UserInputRouter uir = new UserInputRouter();
    private LottoView lottoView = new LottoView();

    // TODO : 같은 번호 뽑았을때 다시 뽑도록 처리해주기 ㅠ
    /**
     * 자동 로또 번호 생성
     * @return
     */
    public TreeSet<Integer> doAutoLotto() {
        TreeSet<Integer> lottoSet = new TreeSet<>();
        for (int i = 0; i < 6; i++) {
            int num = (int) ((Math.random() * 45) + 1);
            lottoSet.add(num);
        }
        return lottoSet;

    }

    /**
     * 수동 로또 번호 사용자에게 입력받아서 생성
     * @return
     * @throws IOException
     */
    public TreeSet<Integer> doManualLotto() throws IOException {
        return uir.getUserManualLotto();
    }

    public void doCheckLottoWinning (){

    }
}
