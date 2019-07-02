package scripts

import java.io.IOException
import java.io.InputStream

public class Input extends InputStream {
  private StringBuilder buffer = new StringBuilder()
  private static String crlf = System.getProperty("line.separator")

  public void imputln(String str) {
    buffer.append(str).append(crlf)
  }

  @Override
  public int read() throws IOException {
    if (buffer.length() == 0) {
      return -1
    }
    int result = buffer.charAt(0)
    buffer.deleteCharAt(0)
    return result
  }
}