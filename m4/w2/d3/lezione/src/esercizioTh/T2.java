package esercizioTh;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class T2 extends Thread{

    final static Logger logger = LoggerFactory.getLogger(T2.class);

    String parola;

    public T2(String _parola, String _name){
        parola = _parola;
        this.setName(_name);
    }

    @Override
    public void run(){


        try{

            char[] arr = parola.toCharArray();

            for (int i = arr.length-1; i >= 0; i--) {
                logger.info(getName() + " " + arr[i]);
                Thread.sleep(2000);
            }

        }catch ( InterruptedException e ){
            logger.error("ERRORE!");
        }


    }
}
