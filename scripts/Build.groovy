package scripts;

public class Build {
  public static void main(String[] args) {

  }

  static String compile(String file) {
    try {
      // String filePath = "../src/main/java/${stage}/${grade}/file.name"
      "javac ${file.toString()}".execute().waitFor()
      return file.name.split('.java')[0].toString() + ".class"
    } catch (IOExeption e) {
      return null
    }
  }

  static int execJava(file) {
    try {
      "java ${file.toString()}".execute().waitFor()
      return 1
    } catch(IOExeption e) {
      return 0
    }
  }
}