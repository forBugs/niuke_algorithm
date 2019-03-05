package fanshe.properties;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class Test {
	public static void main(String[] args) throws Exception{
		


		Class class1= Class.forName(getValue("className"));
		System.out.println(class1);
		Method method = class1.getMethod(getValue("methodName"), null);
		method.invoke(class1.getConstructor(null).newInstance(null));
		
		
		
		
	}
	
	public static String getValue(String key) throws Exception{
		String url = Test.class.getResource("").toString();
		int index = url.indexOf("/");
		url = url.substring(index + 1);
		
		Properties properties = new Properties();
		FileReader fileReader = new FileReader(new File(url+"pro.properties"));
		
		properties.load(fileReader);
		return properties.getProperty(key);
		
		
	}
	
	@org.junit.Test
	public void test() throws Exception, SecurityException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(33);
		
		Class<? extends ArrayList> class1 = list.getClass();
		Method method = class1.getMethod("add", Object.class);
		
		method.invoke(list, "hello");
		for (Object obj : list) {
			System.out.println(obj);
		}
	}

}
