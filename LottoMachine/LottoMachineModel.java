package LottoMachine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;
import java.util.Random;

public class LottoMachineModel {
	private int[] lottoNum;
	private int purchase;
	private int price;
	
	
	
	// 숫자 배열로 변환
	public int[] strToInt(String[] lottoList) {
		int[] strToIntLottoList = Stream.of(lottoList)
				.mapToInt(Integer::parseInt).toArray();
		return strToIntLottoList;
	}
	
	// 오름차순 정렬
	public int[] sortArray(int[] lottoNum) {
		Arrays.sort(lottoNum);
		return lottoNum;
	}
	
	// 중복값 확인
	public boolean findDuplicateValue(String[] lottoList) {
		HashSet<String> setLottoList = new HashSet<>(Arrays.asList(lottoList));
		String[] deleteDuplicateLottoList = setLottoList.toArray(new String [0]);
		if (lottoList.length != deleteDuplicateLottoList.length) {
			System.out.println("※로또 번호가 중복되었습니다※");
			return false;
		} else {
			return true;
		}
	}
	
	// 로또 번호 생성
	public int[] createLottoList() {
		Random lotto = new Random();
		int[] lottoList = new int[7];

		for (int i = 0; i < 7; i++) {
			lottoList[i] = (int)(Math.random()*45)+1;
		}
		return lottoList;
	}
	
	// 당첨 번호 매치
	public int matchLottoList(int[] inputLottoList, int[] outputLottoList) {
		int count = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (inputLottoList[i] == outputLottoList[j]) {
					count += 1;
				}
			}
		}
		return count;
	}
	
	public void setPurchase(int purchase) {
		this.purchase = purchase;
	}
	
	public int getPurchase() {
		return purchase;
	}
	
	public void setPrice(int Price) {
		this.price = Price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setLottoNum(int[] lottoNum) {
		this.lottoNum = lottoNum;
	}
	
	public int[] getLottoNum() {
		return lottoNum;
	}

}
