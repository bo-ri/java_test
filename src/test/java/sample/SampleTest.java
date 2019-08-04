package src.test.java.sample;

// import org.hamcrest.core.Is;
import myutils.StandardInput;
import myutils.StandardOutput;

import org.junit.Test;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;

import static java.lang.System.*;
import java.io.*;

import src.main.java.sample.TargetTest;


public class SampleTest {
  private StandardInput in = new StandardInput();
  private StandardOutput out = new StandardOutput();

  @Before
  public void before() {
    System.setOut(out);
    System.setIn(in);
  }

  @After
  public void after() {
    System.setOut(newPrintStream(new FileOutputStream(FileDescriptor.out), getProperty("sun.stdout.encoding")));
    System.setIn(new BufferedInputStream(new FileInputStream(FileDescriptor.in)));
  }

  private static PrintStream newPrintStream(FileOutputStream fos, String enc) {
    if (enc != null) {
        try {
            return new PrintStream(new BufferedOutputStream(fos, 128), true, enc);
        } catch (UnsupportedEncodingException e) {
        }
    }
    return new PrintStream(new BufferedOutputStream(fos, 128), true);
  }

  @Test //(expected = IOException.class)
  public void testHello() {
    
    // try{
      in.inputln("aaa");
      in.inputln("bbb4");
      TargetTest.main(null);
      Assert.assertThat(out.readLine(), Is.is("INPUT: "));
      Assert.assertThat(out.readLine(), Is.is("OUTPUT: aaa"));
      Assert.assertThat(out.readLine(), Is.is("INPUT: "));
      Assert.assertThat(out.readLine(), Is.is("OUTPUT: bbb"));
      Assert.assertThat(out.readLine(), Is.is("PROGRAM END"));
  }
}
