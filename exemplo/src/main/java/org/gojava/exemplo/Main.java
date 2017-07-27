package org.gojava.exemplo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;

public class Main {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    String[] symbols = new String[] {"","",""};
    
    Observable<BigDecimal> feed = Server.getFeed(symbols);
    
    LOGGER.info("Obteve observable.");
    
    feed.subscribe(
        bigdecimal -> System.out.println(bigdecimal),
        e -> LOGGER.error("Error", e),
        () -> LOGGER.info("Fim do Stream")
    );
  }
}
