package fanshe;

public class Fanshe {
	public static void main(String[] args) {
		Student s = new Student();
		Class class1 = s.getClass();
		
		Class class2 = Student.class;
		System.out.println(class1 == class2);
		
		try {
			Class class3  = Class.forName("fanshe.Student");
			System.out.println(class3 == class2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
