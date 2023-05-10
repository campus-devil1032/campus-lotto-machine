package LottoMachine;

public class LottoMachineController {
	private LottoMachineModel model;
	private LottoMachineView view;
	
	public LottoMachineController(LottoMachineModel model, LottoMachineView view) {
		this.model = model;
		this.view = view;
	}
	
	public void showTable(int num) {
		model = new LottoMachineModel(num);
		String createNumTable = model.createLotto();
		String inputNumTable = model.getInputTable();
		view.displayTable(inputNumTable);
		view.displayTable(createNumTable);
	}

}
