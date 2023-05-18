package model;

import java.util.TreeSet;

public class LottoWinNumbers {
    private TreeSet<Integer> lottoSet;

    public LottoWinNumbers() {
    }

    public LottoWinNumbers(TreeSet<Integer> lottoSet) {
        this.lottoSet = lottoSet;
    }

    public TreeSet<Integer> getLottoSet() {
        return lottoSet;
    }

    public void setLottoSet(TreeSet<Integer> lottoSet) {
        this.lottoSet = lottoSet;
    }

    @Override
    public String toString() {
        return "LottoWinNumbers{" +
            "lottoSet=" + lottoSet +
            '}';
    }
}
