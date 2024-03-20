package step3.view;

import step3.application.domain.model.dto.MovementLog;
import step3.application.domain.model.dto.OneMovementLog;
import step3.application.domain.model.dto.RaceGameLog;

import java.util.List;

public class ResultView {

    public static final String LOCATION_MARK = "-";

    public void printRacingHistory(RaceGameLog raceGameLog) {
        System.out.println("\n실행 결과");
        raceGameLog.getAllMovementLogs().forEach(this::printOneMoveRecord);
    }

    private void printOneMoveRecord(OneMovementLog e) {
        e.getMovementLogs().forEach(this::printLocation);
        System.out.println();
    }

    private void printLocation(MovementLog movementLog) {
        String currentLocation = LOCATION_MARK.repeat(Math.max(0, movementLog.getPosition()));
        System.out.println(String.format("%s : %s", movementLog.getName() ,currentLocation));
    }

    public void printBestDriver(List<String> bestDrivers) {
        System.out.printf("%s 가 최종 우승했습니다.", bestDrivers.toString());
    }
}
