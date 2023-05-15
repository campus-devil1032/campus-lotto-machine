package campus_lotto_machine.LottoMachine;

public class LottoMachineController {
    private LottoMachineModel model;
    private LottoMachineView view;

    public LottoMachineController(LottoMachineModel model, LottoMachineView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        int purchasesAmount = view.getPurchaseAmount();
        int manualPurchases = view.getManualPurchaseCount();
        int lottoNumberSize = 6;

        int purchasesCount = purchasesAmount / 1000;
        int autoPurchases = purchasesCount - manualPurchases;

        int[][] manualLottoNumbers = view.generateManualLottoNumbers(manualPurchases, lottoNumberSize);
        view.displayManualLottoNumbers(manualLottoNumbers);

        int[][] autoLottoNumbers = model.generateAutoLottoNumbers(autoPurchases, lottoNumberSize);
        view.displayAutoLottoNumbers(autoLottoNumbers);

        int[] winningNumber = model.generateWinningNumber();
        view.displayWinningNumber(winningNumber);

        // 수동 로또 일치 개수 출력
        for (int i = 0; i < manualPurchases; i++) {
            int matchCount = model.calculateMatchCount(manualLottoNumbers[i], winningNumber);
            view.displayMatchCount(matchCount, "(수동)", i);
        }

        // 자동 로또 일치 개수 출력
        for (int i = 0; i < autoPurchases; i++) {
            int matchCount = model.calculateMatchCount(autoLottoNumbers[i], winningNumber);
            view.displayMatchCount(matchCount, "(자동)", i);
        }
    }
}
