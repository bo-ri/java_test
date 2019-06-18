package test.java.K1;

import libs.StandardInput;
import libs.StandardOutput;

import org.junit.Test;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import main.java.K11;

public class TestK11 {
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

  @Test
  public void testK11() {

    K11.K11_18118193_a8118193_01_K11.main(null);

    Assert.assertThat(out.readLine(), Is.is("1 2 3 4 5"));
    Assert.assertThat(out.readLine(), Is.is("三角形を出力します"));
    Assert.assertThat(out.readLine(), Is.is("***"));
    Assert.assertThat(out.readLine(), Is.is("**"));
    Assert.assertThat(out.readLine(), Is.is("*"));
    Assert.assertThat(out.readLine(), Is.is("四角形を出力します"));
    Assert.assertThat(out.readLine(), Is.is("+++++"));
    Assert.assertThat(out.readLine(), Is.is("+++++"));
    Assert.assertThat(out.readLine(), Is.is("+++++"));
  }
}