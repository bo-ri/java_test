public class Sample {
    public static void main(String[] args) {
        String target = "\npublic class K11 {\n    public static void main (String[] args){\n System.out.println('Hello World')"
        println target
        println ""
        String alt = "K11_123456"
        String grade = "K11"

        String result = target.replace("public class ${grade}", "public class ${alt}")
        println result
        
        //"touch output.txt".execute().waitFor()
        //"echo ${result} >> output.txt".execute().waitFor()
        def file = new File("./output.txt")
        file.text = result

        file.append("\n\n 完了!!")
    }
}
