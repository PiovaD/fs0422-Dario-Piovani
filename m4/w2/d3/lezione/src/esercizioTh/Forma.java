package esercizioTh;

public abstract class Forma{

    public abstract void stampaArea();
}
class Rettangolo extends Forma{
    double base;
    double altezza;

    public Rettangolo(double _base, double _altezza){
        base = _base;
        altezza = _altezza;
    }

    @Override
    public void stampaArea() {
        System.out.println("L'area del rettangolo è: "+ (base*altezza));
    }
}