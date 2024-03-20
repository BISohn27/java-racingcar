package step3.application.domain;

import step3.application.domain.model.dto.RaceGameLog;
import step3.application.generator.MovableGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceGame {

    private final RacingCars racingCars;

    public RaceGame(List<String> names) {
        this.racingCars = new RacingCars(names);
    }

    public RaceGame(List<String> names, List<Integer> positions) {
        this.racingCars = new RacingCars(names, positions);
    }

    public RaceGameLog startRace(int moveCount, MovableGenerator movableGenerator) {
        validateCount(moveCount);
        return new RaceGameLog(IntStream.rangeClosed(1, moveCount)
                .mapToObj(num -> racingCars.doRace(movableGenerator))
                .collect(Collectors.toList())
        );
    }

    private void validateCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }

    public List<String> findBest(List<String> names) {
        int maxPosition = this.extractMaxPosition();
        List<Car> bestCars = racingCars.findBestDriver(maxPosition);

        return names.stream()
                .filter(name -> isBestDriver(bestCars, name))
                .collect(Collectors.toList());
    }

    private int extractMaxPosition() {
        return racingCars.extractMaximumPosition();
    }

    private boolean isBestDriver(List<Car> cars, String name) {
        return cars.stream()
                .anyMatch(car -> car.isDriver(name));
    }
}
