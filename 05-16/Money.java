package lotto_machine;

public class Money {
	public static void money_Manage(int total_money, int[][] number,int number_6, int number_5, int number_4, int number_3, double revenue, int times) {  // 수익률 관리 함수
		total_money += number_6*2000000000;
	    total_money += total_money + (number_5*1500000);
		total_money += total_money + (number_4*50000);
		total_money += total_money + (number_3*5000);
		revenue = (double)total_money/times;
		System.out.println(revenue);
	}
}
