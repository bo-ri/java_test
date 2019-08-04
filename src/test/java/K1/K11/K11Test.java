// package src.test.java.K1.K11;

import myutils.StandardInput;
import myutils.StandardOutput;

import org.junit.Test;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;

import static java.lang.System.*;
// import java.io.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import java.lang.reflect.Method;

import src.main.java.K1.K11.*;

public class K11Test {
  // private StandardInput in = new StandardInput();
  // private StandardOutput out = new StandardOutput();

  // @Before
  // public void before() {
  //   System.setOut(out);
  //   System.setIn(in);
  // }

  // @After
  // public void after() {
  //   System.setOut(newPrintStream(new FileOutputStream(FileDescriptor.out), getProperty("sun.stdout.encoding")));
  //   System.setIn(new BufferedInputStream(new FileInputStream(FileDescriptor.in)));
  // }

  // @Test
  // public void testHello() {

  // }
  public static void main(String[] args) throws Exception {
    List<Class<?>> classes = getClasses("src.main.java.K1.K11");
    for (Class<?> target : classes) {
      System.out.println(target.getName());
      System.out.println("");
      Class para[] = new Class[] {String[].class};
      Method m = target.getMethod("main", para);
      Object[] ob = new Object[] {null};
      m.invoke(target.newInstance(), ob);
    }
  }

  private static List<Class<?>> getClasses(String packageName) throws IOException, URISyntaxException, ClassNotFoundException {
    // class loader
    ClassLoader cl = Thread.currentThread().getContextClassLoader();

    // get resources under target package
    Enumeration<URL> e = cl.getResources(packageName.replace(".", "/"));

    List<Class<?>> classes = new ArrayList<Class<?>>();

    // パッケージ配下のリソースの数だけループ
		for (; e.hasMoreElements();) {

			// リソースのURLを取得
			URL url = e.nextElement();

			// URLをファイルオブジェクトに変換
			File dir = new File(url.getPath());

			// ディレクトリ配下のファイル数分ループ
			for (String path : dir.list()) {

				// ".class"で終わるファイルのみ返却用のリストに追加
				if (path.endsWith(".class")) {
					classes.add(Class.forName(packageName + "." + path.substring(0, path.length() - 6)));
				}
			}
		}
		return classes;
  }
}