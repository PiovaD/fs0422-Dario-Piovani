package esercizioTh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        ex 1
//        creare 3 thread: due con l'estensione dell'apposita classe, uno con l'implementazione dell'apposita interfaccia
//        Le tre classi da creare si chiamano T1, T2, T3
//
//        I loro metodi "run" creano rispettivamente:
//        - un'iterazione tra x e y (valori indicati dall'utente)
//        - un logging in console tramite logback di un array di caratteri generato da una parola inserita dall'utente
//        (in senso invertito). ogni carattere deve essere loggato ogni 2 secondi
//                - la generazione di un'istanza della classe Rettangolo(base, altezza) che estende la classe Forma,
//                e il richiamo del suo metodo stampaArea()
//        fornire ai 3 thread un nome a piacere, e all'interno di ogni metodo run stampare il nome del thread in azione

        Scanner input = new Scanner(System.in);
        boolean loop = false;
        T1 test1 = null;
        T2 test2  = null;

        do{
            loop = false;
            try{

                System.out.println("inserisci i valori!");
                int primoNum = input.nextInt();
                int secondoNum = input.nextInt();

                test1  = new T1(primoNum, secondoNum, "uno");

            }catch (Exception e){
                System.out.println("errore riprova!!!");
                loop = true;
                input.next();
            }

        }while (loop);


        boolean loop1 = false;

        do{
            loop1 = false;
            try{

                System.out.println("inserisci una stringa!");
                String parola = input.next();

                test2  = new T2(parola, "due");

            }catch (Exception e){
                System.out.println("errore riprova!!!");
                loop1 = true;
                input.next();
            }

        }while (loop1);

        if (test1 != null && test2 != null){
            test1.start();
            test2.start();
        }

        T3 t3 = new T3();
        Thread test3 = new Thread(t3, "tre");
        test3.start();

        input.close();


    }
}