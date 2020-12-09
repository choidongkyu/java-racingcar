package step3.view;

import step3.domain.Car;
import step3.domain.Cars;

import java.util.stream.Collectors;

public class RacingGameOutputView {

  public static final String DISTANCE_MARK = "-";
  public static final String COLON_MARK = ":";
  public static final String SPACE_MARK = " ";
  public static final String COMMA_AND_SPACE_MARK = ", ";

  public static void printRacingGameResult(Cars cars) {
    for (Car car : cars.getCars()) {
      System.out.println(makeRacingGameResult(car));
    }
    System.out.println();
  }

  public static void printWinnerResult(Cars cars) {
    String winnerNames = cars.getWinnerCars().stream()
        .map(Car::getName)
        .collect(Collectors.joining(COMMA_AND_SPACE_MARK));
    System.out.println(winnerNames + "가 최종 우승했습니다.");
  }

  private static StringBuilder makeRacingGameResult(Car car) {
    StringBuilder racingGameResult = new StringBuilder(car.getName())
        .append(SPACE_MARK).append(COLON_MARK).append(SPACE_MARK);
    for (int i = 0; i < car.getDistance(); i ++) {
      racingGameResult.append(DISTANCE_MARK);
    }
    return racingGameResult;
  }
}
