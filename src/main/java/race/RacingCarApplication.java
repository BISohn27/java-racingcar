package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import race.domain.Car;
import race.domain.Cars;
import race.view.InputView;
import race.view.ResultView;
import utils.StringUtils;
import utils.number.NumberGenerator;
import utils.number.RandomNumberGenerator;

public class RacingCarApplication {

    public static void main(String[] args) {
        String carNames = InputView.requestCarNames();
        int countOfTrial = InputView.requestCountOfTrial();

        ResultView.start();

        String[] names = carNames.split(",");
        Cars cars = Cars.createInstance(names);

        NumberGenerator randomGenerator = new RandomNumberGenerator();
        racing(cars, randomGenerator, countOfTrial);

        ResultView.showWinners(StringUtils.join(",", cars.chooseWinners()));
    }

    private static void racing(Cars cars, NumberGenerator numberGenerator, int countOfTrial) {
        while (countOfTrial > 0) {
            cars.moveCars(numberGenerator);
            ResultView.showProcess(cars);
            countOfTrial--;
        }
    }
}