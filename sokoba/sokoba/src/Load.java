import java.io.BufferedReader;
import java.io.FileReader;

public class Load {

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
