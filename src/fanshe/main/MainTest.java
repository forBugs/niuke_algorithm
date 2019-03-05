package fanshe.main;

import java.lang.reflect.Method;

public class MainTest {
	public static void main(String[] args) throws Exception{
		Class class1 = Class.forName("fanshe.main.Student");
		
		Method method = class1.getMethod("main", String[].class);
		System.out.println(method);
		method.invoke(null, (Object)new String[] {"1","32"});
		
		
	}
}
