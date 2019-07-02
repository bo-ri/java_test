package scripts;

public class ChangeName{

  static void changeClassName (String lecNum) {
    String targetFilePath = 'src/main/java/'
    String testFilePath = 'src/test/java'
    fileList("../${targetFilePath}${lecNum}").each { File dir ->
      fileList(dir.toString()).each { File file ->
        if (file.name.contains('.txt')) {
          deleteFile("${dir}/${file.name}")
          return
        }
        println "before createTargerFile"
        createTargetFile(file, dir.name.toString(), lecNum)
      }
    }
  }

  static def deleteFile(String file) {
    // project.delete file
    "rm ${file}".execute().waitFor()
  }

  static File[] fileList(String dir) {
    def file = new File(dir)
    file.listFiles()
  }

  static def createTargetFile(File file, String question, String lecNum) {
    if (file.name.contains('.java')) {
      String defaultFilePath = "../src/main/java/${lecNum}/${question}/${file.name}"
      String newFilePath = "../src/main/java/${lecNum}/${question}/${question}_${file.name}"
      String fileName = "${question}_${file.name}".split('.java')[0].toString()

      String defaultCode = new File(file.toString()).text
      defaultCode = defaultCode.replaceAll("package ${question};", "")
      defaultCode = defaultCode.replaceAll("public class ${question}", "public class ${fileName}")
      
      // create new file
      def testCodeFile = new File(newFilePath)

      // add package statement
      testCodeFile.text = "pacakge ${question};\n\n"

      // add test code
      testCodeFile.append(defaultCode)

      // // delete default file
      "rm ${defaultFilePath}".execute().waitFor()
    } else {
      println "delete invalid extension file -> ${file.name}"
      // deleted action here
    }
    deleteFile("../src/main/java/${lecNum}/${question}/${file.name}")
  }


  public static void main(String[] args) {
    String lecNum = "K1"
    changeClassName(lecNum)
  }
}