package Lotto;

//model,view 

public class Controller {

	private Model model;
	private View view;
	int num;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void play() {
		System.out.println("게임시작!");
		view.getNum(); // 값 넣기
		view.showNum(num); // 값 출력하기

	}
}
