package program2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ModelDTO {
	private static Scanner input = new Scanner(System.in);
	private static int gugu_dan;
	private String print;
	private static int cal_result;
	private int cal_n1, cal_n2;
	
	public ModelDTO(int gugu_dan) {
		this.gugu_dan = gugu_dan;
	}
	
	public int getCal_n1() {
		return cal_n1;
	}

	public void setCal_n1(int cal_n1) {
		this.cal_n1 = cal_n1;
	}

	public int getCal_n2() {
		return cal_n2;
	}

	public void setCal_n2(int cal_n2) {
		this.cal_n2 = cal_n2;
	}

	public static int getGugu_dan() {
		return gugu_dan;
	}

	public void setGugu_dan(int gugu_dan) {
		this.gugu_dan = gugu_dan;
	}
	
	static int getCal_result() {
		return cal_result;
	}

	public void setCal_result(int cal_result) {
		this.cal_result = cal_result;
	}
	
		
	public String getPrint() {
		
		System.out.println("[정상출력] " + print);
		
		while (true) {
			
			try {
				View.SelectSwitch(input,this.cal_n1, this.cal_n2);
					
			} catch (InputMismatchException e) {
				System.out.println("잘못된 문자를 입력했습니다!");
				input = new Scanner(System.in);
			}
			

		}

	}

	public void setPrint(String print) {
		this.print = print;
	}
	
	
	public static void cal_Operator(int cal_n1, int cal_n2) {
		String oper = "";
		System.out.println("연사자를 선택해주세요:");
		System.out.println("더하기: +, 뺴기: -, 곱하기: *, 나누기: /");	
		oper = input.next();
		
		switch (oper) {
		case "+":
			cal_result = cal_n1 + cal_n2;
			break;
		case "-":
			cal_result = cal_n1 - cal_n2;
			break;
		case "*":
			cal_result = cal_n1 * cal_n2;
			break;
		case "/":
			cal_result = cal_n1 / cal_n2;
			break;
		default:
			System.out.println("잘못된 연사자가 입력되었습니다! ");
			System.out.println("연사자를 선택해주세요:");
			System.out.println("더하기: +, 뺴기: -, 곱하기: *, 나누기: /");
			cal_Operator(cal_n1, cal_n2);
		}
		
	}
}

