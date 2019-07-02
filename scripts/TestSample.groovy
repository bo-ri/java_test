// import static groovy.test.GroovyAssert.*
// import static groovy.util.GroovyTestCase.assertEquals

import org.junit.Test
import org.hamcrest.core.Is
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.*

import myutils.StandardInput
import myutils.StandardOutput

import src.main.java.sample.TargetTest

class TestSampleJava {
  def input = new StandardInput()
  def output = new StandardOutput()

  @Before
  public void before() {
    System.setOut(output)
    System.setIn(input)
  }

  @After
  public void after() {
    System.setOut(null)
    System.setIn(null)
  }

  @Test
  public void testHello() {
    input.inputln("aaa")
    input.inputln("bbbb")

    Target.main(null)
    Assert.assertThat(output.readLine(), Is.is("INPUT: "));
    Assert.assertThat(output.readLine(), Is.is("OUTPUT: aaa"));
    Assert.assertThat(output.readLine(), Is.is("INPUT: "));
    Assert.assertThat(output.readLine(), Is.is("OUTPUT: bbb"));
    Assert.assertThat(output.readLine(), Is.is("PROGRAM END"));
  }
}

// def test = new TestSampleJava()
// test.testHello()