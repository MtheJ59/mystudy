package dao;

public class Player {
    private int x;  // 플레이어의 x 좌표
    private int y;  // 플레이어의 y 좌표

    public Player(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public void move(int dx, int dy) {
      // 이동 전의 위치를 공백으로 표시
      // 여기에서는 예시로 'P'로 표시
      System.out.println("이동 전 위치: (" + x + ", " + y + ")");

      // 플레이어의 위치 업데이트
      x += dx;
      y += dy;

      // 이동 후의 위치를 'P'로 표시
      System.out.println("이동 후 위치: (" + x + ", " + y + ")");
    }
  }

