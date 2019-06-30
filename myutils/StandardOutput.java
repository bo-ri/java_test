package myutils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

public class StandardOutput extends PrintStream {
  private BufferedReader buffer = new BufferedReader(new StringReader(""));

  public StandardOutput() {
    super(new ByteArrayOutputStream());
  }

  public String readLine() {
    try {
      String line = "";
      if ((line = buffer.readLine()) != null) {
        return line;
      } else {
        buffer = new BufferedReader(new StringReader(out.toString()));
        ((ByteArrayOutputStream) out).reset();
        return buffer.readLine();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
