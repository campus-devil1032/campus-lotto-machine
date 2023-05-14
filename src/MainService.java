import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MainService {
    public void start () {
        // lotto 난수 생성
        int[] lottos = new int[6];
        for(int i = 0; i < 6; i++){
            int num = (int) ((Math.random() * 45) + 1);
            lottos[i] = num;
        }
        System.out.println("lotto " + Arrays.toString(lottos));

        // 사용자 입력 받기
        System.out.println("공백을 기준으로 로또 번호 6개를 입력해 주세요 ! ");
        System.out.println("(예) 1 4 15 19 22 50 11");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String userInput = br.readLine();
            String[] userInputs = userInput.split(" ");
            //String[] userInputs = new String[] {"1", "3", "5", "7", "9", "11"};
            int[] userLottos = new int[6];


            // String -> Int 타입 변환 TODO : Stream 사용해서 수정해보기
            for (int i = 0; i < userInputs.length; i++) {
                userLottos[i] = Integer.parseInt(userInputs[i]);
            }

            System.out.println("userlotto" + Arrays.toString(userLottos));

            // 일단 for 문으로 비교

            int count = 0;
            ArrayList<Object> prizes = new ArrayList<>();

            for(int lotto: lottos) {
                for(int userLotto: userLottos){
                    if( lotto == userLotto ){
                        count++;
                        prizes.add(lotto);
                    }
                }
            }

            System.out.println("총 " + count + " 개 일치 했습니다.");
            System.out.println("당첨된 번호는 = " + prizes.toString() + " 입니다." );

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
