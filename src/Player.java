/////////////////////////////////////////////////////////////////////////// 플레이어(유저) Data
public class Player { 
	private int money;
	private String name;
	private int[][] ownTicketList = new int[100][6];// 소유티켓
	private int ownTicketNumber = 0;
	private int totalBuyTicket = 0;
	private int reward5 = 0;
	private int reward4 = 0;
	private int reward3 = 0;
	private int reward2 = 0;
	private int reward1 = 0;

	Player(int money, String name) {
		this.money = money;
		this.name = name;
	}

	public int getPlayerMoney() {
		return this.money;
	}

	public void setPlayerMoney(int money) {
		this.money = money;
	}

	public String getPlayerName() {
		return this.name;
	}

	public void playerLoseMoney(int money) {
		this.money -= money;
	}

	public void playerEarnMoney(int money) {
		this.money += money;
	}

	public void setPlayerTicketList(int[][] list) {
		this.ownTicketList = list;
	}

	public int[][] getPlayerTicketList() {
		return this.ownTicketList;
	}

	public void setPlayerTicketNumber(int otn) {
		this.ownTicketNumber = otn;
		this.setTotalBuyTicket(otn);
	}

	public int getPlayerTicketNumber() {
		return this.ownTicketNumber;
	}

	public int getTotalBuyTicket() {
		return totalBuyTicket;
	}

	public void setTotalBuyTicket(int ownticket) {
		this.totalBuyTicket += ownticket;
	}

	public int getReward5() {
		return reward5;
	}

	public void addReward5() {
		reward5 += 1;
	}

	public int getReward4() {
		return reward4;
	}

	public void addReward4() {
		reward4 += 1;
	}

	public int getReward3() {
		return reward3;
	}

	public void addReward3() {
		reward3 += 1;
	}

	public int getReward2() {
		return reward2;
	}

	public void addReward2() {
		reward2 += 1;
	}

	public int getReward1() {
		return reward1;
	}

	public void addReward1() {
		reward1 += 1;
	}
}


