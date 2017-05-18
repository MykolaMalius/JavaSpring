package t1000;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class ActionReaplacer implements MethodReplacer {

	public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		System.out.println("Action by MethodReplacer");
		return null;
	}

}
