package LottoMachine;

public class LottoMachineController {
	private LottoMachineModel model;
	private LottoMachineView view;
	
	public LottoMachineController(LottoMachineModel model, LottoMachineView view) {
		this.model = model;
		this.view = view;
	}
	
	/*
	public void perchaseTicket() {
		boolean isValid = false;
		while(!isValid) {
			try {
				if () {
					
				}
			} catch (NumberFormatException e) {
				view.printErrorMsg(3);
			}
		}
	}
	*/
	
	public void setLottoNum() {
		boolean isValid = false;
		while(!isValid) {
			try {
				String[] strLottoList = view.getLottoNum();
				int[] intLottoList = model.strToInt(strLottoList); 		// 문자열 배열 정수형 배열로 변환
				intLottoList = model.sortArray(intLottoList); 			// 배열 오름차순 정렬
				
				for (int i = 0; i < 6; i++) { 							// 예외처리
					if (intLottoList[i] < 1 || intLottoList[i] > 45) {	// 1~45 외의 숫자 예외처리
						throw new ArithmeticException();
					} else if (strLottoList.length > 6) {				// 6개 이상의 숫자 입력 시 예외처리
						throw new ArrayIndexOutOfBoundsException();
					}
				}
				
				if (model.findDuplicateValue(strLottoList) == false) {	// 중복값 확인
					throw new NumberFormatException(); 
				}
				
				model.setLottoNum(intLottoList);
				isValid = true;
			} catch (NumberFormatException e) {							// 정수 외의 값 입력 시 예외처리
				view.printErrorMsg(1);
			} catch (ArithmeticException e) {
				view.printErrorMsg(1);
			} catch (ArrayIndexOutOfBoundsException e) {
				view.printErrorMsg(2);
			}
		}
	}
	
	public void updateView() {
		// 로또 구매
		// view.receiveMoney();
		
		// 입력 및 생성 로또 번호 출력
		int[] inputLottoList = model.getLottoNum();
		int[] outputLottoList = model.createLottoList();
		view.printInputLottoNum(inputLottoList);
		
		// 로또 번호 정렬
		int[] sortedOutputLottoList = model.sortArray(model.createLottoList());
		view.printOutputLottoNum(sortedOutputLottoList);
		// view.printOutputLottoNum(outputLottoList);
		
		
		int matchLottoList = model.matchLottoList(inputLottoList, sortedOutputLottoList);
		view.printLottoGameResult(matchLottoList);
	}

}
