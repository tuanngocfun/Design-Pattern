package summaryObjectPool;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args) {
      OliphauntPool pool = new OliphauntPool();
      LOGGER.info(pool.toString());
      Oliphaunt oliphaunt = pool.checkOut();
      LOGGER.info("Checked out {}", oliphaunt);
      LOGGER.info(pool.toString());
    }
}
class Oliphaunt {

    private static int counter = 1;
  
    private final int id;
  
    /**
     * Constructor
     */
    public Oliphaunt() {
        id = counter++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
  
    public int getId() {
      return id;
    }
  
    @Override
    public String toString() {
      return String.format("Oliphaunt id=%d", id);
    }
}
abstract class ObjectPool<T> {

    private Set<T> available = new HashSet<>();
    private Set<T> inUse = new HashSet<>();

    protected abstract T create();

    /**
     * Checkout object from pool
     */
    public synchronized T checkOut() {
        if (available.isEmpty()) {
        available.add(create());
        }
        T instance = available.iterator().next();
        available.remove(instance);
        inUse.add(instance);
        return instance;
    }

    public synchronized void checkIn(T instance) {
        inUse.remove(instance);
        available.add(instance);
    }

    @Override
    public String toString() {
        return String.format("Pool available=%d inUse=%d", available.size(), inUse.size());
    }
}
class OliphauntPool extends ObjectPool<Oliphaunt> {

    @Override
    protected Oliphaunt create() {
      return new Oliphaunt();
    }
}