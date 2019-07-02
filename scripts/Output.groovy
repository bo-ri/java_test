package scripts

import java.io.BufferdReader
import java.io.ByteArrayOutputStream;
import java.io.IOException
import java.io.PrintStream
import java.io.StringReader

public class Output extends PrintStream {
  private BufferdReader buffer = new BufferdReader(new StringReader(""))

  public Output() {
    super(new ByteArrayOutputStream())
  }

  public String readLine() {
    try{
      String line = ""
      if ((line = buffer.readLine()) != null){
        return line
      } else {
        buffer = new BufferdReader(new StringReader(out.toString()))
        ((ByteArrayOutputStream) out).reset()
        return buffer.readLine()
      }
    } catch (IOException e) {
      throw new RuntimeException(e)
    }
  }
}