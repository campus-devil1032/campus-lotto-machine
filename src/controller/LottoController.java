package controller;

import model.LottoWinNumbers;
import model.Player;
import service.LottoService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class LottoController {
    private LottoService lottoService = new LottoService();

    /**
     * 수동 로또를 사용자에게 입력 받는다.
     * @param player
     * @param count
     * @throws IOException
     */
    public void doManualLottoGame(Player player, int count) throws IOException {
        ArrayList<TreeSet<Integer>> lottoSetList = player.getLottoSetList();

        for(int i = 0; i < count; i++){
            lottoSetList.add(lottoService.doManualLotto());
        }
    }

    /**
     * 자동 로또 번호를 생성한다.
     * @param player
     * @param count
     */
    public void doAutoLottoGame(Player player, int count){
        ArrayList<TreeSet<Integer>> lottoSetList = player.getLottoSetList();
        for(int i = 0; i < count; i++){
            lottoSetList.add(lottoService.doAutoLotto());
        }
    }

    /**
     * 로또 당첨 번호 만들기 TODO: 보너스 볼 만들기
     * @return
     */
    public TreeSet<Integer> doLottoWinNumber(){
       return lottoService.doAutoLotto();
    }

    public void doCheckLottoWinnings (Player player, LottoWinNumbers lottoWinNumbers) {
        System.out.println("lottoWinNumbers = " + lottoWinNumbers.getLottoSet());
        
        Iterator<TreeSet<Integer>> iter = player.getLottoSetList().iterator();

        while(iter.hasNext()) {
            TreeSet<Integer> userLotto = iter.next();
            // System.out.println("iter = " + iter.next());

            // TODO : 로또 당첨 번호랑 사용자 로또 번호랑 비교
            for (Integer lotto: userLotto) {
                for(Integer winLotto: lottoWinNumbers.getLottoSet()) {

                }
            }
        }

    }

}
