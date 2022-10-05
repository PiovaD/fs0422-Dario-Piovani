package esercizioTh;

public class T3 implements Runnable{

    public void run(){
        Rettangolo r1 = new Rettangolo(5,2);
        r1.stampaArea();
        System.out.println(Thread.currentThread().getName());
    }

}
