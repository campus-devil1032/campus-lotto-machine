package campus_lotto_machine2.LottoMachine;

import java.util.HashSet;
import java.util.Set;

public class LottoMachineModel {
    private int matchCount;
    private int lottoNumberSize;
    private int winningAmount;

    public int getLottoNumberSize() {
        return lottoNumberSize = 6;
    }

    public int getWinningAmount() {
        return winningAmount = 0;
    }

    // 당첨 번호와 일치하는 개수 계산
    public int calculateMatchCount(int[] lottoNumbers, int[] winningNumbers) {
        matchCount = 0;
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
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < lottoNumberSize; ) {
                int randomNumber = (int) (Math.random() * 45) + 1;

                if (!set.contains(randomNumber)) {
                    set.add(randomNumber);
                    autoLottoNumbers[i][j] = randomNumber;
                    j++;
                }
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

    public int calculatePrize(int matchCount) {
        int winningAmount = 0;
        if (matchCount == 3) {
            winningAmount = 5000;
        } else if (matchCount == 4) {
            winningAmount = 50000;
        } else if (matchCount == 5) {
            winningAmount = 2000000;
        } else if (matchCount == 6) {
            winningAmount = 1000000000;
        }
        return winningAmount;
    }

    // 수익률 계산
    public double calculateRateOfReturn(int purchasesAmount, int totalPrize) {
        double rateOfReturn = ((double) totalPrize / purchasesAmount) * 100;
        return rateOfReturn;
    }
}



