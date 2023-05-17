package campus_lotto_machine2.LottoMachine;

public class LottoMachineController {
    private LottoMachineModel model;
    private LottoMachineView view;

    public LottoMachineController(LottoMachineModel model, LottoMachineView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        int purchasesAmount = view.getPurchaseAmount(); // 총 구매금액
        int manualPurchases = view.getManualPurchaseCount(); // 수동 구매숫자
        int lottoNumberSize = model.getLottoNumberSize(); // 로또 6자리

        int purchasesCount = purchasesAmount / 1000; // 총 구매숫자
        int autoPurchases = purchasesCount - manualPurchases; // 자동 구매숫자

        int[][] manualLottoNumbers = view.generateManualLottoNumbers(manualPurchases, lottoNumberSize);
        view.displayManualLottoNumbers(manualLottoNumbers); // 수동번호 출력

        int[][] autoLottoNumbers = model.generateAutoLottoNumbers(autoPurchases, lottoNumberSize);
        view.displayAutoLottoNumbers(autoLottoNumbers); // 자동번호 출력

        int[] winningNumber = model.generateWinningNumber();
        view.displayWinningNumber(winningNumber); // 당첨번호 출력


        int winningAmount = model.getWinningAmount(); // 총 당첨금

        // 수동 로또 일치 개수 출력
        for (int i = 0; i < manualPurchases; i++) {
            int matchCount = model.calculateMatchCount(manualLottoNumbers[i], winningNumber);
            view.displayMatchCount(matchCount, "(수동)", i);
            int amount = model.calculatePrize(matchCount);
            winningAmount += amount; // 당첨금액있을 시 총 당첨금에 추가
        }

        // 자동 로또 일치 개수 출력
        for (int i = 0; i < autoPurchases; i++) {
            int matchCount = model.calculateMatchCount(autoLottoNumbers[i], winningNumber);
            view.displayMatchCount(matchCount, "(자동)", i);
            int amount = model.calculatePrize(matchCount);
            winningAmount += amount; // 당첨금액있을 시 총 당첨금에 추가
        }

        // 수익률 계산 및 출력
        double rateOfReturn = model.calculateRateOfReturn(purchasesAmount, winningAmount);
        view.displayRateOfReturn(rateOfReturn);
    }
}
