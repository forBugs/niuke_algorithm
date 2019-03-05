package fanshe;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class ConstructorTes {

	@Test
	public void test() throws Exception {
		Class<?> class1 = Class.forName("fanshe.Student");
		Constructor[] constructors = class1.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}
		System.out.println("-------------------------");
		Constructor[] constructors2 = class1.getDeclaredConstructors();
		for (Constructor constructor : constructors2) {
			System.out.println(constructor);
		}
		System.out.println("-------------------------");

		Constructor<?> c1 = class1.getConstructor(String.class,int.class);
		System.out.println(c1);
		Object o = c1.newInstance("fanbai",232);
		
		
		System.out.println("-------------------------");
		Constructor c2 = class1.getDeclaredConstructor(int.class);
		c2.setAccessible(true);
		System.out.println(c2);
		Object object = c2.newInstance(555);
		
		
	}
}
