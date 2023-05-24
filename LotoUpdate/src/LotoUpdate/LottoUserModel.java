package LotoUpdate;
import java.util.Arrays;
public class LottoUserModel {
    private String inputNumber;

    public LottoUserModel(String inputNumber){
        this.inputNumber = inputNumber;
    }

    public int[] isUserNumber() {//String으로 받은 번호 int형으로 리턴
        String[] userNumber = inputNumber.split(" ");
        int[] lotteryNumber = new int[userNumber.length];

        for (int i = 0; i < lotteryNumber.length; i++) {
            lotteryNumber[i] = Integer.parseInt(userNumber[i]);
        }
        Arrays.sort(lotteryNumber);
        return lotteryNumber;
    }
}
