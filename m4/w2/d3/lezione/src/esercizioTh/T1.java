package esercizioTh;

public class T1 extends Thread {
    int x;
    int y;


   public T1(int _x, int _y, String _name){
        x = _x;
        y = _y;
        this.setName(_name);
   }

   public void run(){
       for (int i = x; i <= y; i++) {
           System.out.println(getName() +" "+ i);
       }
   }


}
