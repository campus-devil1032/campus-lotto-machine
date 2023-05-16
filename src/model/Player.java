package model;

public class Player {

    private int money;
    private int totalLotto;
    private int manualLotto;
    private int autoLotto;


    public Player() {
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
}
