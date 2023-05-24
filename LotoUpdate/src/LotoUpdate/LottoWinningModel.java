package LotoUpdate;
import java.util.Random;
import java.util.Arrays;

public class LottoWinningModel {
    Random random = new Random();

    public int[] getWinningNumber() {//당첨번호 리턴 시켜주는 메서드
        int[] winningNumber = new int[6];
        int index = 0;
        while(index < 6){
            int[] num = new int[]{random.nextInt(45) + 1};
            if(isDuplicateCheck(winningNumber, num)){
                winningNumber[index] = num[0];
                index++;
            }
        }
        Arrays.sort(winningNumber);
        return winningNumber;
    }

    public int[] getBonusNumber(int [] winningNumber){//보너스 번호 생성하는 메서드
        int[] bonusNumber = {random.nextInt(45)+1};
        boolean exitCheck = false;

        while(!exitCheck) {//보너스 번호와 당첨번호의 중복 체크
            if (isDuplicateCheck(winningNumber, bonusNumber)) {
                exitCheck = true;
            }else {
                bonusNumber[0] = random.nextInt();
            }
        }
        return bonusNumber;
    }

    public boolean isDuplicateCheck(int[] winningNumber, int[] num){ //난수 생성시 중복 값이 있는지 확인하는 메서드
        for(int i =0; i < winningNumber.length; i++){
            if(winningNumber[i] == num[0]){
                return false;
            }
        }
        return true;
    }
}
