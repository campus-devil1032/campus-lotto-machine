package campus_lotto_machine.LottoMachine;

public class LottoMachineMain {
    public static void main(String[] args) {
        LottoMachineModel model = new LottoMachineModel();
        LottoMachineView view = new LottoMachineView();
        LottoMachineController controller = new LottoMachineController(model, view);

        controller.start();
    }
}