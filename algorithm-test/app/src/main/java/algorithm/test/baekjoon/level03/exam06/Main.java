package algorithm.test.baekjoon.level03.exam06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    StringTokenizer st;

    for (int i = 1; i <= T; i++) {
      int A = Integer.parseInt();
      int B = Integer.parseInt();

      System.out.println(A + B);
    }
  }
}
