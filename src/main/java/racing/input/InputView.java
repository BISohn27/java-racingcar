package racing.input;

import java.util.Scanner;

public class InputView {

    public RaceInput racingInput() {
        System.out.println("자동차 대수는 몇대인가요?");
        int numOfCar = input();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numOfAttempt = input();

        return new RaceInput(numOfCar, numOfAttempt);
    }

    private int input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
