package LotoUpdate;

public enum LottoPrizeModel {
    LAST(0),
    FIVE(5000),
    FOUR(50000),
    THREE(1500000),
    TWO(30000000),
    ONE(2000000000);

    private final int prize;

    LottoPrizeModel(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}


