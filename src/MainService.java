import controller.ApplicationController;
import controller.LottoController;
import controller.MoneyController;
import model.Player;
import utils.UserInputRouter;
import view.LottoView;

import java.io.IOException;

public class MainService {
    private ApplicationController applicationController = new ApplicationController();

    public void start() throws IOException {
        applicationController.startLottoApplication();
    }
}
