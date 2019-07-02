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
    System.setOut(null);
    System.setIn(null);
  }

  @Test (expected = RuntimeException.class)
  public void testHello() {
    
    in.inputln("aaa");
    in.inputln("bbbb");

    TargetTest.main(null);
    Assert.assertThat(out.readLine(), Is.is("INPUT: "));
    Assert.assertThat(out.readLine(), Is.is("OUTPUT: aaa"));
    Assert.assertThat(out.readLine(), Is.is("INPUT: "));
    Assert.assertThat(out.readLine(), Is.is("OUTPUT: bbb"));
    Assert.assertThat(out.readLine(), Is.is("PROGRAM END"));
  }
}
