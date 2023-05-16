public class ConsolViewer {// 뷰어

	public static void menu() {
		System.out.println("=======================================");
		System.out.println("1. 로또");
		System.out.println("2. 당첨 현황");
		System.out.println("3. 종료");
		System.out.println("=======================================");
	}

	public static void viewWin(Player p) {
		System.out.println("=======================================");
		System.out.println("1등 : " + p.getReward1());
		System.out.println("2등 : " + p.getReward2());
		System.out.println("3등 : " + p.getReward3());
		System.out.println("4등 : " + p.getReward4());
		System.out.println("5등 : " + p.getReward5());
		System.out.println("전체티켓 : " + p.getTotalBuyTicket());
		System.out.println("=======================================");
	}

}