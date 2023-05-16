package lotto_machine;

public class LottoApplicationMain {
    public static void main(String[] args) {
        LottoApplication lotteGame = new LottoApplication();
        lotteGame.setPrint("로또 프로그램 시작");
        System.out.println(lotteGame.getPrint());

    }
}
