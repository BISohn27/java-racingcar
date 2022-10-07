package step3.domain;

import java.util.List;

public class GameInfo {

    private final List<Car> carList;
    private final int count;

    public GameInfo(List<String> names, int count) {
        this.carList = new Cars(names).getCarList();
        this.count = count;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getCount() {
        return count;
    }
}