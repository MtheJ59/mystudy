package dao;

  // Map 클래스 정의
  public class Map {
    private char[][] grid;

    public Map(char[][] grid) {
      this.grid = grid;
    }

    public void displayMap() {
      for (char[] row : grid) {
        for (char cell : row) {
          System.out.print(cell + " ");
        }
        System.out.println();
      }
    }
  }

  // Player 클래스 정의


  // Main 클래스에서 Map과 Player 클래스 사용

