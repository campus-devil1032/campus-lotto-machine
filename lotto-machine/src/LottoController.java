import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoController {

    /**
     * 로또 게임을 진행 할 금액을 입력 받는다.
     * 로또는 한 게임 당 천원이다. (한 게임 당 여섯개의 번호가 발급된다.)
     * 입력 금액과 로또 한장의 금액이 나눠 떨어져야 한다. (검증로직)
     * 1회 구매 한도는 최소 천원이상이다.
     * 수동으로 발급 할 로또 게임 수를 입력 받는다. 그리고 그 수에 맞게 로또 번호를 입력 받는다.
     * 이어서 수동 발급 장수를 제외한 장수만큼 자동으로 로또 티켓을 생성한다.
     * 로또 한 게임에는 여섯 개의 정수가 중복 없이 존재한다.
     * 로또 번호는 1 ~ 45 이다.
     * 입력 받은 번호는 오름차순으로 정렬 된다.
     * 로또 티켓 구매가 완료 되면 게임을 시작한다.
     * 로또게임 한 회차당 여섯개의 당첨번호와 보너스 볼이 존재한다.
     * 당첨 번호는 중복되는 숫자가 없는 정수 값이다.
     * 보너스 볼 역시 당첨번호와 중복되어선 안된다.
     */
    private Random random;

    private LottoView view;
    private LottoGame game;

    public LottoController() {
        this.view = new LottoView();
        this.game = new LottoGame();
        this.random = new Random();
    }

    public void startGame() {

        // 금액 입력 받기 (1000원 단위로)
        int amount;
        while (true) {
            amount = view.getAmount();
            if (amount % 1000 == 0 && amount>=1000) {
                break;
            } else {
                view.displayErrorMessage("금액은 1000원 단위로 입력해야 합니다. 다시 입력해주세요.");
            }
        }


        // 로또 티켓 개수 계산
        int ticketCount = amount / 1000;

        // 수동으로 발급할 로또 게임 수 입력 받기
        int manualCount = view.getManualCount();
        if (manualCount > ticketCount) {
            view.displayErrorMessage("수동으로 발급할 로또 게임 수는 총 티켓 수를 초과할 수 없습니다.");
            return; // 메소드 실행 중단
        }


        // 수동으로 발급할 로또 번호 입력 받기
        List<List<Integer>> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            List<Integer> numbers = view.getManualNumbers();
            manualNumbers.add(numbers);
        }

        // 자동으로 발급할 로또 티켓 생성
        List<List<Integer>> autoTickets = game.generateAutoTickets(ticketCount - manualCount);

        // 수동으로 발급한 로또 티켓과 자동으로 발급한 로또 티켓 합치기
        List<List<Integer>> allTickets = new ArrayList<>(manualNumbers);
        allTickets.addAll(autoTickets);


        view.displayMyLottos(allTickets);


        // 게임 시작

        // 당첨 번호 생성
        List<Integer> winningNumbers = game.generateAutoTicket();
        view.displayWinningLottos(winningNumbers);

        // 보너스 볼 생성
        int bonusNumber;
        do {
            bonusNumber = random.nextInt(LottoGame.MAX_NUMBER) + 1;
        } while (winningNumbers.contains(bonusNumber));

        view.displayBonusNumber(bonusNumber);

        // 게임 결과 계산
        int totalPrize = 0;
        for (List<Integer> ticket : allTickets) {
            int matchCount = game.countMatchNumbers(ticket, winningNumbers);
            boolean hasBonusNumber = ticket.contains(bonusNumber);
            int prize = game.calculatePrize(matchCount, hasBonusNumber);
            totalPrize += prize;
        }
        view.displayPrize(totalPrize);

        // 수익률 계산
        int totalAmount = allTickets.size() * 1000;
        double profitRate = (double) totalPrize / totalAmount;

        // 결과 출력
        view.displayResult(profitRate);
    }
}
