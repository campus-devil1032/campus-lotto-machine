package LotoUpdate;
import java.util.Arrays;
import java.util.Scanner;
public class LottoView {
    Scanner in;
    private int inputAmount;

    private int inputGameNumber;
    public LottoView(){
        this.in = new Scanner(System.in);
    }

    public int getInputAmount(){
        System.out.println("로또 게임을 진행 할 금액을 입력해주세요");
        System.out.println("로또는 한 게임 당 천원입니다");
        inputAmount = in.nextInt();
        //TODO 1000으로 나뉘어 떨어지는지 확인해야함
        if(inputAmount % 1000 != 0 )
        {
            System.out.println("1000원 단위만 입력 가능합니다");
        }

        return inputAmount / 1000;
    }

    public int getInputGameNumber(int inputAmount){
        System.out.println("발급 할 로또 게임 수를 입력하세요");
        System.out.println("발급 할 수 있는 로또 게임 수는 " +inputAmount+ "개 입니다");
        inputGameNumber = in.nextInt();
        in.nextLine(); //입력 스트림 비우기;;;

        return inputGameNumber;
    }

    public String isInputNumberView(){ //TODO 오류 처리 해야함
        System.out.println("로또 번호 6개를 띄어 쓰기로 구분해서 입력해주세요");
        return in.nextLine();
    }

    public void isResultOutView(int repeat, int count, int bonusCount, int prizeMoney){
        System.out.println("----------- "+repeat + "번째 게임" + " -------------");
        System.out.println("당첨번호는" + count + "개 당첨입니다 " + "보너스 번호는" + bonusCount + "개 당첨입니다");
        System.out.println("상금은 " + prizeMoney + "원입니다");
        System.out.println("-------------------------------------------");
    }

    public void isWinningNumberView(int[] winningNumber, int[] bonusNumber){
        System.out.println("이번 회차 당첨번호는 " + Arrays.toString(winningNumber) + "입니다.");
        System.out.println("이번 회차 보너스번호는 " + Arrays.toString(bonusNumber) + "입니다.");
    }

    public void isRateOfReturn(double profitResult){
        System.out.println("수익률은 " + profitResult + "입니다");
    }

    public void isRateOfReturnAnalysis(String profitResultAnalysis){
        System.out.println("수익률에 따른 해석은 " + profitResultAnalysis + "입니다");
    }
}
