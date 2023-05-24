package lottogame.Model;

import java.util.Random;

public class LottoModel {
    Random random = new Random();

    public int[] getRandomLotto() { // 랜덤 로또 번호 생성

        int[] lottoNumbers = new int[6];

        for (int i = 0; i < 6; i++) { // 6번 반복
            lottoNumbers[i] = random.nextInt(45) + 1; // 45까지의 랜덤한 숫자
            for (int j = 0; j < i; j++) {
                if (lottoNumbers[i] == lottoNumbers[j]) { // 중복값이 있으면 i--를 하여 다시 반복문을 돌림
                    i--;
                }
            }
        }
        return lottoNumbers;
    }


    public int getCount(int[] userNumbers, int[] lottoNumbers) { // 사용자 입력 로또번호와 랜덤 로또번호 검증
        int count = 0;
        for (int i = 0; i < 6; i++) {                    // 사용자 입력값 ex) 12, 26, 38, 41, 15, 29
            for (int j = 0; j < 6; j++) {                // 로또 생성 번호 ex) 32, 11, 41, 29, 9, 17
                if (userNumbers[i] == lottoNumbers[j]) { // 생성된 번호와 하나씩 대조 ex) 일치하는 번호 : 41, 29 count = 2
                    count++;
                }
            }
        }
        return count;
    }

    public boolean getLottoAmount(int amount) { // 로또 금액이 1000원 단위인지 확인
        if (amount <= 1000 && amount % 1000 != 0) {
            return false;
        }
        return true;
    }

    public int lottoPrizeMoney(int count) { // 당첨 금액

        int prizeMoney = 0;

        switch (count) {
            case 1:
                prizeMoney += 1000;
                break;
            case 2:
                prizeMoney += 3000;
                break;
            case 3:
                prizeMoney += 10000;
                break;
            case 4:
                prizeMoney += 50000;
                break;
            case 5:
                prizeMoney += 5000000000L; // 50억
                break;
            case 6:
                prizeMoney += 10000000000L; // 100억
                break;
        }
        return prizeMoney;
    }
}