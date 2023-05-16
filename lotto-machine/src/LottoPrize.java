public enum LottoPrize {
    MATCH_3(5, 5000),
    MATCH_4(4, 50000),
    MATCH_5(3, 1500000),
    MATCH_5_PLUS_BONUS(2, 30000000),
    MATCH_6(1, 2000000000);


    private int rank;
    private int prizeAmount;

    LottoPrize(int rank, int prizeAmount) {
        this.rank = rank;
        this.prizeAmount = prizeAmount;
    }

    public int getRank() {
        return rank;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static void valueOf(int matchCount, boolean hasBonusBall) {
        LottoPrize lottoPrize = null;
        if (matchCount == 3) {
            lottoPrize = MATCH_3;
        } else if (matchCount == 4) {
            lottoPrize = MATCH_4;
        } else if (matchCount == 5 && hasBonusBall) {
            lottoPrize = MATCH_5_PLUS_BONUS;
        } else if (matchCount == 5) {
            lottoPrize = MATCH_5;
        } else if (matchCount == 6) {
            lottoPrize = MATCH_6;
        }

        if (lottoPrize != null) {
            LottoView.displayPrize(lottoPrize);
        }
    }
}
