import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoService {
    public static final int NUMBER_COUNT = 6;
    public static final int MAX_NUMBER = 45;

    private Random random;

    public LottoService() {
        this.random = new Random();
    }


    /**
     * 자동으로 발급할 로또 티켓 전체 생성
     *
     * @param count - 자동으로 발급할 로또 수
     * @return 자동 생성된 전체 로또 티켓
     */
    public List<List<Integer>> generateAutoTickets(int count) {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> ticket = generateAutoTicket();
            tickets.add(ticket);
        }

        return tickets;
    }


    /**
     * 자동으로 생성된 개별 로또 번호를 반환
     *
     * @return 자동 생성된 개별 로또 티켓
     */
    public List<Integer> generateAutoTicket() {
        List<Integer> ticket = new ArrayList<>();
        while (ticket.size() < NUMBER_COUNT) {
            int number = random.nextInt(MAX_NUMBER) + 1;
            if (!ticket.contains(number)) {
                ticket.add(number);
            }
        }
        Collections.sort(ticket);
        return ticket;
    }


    /**
     *  로또 티켓과 당첨 번호를 비교하여 일치하는 번호의 개수를 세기
     *
     * @param ticket - 사용자의 로또 티켓
     * @param winningNumbers - 당첨 번호
     * @return 일치하는 번호의 개수
     */
    public int countMatchNumbers(List<Integer> ticket, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : ticket) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }


    /**
     *  로또 티켓과 당첨 번호를 비교하여 일치하는 번호의 개수를 세기
     *
     * @param matchCount - 당첨 범호 중 일치하는 번호의 개수
     * @param hasBonusNumber - 보너스 번호 포함 여부
     * @return 총 상금
     */
    public int calculatePrize(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 3) {
            return 5000;
        } else if (matchCount == 4) {
            return 50000;
        } else if (matchCount == 5) {
            if (hasBonusNumber) {
                return 30000000;
            } else {
                return 1500000;
            }
        } else if (matchCount == 6) {
            return 2000000000;
        } else {
            return 0;
        }
    }
}
