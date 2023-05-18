package model;

import java.util.ArrayList;
import java.util.TreeSet;

public class Player {

    private int money;
    private int totalLotto;
    private int manualLotto;
    private int autoLotto;

    private ArrayList<TreeSet<Integer>> lottoSetList;

    public Player() {
    }

    public Player(int money, int totalLotto, int manualLotto, int autoLotto) {
        this.money = money;
        this.totalLotto = totalLotto;
        this.manualLotto = manualLotto;
        this.autoLotto = autoLotto;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTotalLotto() {
        return totalLotto;
    }

    public void setTotalLotto(int totalLotto) {
        this.totalLotto = totalLotto;
    }

    public int getManualLotto() {
        return manualLotto;
    }

    public void setManualLotto(int manualLotto) {
        this.manualLotto = manualLotto;
    }

    public int getAutoLotto() {
        return autoLotto;
    }

    public void setAutoLotto(int autoLotto) {
        this.autoLotto = autoLotto;
    }

    public ArrayList<TreeSet<Integer>> getLottoSetList() {
        return lottoSetList;
    }

    public void setLottoSetList(ArrayList<TreeSet<Integer>> lottoSetList) {
        this.lottoSetList = lottoSetList;
    }

    @Override
    public String toString() {
        return "Player{" +
            "money=" + money +
            ", totalLotto=" + totalLotto +
            ", manualLotto=" + manualLotto +
            ", autoLotto=" + autoLotto +
            ", lottoSetList=" + lottoSetList +
            '}';
    }
}
