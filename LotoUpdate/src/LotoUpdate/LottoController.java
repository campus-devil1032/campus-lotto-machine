package LotoUpdate;

public class LottoController {
    LottoView lottoView = new LottoView();
    LottoWinningModel lottoWinningModel = new LottoWinningModel();

    private int inputAmount;
    private int numberOfLotteryTicket;

    private int[] winningNumber;
    private int[] bonusNumber;

    private int winningAmount;

    public void lotteryGameStart(){
        winningNumber = lottoWinningModel.getWinningNumber(); //당첨번호 생성
        bonusNumber = lottoWinningModel.getBonusNumber(winningNumber); //보너스 번호 생성

        inputAmount = lottoView.getInputAmount(); //게임 진행 금액 입력 받기
        numberOfLotteryTicket = lottoView.getInputGameNumber(inputAmount); //게임 수 입력 받기

        for(int i=0; i<numberOfLotteryTicket; i++) { //게임 수 입력만큼 로또 수동 번호 입력받기

            LottoUserModel lottoUserModel = new LottoUserModel(lottoView.isInputNumberView());
            int[] userNumber = lottoUserModel.isUserNumber();
            int winningResult = checkNumber(userNumber, winningNumber); //당첨번호 유저 번호와 비교해서 리턴
            int bonusResult = checkNumber(userNumber, bonusNumber);//보너스번호 유저 번호와 비교해서 리턴
            int prizeMoney = LottoPrizeModel.valueOf(finalResult(winningResult,bonusResult)).getPrize();
            winningAmount += prizeMoney; //총 당첨 금액 값 저장
            //게임 횟수, 당첨 여부, 보너스번호 당첨 여부, 상금 출력
            lottoView.isResultOutView(i+1, winningResult , bonusResult, prizeMoney);
        }
        //이번회차 당첨번호와 보너스번호 출력
        lottoView.isWinningNumberView(winningNumber, bonusNumber);
        //이번회차 수익률 출력
        lottoView.isRateOfReturn(getRateOfReturn(winningAmount, inputAmount));
        //이번회차 슈익률에 따른 해석 출력
        lottoView.isRateOfReturnAnalysis(getAnalysisRateOfReturn(getRateOfReturn(winningAmount, inputAmount)));

    }
    public int checkNumber(int[] userNumber, int[] resultNumber) {//당첨 항목이 몇개인지 알려주는 메서드
        int count = 0;
        for (int i = 0; i < resultNumber.length; i++) {
            if (userNumber[i] == resultNumber[i]) {
                count++;
            }
        }
        return count;
    }

    public String finalResult(int winningResult, int bonusResult){ //몇등인지 리턴시켜주는 메서드
        String prize = " ";
        switch (winningResult){
            case 3:
                prize = "FIVE";
                break;
            case 4:
                prize = "FOUR";
                break;
            case 5:
                if(bonusResult == 1){
                    prize = "THREE";
                }else{
                    prize = "TWO";
                }
                break;
            case 6:
                prize = "ONE";
                break;
            default:
                prize = "LAST";
        }
        return prize;
    }
    public double getRateOfReturn(int winningAmount, int inputAmount){
        double result;
        if(winningAmount == 0){
            result = 0;
        }else {
            result = (double) winningAmount / inputAmount;
        }
        return result;
    }

    public String getAnalysisRateOfReturn(double result){
        String analysis;
        if(result < 1){
            analysis = "손해";
        }else if(result == 1){
            analysis = "본전";
        }else{
            analysis = "이익";
        }
        return analysis;
    }
}
