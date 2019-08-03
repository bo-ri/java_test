
// package main.java.sample;
package src.main.java.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TargetTest {
  public static void main(String[] args) {
    try {
      BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
      for (int i = 0; i < 2; i++) {
        System.out.println("INPUT: ");
        String line;
        line = stdReader.readLine();
        System.out.println("OUTPUT: " + line);
      }

      stdReader.close();
      System.out.println("PROGRAM END");
    } catch (Exception e) {
      e.getStackTrace();
      System.exit(-1);
    }
    // System.out.print("Hello World");
  }
}
