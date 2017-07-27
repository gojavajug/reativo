package org.gojava.exemplo;

import java.math.BigDecimal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class Server {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

  public static Observable<BigDecimal> getFeed(String[] symbols) {
    LOGGER.info("Observable criado.");
    return Observable.create(emitter -> emitirEvento(emitter, symbols));
    
  }

  private static void emitirEvento(ObservableEmitter<BigDecimal> emitter, String[] symbols) {
    LOGGER.info("Pronto para emitir o Stream.");
    
    while(true) {
      Arrays.stream(symbols).
       map(symbol -> BigDecimal.ZERO)
       .forEach(emitter::onNext);
      
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        emitter.onError(e);
      }
    }
  }

}
