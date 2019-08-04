package scripts;

// testの実行
public class Build {
  public static void main(String[] args) {
    compileAll('../src/main/java/K1')
  }

  // src/main/java/test以下の全てのtest実行
  static String compileAll(String targetdir) {
    File dirs = new File(targetdir)
    dirs.listFiles().each { File dir ->
    println dir
      File files = new File(dir.toString())
      files.listFiles().each { File file ->
        println file
        println compile(file)
      }
    }
  }

  // build individual java file
  // fileオブジェクト渡せばbuildする
  static String compile(File file) {
    "javac ${file}".execute().waitFor()
    return file.name.split('.java')[0].toString() + ".class"
    
  }

}