import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Calculator {
    private int number;

    private Calculator(int number) {
        this.number = number;
    }
    private int add(int secondary) {

        return this.number + secondary;

    }
}

class CalculatorExample {
    public static void CalcTest() {
        try {
            Class<?> calcClass = Class.forName("Calculator");

            Constructor<?> constructor = calcClass.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);

            Object calcInstance = constructor.newInstance(50); // Initialize instance with 50

            Method addMethod = calcClass.getDeclaredMethod("add", int.class); // vrf funkar inte getMethod!!!
            addMethod.setAccessible(true);

            int result = (int) addMethod.invoke(calcInstance, 25); // add 25
            System.out.println("Result: " + result);
        }
        catch (Exception e) { // I'm handling it all.
            System.out.println("I've had ENOUGH!:  " + e.getMessage());
        }
    }
}