package metaclass;

import java.lang.invoke.MethodHandles;

import metaclass.MetaClass;

import static java.lang.invoke.MethodType.*;

/**
 * このプログラムは以下のURLにあるソースコードを参考にしています。 
 * http://code.google.com/p/jsr292-cookbook/
 */
public class Main {

	public static String toLowerCase(String s) {
		return s.toLowerCase();
	}

	public static void main(String[] args) throws ReflectiveOperationException {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello".toUpperCase());

			if (i == 5) {
				MetaClass.getMetaClass(String.class).redirect(
						"toUpperCase",
						methodType(String.class),
						MethodHandles.lookup().findStatic(Main.class,
								"toLowerCase",
								methodType(String.class, String.class)));
			}
		}
	}
}
