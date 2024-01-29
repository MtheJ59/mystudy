package dao;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map1 {
  char[][] grid;

  public Map1(char[][] grid) {
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

  public static void run() {

    String filePath = "map1.txt";

    try {
      FileReader fileReader = new FileReader(filePath);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      String line;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }

      bufferedReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
