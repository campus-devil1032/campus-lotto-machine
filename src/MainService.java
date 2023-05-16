import controller.LottoController;
import enums.MainMenu;
import exception.IllegalMoneyException;
import exception.LackOfMoneyException;
import utils.UserInputRouter;
import view.LottoView;

import java.io.IOException;

public class MainService {
    private UserInputRouter uir = new UserInputRouter();
    private LottoController lc = new LottoController();
    private LottoView lottoView = new LottoView();

    public void start() throws IOException {
        lottoView.showMainMenu();
        while(true){
            lc.doLottoGame();
        }
    }
}
