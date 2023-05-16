package LottoMachine;

public class Main {

	public static void main(String[] args) {
		LottoMachineModel model = new LottoMachineModel();
		LottoMachineView view = new LottoMachineView();
		LottoMachineController controller = new LottoMachineController(model, view);
		
		controller.setLottoNum();
		controller.updateView();
	}

}
