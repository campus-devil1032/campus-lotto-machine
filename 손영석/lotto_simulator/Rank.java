package lotto_simulator;

// 등수 계산
public enum Rank {
	FIRST(6, 2000000000), SECOND(5, 30000000), THIRD(5, 15000000), FOURTH(4, 50000), FIFTH(3, 5000), SIXTH(0, 0);

	private final int countOfMatch; // 일치하는 수
	private final int prize; // 상금

	// 생성자
	private Rank(int countOfMatch, int prize) {
		this.countOfMatch = countOfMatch;
		this.prize = prize;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getPrize() {
		return prize;
	}

	public static Rank valueOf(int countOfMatch, boolean matchBonus) {
		return null;
	}
}