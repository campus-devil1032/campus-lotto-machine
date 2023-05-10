package LottoMachine;

import java.util.*;

public class LottoMachine {

    public static void main(String[] args) {
        // 구매번호 만들기(입력받기)
        Scanner sc = new Scanner(System.in);
        System.out.print("구매하시려는 로또 번호를 입력하세요 : ");

        Set<String> inputSet = new HashSet<>();

        boolean sixnumbers = false;
        String[] inputArray = new String[6];

        // 사용자로부터 6개의 숫자를 입력받아 Set에 저장한다
        while (inputSet.size() < 6) {
            String purchaseNumber = sc.nextLine();
            inputArray = purchaseNumber.split(" ");
            if (inputArray.length == 6) {
                inputSet.addAll(Arrays.asList(inputArray));
            } else {
                System.out.println("6개의 숫자를 공백을 구분하여 입력해주세요");
            }
        }
        // Set을 배열로 변환하여 출력한다
        int i = 0;
        for (String num:inputSet){
            inputArray[i]=num;
            i++;
        }
        System.out.println(inputSet);

        sc.close();

        // 당첨번호 만들기
        int[] winningNumber = new int[6];

        Random random = new Random();
        Set<Integer> set = new HashSet<>();

        // 1~45 범위 내의 6개의 난수를 생성하여 Set에 저장한다
        while (set.size() <= 5) {
            int tempNumber = random.nextInt(45) + 1;
            set.add(tempNumber);
        }
        // Set을 배열로 변환하여 출력한다
        int j = 0;
        for (int num : set) {
            winningNumber[j] = num;
            j++;
        }
        System.out.println(Arrays.toString(winningNumber));

        // 구매번호 배열과 당첨번호 배열을 대조하여 일치하는 숫자 개수 찾기
        int count = 0;
        for (String num : inputArray) {
            for (int winNum : winningNumber) {
                // 구매번호와 당첨번호가 일치하면 count를 증가시킨다
                if (Integer.parseInt(num) == winNum) {
                    count++;
                }
            }
        }
        System.out.println("일치하는 숫자 개수: " + count);
    }
}
