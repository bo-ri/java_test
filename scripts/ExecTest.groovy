package scripts;
import src.test.java.sample.SampleTest

public class ExecTest {
  public static void main(String[] args) {
    try {
      execAllTests("../src/test/java/sample")
    }catch (IOException e) {
      println e
    }
  }

  // exec each class in target directory
  public static void execAllTests(String dir){
    fileList(dir).each {File file ->
      if (file.name.contains('.class')){
        println execTargetTest(file, "sample", "")
      }
    }
  }

  // execute target java class
  public static void execTargetTest(File file, String lecNum, String question){
    String className = file.name.split('.java')[0].toString()
    String classPath = "src.test.java."
    // "java org.junit.runner.JUnitCore ${classPath}.${lecNum}.${question}.${className}"
    // "java org.junit.runner.JUnitCore ${classPath}.${question}.${className}"
    SampleTest test = new SampleTest()
    test.before()
    test.testHello()
    test.after()
  }

  // list all files in target directory
  static File[] fileList(String dir){
    def file = new File(dir)
    return file.listFiles()
  }
}