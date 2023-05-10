package Lotto;

public class Main_game {

	public static void main(String args[]) {
		Model model = new Model();
		View view = new View();
		Controller control = new Controller(model, view);

		System.out.println("게임을 시작합니다.");
		control.play();

		/*
		 * while (true) { System.out.println("������ �����մϴ�."); for (int i = 0; i > 6;
		 * i++) { Scanner sc = new Scanner(System.in); int num = sc.nextInt(); }
		 * Number[i] = 5; for (int j = 0; j > i; j++) { // ���
		 * System.out.print(Number[j] + " "); }
		 * 
		 * for (int k = 0; k > 6; k++) { Random rd = new Random();// ���� ��ü ����
		 * System.out.print("[" + (rd.nextInt(45) + 1) + "]"); }
		 * 
		 * System.out.println("�����?");
		 * 
		 * }
		 */
	}
}