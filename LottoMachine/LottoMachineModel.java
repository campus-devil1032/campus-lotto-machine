package campus_lotto_machine2.LottoMachine;

public class LottoMachineModel {
    // 당첨 번호와 일치하는 개수 계산
    public int calculateMatchCount(int[] lottoNumbers, int[] winningNumbers) {
        int matchCount = 0;
        for (int lottoNumber : lottoNumbers) {
            for (int winningNumber : winningNumbers) {
                if (lottoNumber == winningNumber) {
                    matchCount++;
                    break;
                }
            }
        }
        return matchCount;
    }

    // 자동번호 생성
    public int[][] generateAutoLottoNumbers(int autoPurchases, int lottoNumberSize) {
        int[][] autoLottoNumbers = new int[autoPurchases][lottoNumberSize];

        for (int i = 0; i < autoPurchases; i++) {
            for (int j = 0; j < lottoNumberSize; j++) {
                autoLottoNumbers[i][j] = (int) (Math.random() * 45) + 1;
            }
        }

        return autoLottoNumbers;
    }

    // 당첨번호 생성
    public int[] generateWinningNumber() {
        int[] winningNumber = new int[6];

        for (int i = 0; i < winningNumber.length; i++) {
            winningNumber[i] = (int) (Math.random() * 45) + 1;
        }
        return winningNumber;
    }
}
