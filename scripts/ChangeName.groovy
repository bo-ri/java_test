package scripts;

public class ChangeName{

  static void changeClassName (String stage) {
    String targetFilePath = 'src/main/java/'
    String testFilePath = 'src/test/java'
    fileList("../${targetFilePath}${stage}").each { File dir ->
      fileList(dir.toString()).each { File file ->
        if (file.name.contains('.txt')) {
          deleteFile("${dir}/${file.name}")
          return
        }
        println "before createTargerFile"
        createTargetFile(file, dir.name.toString(), stage)
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

  static def createTargetFile(file, grade, stage) {
    if (file.name.contains('.java')) {
      String defaultFilePath = "../src/main/java/${stage}/${grade}/${file.name}"
      String newFilePath = "../src/main/java/${stage}/${grade}/${grade}_${file.name}"
      String fileName = "${grade}_${file.name}".split('.java')[0].toString()

      String defaultCode = new File(file.toString()).text
      defaultCode = defaultCode.replaceAll("package ${grade};", "")
      defaultCode = defaultCode.replaceAll("public class ${grade}", "public class ${fileName}")
      
      // create new file
      def testCodeFile = new File(newFilePath)

      // add package statement
      testCodeFile.text = "pacakge ${grade};\n\n"

      // add test code
      testCodeFile.append(defaultCode)

      // // delete default file
      "rm ${defaultFilePath}".execute().waitFor()
    } else {
      println "delete invalid extension file -> ${file.name}"
      // deleted action here
    }
    deleteFile("../src/main/java/${stage}/${grade}/${file.name}")
  }


  public static void main(String[] args) {
    String stage = "K1"
    changeClassName(stage)
  }
}