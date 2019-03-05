package fanshe.method;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws Exception{
		Class class1 = Class.forName("fanshe.method.Student");
		
		Object obj = class1.getConstructor().newInstance();
		Method[] methods = class1.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		
		System.out.println("--------------");
		
		Method[] methods2 = class1.getDeclaredMethods();
		for (Method method : methods2) {
			System.out.println(method);
		}
		
		System.out.println("------");
		Method method = class1.getMethod("show1", String.class);
		
		method.invoke(obj, "fanbai");
		System.out.println("------");
		Method method2 = class1.getDeclaredMethod("show4", int.class);
		method2.setAccessible(true);
		method2.invoke(obj, 10000);
		
		
		
	}
}
