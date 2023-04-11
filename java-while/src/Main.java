import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) 
    		throws NoSuchMethodException {
        TempClass tc = new TempClass();
        HelloCheck helloCheck = tc.getClass().getAnnotation(HelloCheck.class);
        System.out.println(helloCheck.value());

        Method hello = tc.getClass().getMethod("hello");
        HelloCheck helloCheck1 = hello.getAnnotation(HelloCheck.class);
        System.out.println(helloCheck1.value());
    }
}