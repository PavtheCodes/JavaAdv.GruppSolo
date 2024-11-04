import java.lang.reflect.Method;


//Tre metoder men bara två kommer skrivas ut i terminalen, sista ska inte bli "called"
public class AnnotationCall {
    @AutoCall
    public void firstRing() {
        System.out.println("Ring...");
    }
    @AutoCall
    public void secondRing() {
        System.out.println("Ring... Ring...");
    }
    public void fillerMethod() {
        System.out.println("Filler Method");
    }
}

class AutoCalling {
    public static void invokeAllMethods(Object obj) {
        Method[] methods = obj.getClass().getDeclaredMethods(); // fastnade här i 10 min för den behöver getDeclaredMethods och inte bara getMethods??

        for (Method metod : methods) {
            if (metod.isAnnotationPresent(AutoCall.class)) {
                try {
                    metod.invoke(obj);
                } catch (Exception e) {
                    System.out.println("NO WORK YO: " + metod.getName());
                }
            }
        }
    }
    public static void invokeMethod() {
        AnnotationCall annotationCall = new AnnotationCall();
        invokeAllMethods(annotationCall);
    }
}
