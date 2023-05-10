package LottoMachine;

public class Main {

	public static void main(String[] args) {
		LottoMachineModel model = new LottoMachineModel(2);
		LottoMachineController controllerFirst = new LottoMachineController(model, null);
		LottoMachineView viewFirst = new LottoMachineView(controllerFirst);
		LottoMachineController controllerSecond = new LottoMachineController(model,viewFirst);
		LottoMachineView view = new LottoMachineView(controllerSecond);
		view.getInputLottoNum();
	}

}
