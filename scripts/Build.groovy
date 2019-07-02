package scripts;

public class Build {
  public static void main(String[] args) {

  }

  // build java file
  static String compile(String file, String lecNum, String question) {
    try {
      // String filePath = "../src/main/java/${stage}/${grade}/file.name"
      "javac src/main/java/${lecNum}/${question}/${file.name.toString()}".execute().waitFor()
      return file.name.split('.java')[0].toString() + ".class"
    } catch (IOExeption e) {
      return null
    }
  }
}