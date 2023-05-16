import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoGame {
    public static final int NUMBER_COUNT = 6;
    public static final int MAX_NUMBER = 45;

    private Random random;

    public LottoGame() {
        this.random = new Random();
    }

    public List<List<Integer>> generateAutoTickets(int count) {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> ticket = generateAutoTicket();
            tickets.add(ticket);
        }

        return tickets;
    }

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


    public int countMatchNumbers(List<Integer> ticket, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : ticket) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

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
