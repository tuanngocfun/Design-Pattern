package objectPool;

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
  