import dao.Map1;
import java.util.Scanner;

public class Main {

  static String playrName;

  public static void SokobanGame() {

    System.out.println("SokobaGame에 오신것을 환영합니다.");

    Scanner sc = new Scanner(System.in);
    System.out.print("플레이어의 이름을 입력하세요.");
    playrName = sc.nextLine();
    System.out.print(playrName + " 플레이어님 환영합니다.");
  }

  public static void mapRun() {
    Map1.run();
  }

  public static void main(String[] args) {
    // 가로 22 세로 11
    SokobanGame();
    System.out.println();
    mapRun();
  }
}