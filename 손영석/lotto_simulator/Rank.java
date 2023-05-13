package lotto_simulator;

import java.util.Arrays;
import java.util.function.BiFunction;

// 등수 계산
public enum Rank {
	FIRST(6, false, 2_000_000_000, "1등", (matchCount, matchBonus) -> matchCount == 6),
	SECOND(5, true, 30_000_000, "2등", (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
	THIRD(5, false, 1_500_000, "3등", (matchCount, matchBonus) -> matchCount == 5 && !matchBonus),
	FOURTH(4, false, 50_000, "4등", (matchCount, matchBonus) -> matchCount == 4),
	FIFTH(3, false, 5_000, "5등", (matchCount, matchBonus) -> matchCount == 3),
	MISS(0, false, 0, "꽝!", (matchCount, matchBonus) -> matchCount <= 2);

	private final int matchCount; // 일치하는 수
	private final boolean matchBonus; // 보너스 일치 여부
	private final long prize; // 상금
	private final String rankName;	// 등수 이름
	private final BiFunction<Integer, Boolean, Boolean> expression;

	// 생성자
	private Rank(int matchCount, boolean matchBonus, long prize, String rankName,
			BiFunction<Integer, Boolean, Boolean> expression) 
	{
		this.matchCount = matchCount;
		this.matchBonus = matchBonus;
		this.prize = prize;
		this.rankName = rankName;
		this.expression = expression;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public boolean getMatchBonus() {
		return matchBonus;
	}
	
	// 상금
	public long getPrize() {
		return prize;
	}
	
	// 등수 이름
	public String getRankName() {
		return rankName;
	}

	public boolean win(int matchCount, boolean matchBonus) {
		return expression.apply(matchCount, matchBonus);
	}
	
	// 등수 가져오기
	public static Rank getRank(int matchCount, boolean matchBonus) {
		return Arrays.stream(Rank.values())
				.filter(rank -> rank.win(matchCount, matchBonus))
				.findFirst()
				.orElse(Rank.MISS);
	}

}