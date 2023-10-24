package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameStart();
    }

    static void gameStart() {
        List<Integer> computerNumber = randomNumber();

        int userNumber = 0;
        String gameHint = Hint.generateHint(userNumber, computerNumber);

        while (!gameHint.equals("3스트라이크")) {
            userNumber = UserValue.getUserInput();
            UserValue.validateNumber(userNumber);
            gameHint = Hint.generateHint(userNumber, computerNumber);
            System.out.println(gameHint);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restartGameOrExit(Integer.parseInt(Console.readLine()));
    }

    static List<Integer> randomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static void restartGameOrExit(int number) {
        if (number == 1) {
            gameStart();
        }
    }
}
