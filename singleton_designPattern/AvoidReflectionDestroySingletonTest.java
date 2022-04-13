import java.lang.reflect.Constructor;

public class AvoidReflectionDestroySingletonTest {
    public static void main(String[] args) {
        AvoidRefectionDestroySingleton instanceOne = AvoidRefectionDestroySingleton.getInstance();
        AvoidRefectionDestroySingleton instanceTwo = null;
        try{
            Constructor[] constructors = AvoidRefectionDestroySingleton.class.getDeclaredConstructors();
            for(Constructor constructor : constructors){
                constructor.setAccessible(true);
                instanceTwo = (AvoidRefectionDestroySingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(instanceOne);
        System.out.println(instanceTwo);
    }
}
