package dao;

public class Main {
  public static void main(String[] args) {
    char[][] initialMap = {
        {'.','.','.','.','#','#','#','#','#','.','.','.','.','.','.','.','.','.','.','.','.','.'},
        {'.','.','.','.','#','.','.','.','#','.','.','.','.','.','.','.','.','.','.','.','.','.'},
        {'.','.','.','.','#','$','.','.','#','.','.','.','.','.','.','.','.','.','.','.','.','.'},
        {'.','.','#','#','#','.','.','$','#','#','#','.','.','.','.','.','.','.','.','.','.','.'},
        {'.','.','#','.','.','$','.','.','$','.','#','.','.','.','.','.','.','.','.','.','.','.'},
        {'#','#','#','.','#','.','#','#','#','.','#','.','.','.','.','.','#','#','#','#','#','#'},
        {'#','.','.','.','#','.','#','#','#','.','#','#','#','#','#','#','#','.','.','O','O','#'},
        {'#','.','$','.','.','$','.','.','.','.','.','.','.','.','.','.','.','.','.','O','O','#'},
        {'#','#','#','#','#','.','#','#','#','#','.','#','@','#','#','#','#','.','.','O','O','#'},
        {'.','.','.','.','#','.','.','.','.','.','.','#','#','#','.','.','#','#','#','#','#','#'},
        {'.','.','.','.','#','#','#','#','#','#','#','#','.','.','.','.','.','.','.','.','.','.'}
    };

    // Map 객체 생성
    Map map = new Map(initialMap);

    // Player 객체 생성
    Player player = new Player(13, 3);  // 초기 위치

    // 현재 맵 상태 출력
    System.out.println("초기 맵 상태:");
    map.displayMap();

    // 플레이어 이동
    player.move(0, 1);  // 오른쪽으로 이동

    // 이동 후 맵 상태 출력
    System.out.println("이동 후 맵 상태:");
    map.displayMap();
  }
}
