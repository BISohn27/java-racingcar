package racing.input;

import racing.exception.InvalidInputValueException;

import java.util.List;

public class CarInfo {

    private final static String INPUT_DELIMITER = ",";

    private final List<String> names;

    private CarInfo(String input) {
        validateValue(input);
        this.names = List.of(input.split(INPUT_DELIMITER));
    }

    public static CarInfo of(String input) {
        return new CarInfo(input);
    }

    private void validateValue(String input) {
        if (input.isBlank()) {
            throw new InvalidInputValueException("레이스 참가자 수는 1 이상이여야 합니다.");
        }
    }

    public List<String> names() {
        return names;
    }

    public int count() {
        return names.size();
    }
}
