package scripts;
import src.test.java.sample.SampleTest

public class ExecTest {
  public static void main(String[] args) throws AssertionError {
    execAllTests("../src/test/java/sample")
  }

  public static void printResult(e){
    println "テスト終了"
  }

  // exec each class in target directory
  public static void execAllTests(String dir){
    fileList(dir).each {File file ->
      println file.name
      if (file.name.contains('.class')){
        execTargetTest(file, "sample", "")
      } else {
        return
      }
    }
  }

  public static void runTest (SampleTest test) {
    test.before()
    test.testHello()
    test.after()
  }

  // execute target java class
  public static void execTargetTest(File file, String lecNum, String question) throws AssertionError{
    println "build now"
    String className = file.name.split('.java')[0].toString()
    String classPath = "src.test.java."
    // "java org.junit.runner.JUnitCore ${classPath}.${lecNum}.${question}.${className}"
    // "java org.junit.runner.JUnitCore ${classPath}.${question}.${className}"
    SampleTest test = new SampleTest()
    try {
      // stringBuilder のnullpoでるpo
      test.before()
      test.testHello()
      test.after()
    } catch (AssertionError e){
      test.after()
      println "execTargetTest"
      // throw e
    }
    // println "finish test"
  }

  // list all files in target directory
  static File[] fileList(String dir){
    def file = new File(dir)
    return file.listFiles()
  }
}