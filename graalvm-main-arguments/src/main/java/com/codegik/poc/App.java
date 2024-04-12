package com.codegik.poc;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import org.codehaus.groovy.tools.shell.Command;

public class App {

	public static void main(String[] args) {
		callReflection();
		for (String arg : args) {
			System.out.println("Argument -> " + arg);
		}
	}

	private static void callReflection() {
		try {
			Class.forName("java.lang.Integer");
			Class.forName("java.lang.Integer", true, ClassLoader.getSystemClassLoader());
			Class.forName("java.lang.Integer").getMethod("equals", Object.class);
			Class.forName("groovy.lang.GroovySystem"); // this makes graalvm fail
			Integer.class.getDeclaredMethod("bitCount", int.class);
			Integer.class.getConstructor(String.class);
			Integer.class.getDeclaredConstructor(int.class);
			Integer.class.getField("MAX_VALUE");
			Integer.class.getDeclaredField("value");
			ImmutableSet<ClassPath.ClassInfo> classes = ClassPath.from(App.class.getClassLoader())
					.getTopLevelClasses(Command.class.getPackage().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
