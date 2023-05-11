package campus_lotto_machine.LottoMachine;

import java.util.*;

public class LottoMachine{

    public static void main(String[] args) {
        //구매번호 만들기(입력받기)
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.print("구매하시려는 로또 구매액을 입력하세요 (1000원 단위) : ");

        int purchasesAmount = sc.nextInt(); // 로또 구매 금액 입력
        while (purchasesAmount % 1000 != 0 || purchasesAmount < 1000) {
            System.out.print("구매 금액이 1000원 단위가 아닙니다. 다시 구매액을 입력하세요 : ");
            purchasesAmount = sc.nextInt();
        }
        int purchasesCount = purchasesAmount / 1000;
        int lottoNumberSize = 6; // 로또 번호 개수
        int[][] lottoNumbers = new int[purchasesAmount][lottoNumberSize];

        // 로또 번호 생성
        System.out.println();
        for (int i = 0; i < purchasesCount; i++) {
            Set<Integer> set = new HashSet<>();
            while (set.size() < lottoNumberSize) {
                int tempNumber = random.nextInt(45) + 1;
                set.add(tempNumber);
            }
            int j = 0;
            for (int num : set) {
                lottoNumbers[i][j] = num;
                j++;
            }
        }

        // 생성된 로또 번호 출력
        for (int i = 0; i < purchasesCount; i++) {
            System.out.println((i + 1) + "번째 로또 번호: " + Arrays.toString(lottoNumbers[i]));
        }


        // 당첨번호 만들기
        System.out.println();
        System.out.println("<당첨번호>");
        int[] winningNumber = new int[6];

        Set<Integer> set = new HashSet<>();

        while (set.size() <= 5) {
            int tempNumber = random.nextInt(45) + 1;
            set.add(tempNumber);
        }
        int j = 0;
        for (int num : set) {
            winningNumber[j] = num;
            j++;
        }
        System.out.println(Arrays.toString(winningNumber));

        // 구매번호 배열과 당첨번호 배열을 대조하여 일치하는 숫자 개수 찾기
        System.out.println();
        for (int i = 0; i < purchasesCount; i++) {
            int matchCount = 0;
            for (int k = 0; k < lottoNumberSize; k++) {
                if (lottoNumbers[i][k] == winningNumber[k]) {
                    matchCount++;
                }
            }
            System.out.println((i + 1) + "번째 로또번호 일치개수: " + matchCount);
        }
    }
}
