package test;

import java.lang.reflect.Field;

public class T5 {
	
	@D2
	public int aaa = 5;

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		T5 t5 = new T5();
		
		Class<T5> clazz = T5.class;
		Field[] fields = clazz.getDeclaredFields();
		for (Field f:fields) {
			if(f.getAnnotation(D2.class) != null) {
				f.setAccessible(true);
				f.set(t5, (int)f.get(t5)*2);
				System.out.println("aaaaaaaaa:"+f.get(t5));
			}
		}
	}
	
}
