package model;

public class Lotto {
    private int[] lottos;

    public Lotto() {
    }

    public Lotto(int[] lottos) {
        this.lottos = lottos;
    }

    public int[] getLottos() {
        return lottos;
    }

    public void setLottos(int[] lottos) {
        this.lottos = lottos;
    }
}
