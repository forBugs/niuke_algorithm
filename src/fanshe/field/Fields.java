package fanshe.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Fields {
	public static void main(String[] args) throws Exception{
		
		Class c1 = Class.forName("fanshe.field.Student");
		
		Field[] fields = c1.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		
		System.out.println("------------------");
		
		Field[] fields2 = c1.getDeclaredFields();
		for (Field field : fields2) {
			System.out.println(field);
		}
		
		System.out.println("--------------------");
		Constructor con = c1.getConstructor(null);
		Object object = con.newInstance(null);
		Field field = c1.getField("name");
		System.out.println(field);
		field.set(object, "fanbai");
		System.out.println(object);
		
		System.out.println("------------------");
		
		Field field2 = c1.getDeclaredField("phoneNum");
		field2.setAccessible(true);
		field2.set(object, "18335166305");
		System.out.println(object);
		
	}
}
