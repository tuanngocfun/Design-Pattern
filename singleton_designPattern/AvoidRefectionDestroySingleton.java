import java.io.Serializable;

public class AvoidRefectionDestroySingleton implements Serializable{
    private static final long serialVersionUID = 2L;

    private AvoidRefectionDestroySingleton(){}

    private static class SingletonHelper{
        private static final AvoidRefectionDestroySingleton INSTANCE = new AvoidRefectionDestroySingleton();
    }

    public static AvoidRefectionDestroySingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }

    protected Object readResolvObject(){
        return getInstance();
    }
}
