package racing.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.race.RacePosition.FORWARD;
import static racing.race.RacePosition.STOP;

public class RaceRecordTest {

    private final static String CAR_NAME = "bisohn27";

    List<Boolean> forwardResults = List.of(true, false, false, true, false);

    @Test
    void record() {
        RaceCar car = getRaceCar();
        RaceRecord record = car.raceRecord();

        assertThat(record.name()).isEqualTo(CAR_NAME);
        for (int i = 0; i < forwardResults.size(); i++) {
            assertThat(record.raceResult(i))
                    .isEqualTo(forwardResults.get(i) ? FORWARD : STOP);
        }
    }

    private RaceCar getRaceCar() {
        RaceCar car = new RaceCar(CAR_NAME);
        forwardResults.forEach(car::race);
        return car;
    }
}
