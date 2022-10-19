package models.display;

import models.User;
import models.dao.UserDAO;

import java.util.List;
import java.util.Scanner;

public class UserDisplay {
    UserDAO utente = new UserDAO();
    static Scanner scanner = new Scanner(System.in);
    private void saveUtente(String nome, String cognome) {
        User ut = new User();
        ut.setName( nome );
        ut.setLastName( cognome );
        utente.save( ut );
    }

    private void printerUtente(User item) {

        StringBuilder vuotaGiu = new StringBuilder();

        for( String s : item.toString().split( "" ) ) {
            vuotaGiu.append( "-" );
        }
        System.out.println( item );
        System.out.println( vuotaGiu );
    }

    private void getUtenti() {
        System.out.println( "Visualizzo il catalogo utenti" );
        List<User> database = utente.getAll();

        for( User data : database ) {
            printerUtente( data );
        }
    }

    public void modaleUtente() {
        boolean esegui = true;

        while( esegui ) {
            System.out.println( "MENU UTENTE" );
            System.out.println( """
                    0. Torna al menu principale\s
                    1. Visualizza lista utenti \s
                    2. Cerca per nome e cognome poi modifica utente
                    3. Aggiungi un nuovo utente
                    """ );

            try {
                int scelta = scanner.nextInt();
                long userId = 0;

                switch (scelta) {
                    case 0 -> {
                        System.out.println( "Torno al menu principale" );
                        esegui = false;
                    }

                    case 1 -> {
                        getUtenti();
                    }

                    case 2 -> {
                        boolean esegui2 = true;
                        int count = 0;

                        while( esegui2 ) {
                            if( count == 0 ) {
                                scanner.nextLine();
                            }
                            count++;

                            try {
                                System.out.println( "Ricerca per nome e cognome" );

                                System.out.println( "Inserisci il nome dell'utente" );
                                String nome = scanner.nextLine();

                                System.out.println( "Inserisci il cognome dell'utente'" );
                                String cognome = scanner.nextLine();

                                System.out.println( "ricerco utenti..." );

                                List<User> findedUtenti = utente.getUserByFullName( nome, cognome );

                                if( findedUtenti.isEmpty() ) {
                                    System.out.println( "Nessun utente trovato! Riprova." );
                                } else if( findedUtenti.size() == 1 ) {
                                    System.out.println( "Trovata una sola corrispondenza" );
                                    printerUtente( findedUtenti.get( 0 ) );
                                    userId = findedUtenti.get( 0 ).getId();
                                    System.out.println( "Seleziono automaticamente il numero tessera: " + userId );
                                    esegui2 = false;
                                } else {
                                    System.out.println( "Trovati " + findedUtenti.size() + " risultati" );

                                    for( User ut : findedUtenti ) {
                                        printerUtente( ut );
                                    }

                                    System.out.println( "Inserisci numero tessera per selezionare l'utente" );
                                    userId = scanner.nextInt();
                                    esegui2 = false;
                                }

                                if( userId != 0 ) {
                                    boolean esegui3 = true;

                                    while( esegui3 ) {
                                        try {
                                            System.out.println( "Che azioni vuoi effettuare?" );
                                            System.out.println( """
                                                    0. Torna al menu principale\s
                                                    1. Aggiorna dati utente
                                                    2. Elimina utente
                                                    """ );

                                            int sceltaAzione = scanner.nextInt();

                                            switch (sceltaAzione) {
                                                case 0 -> {
                                                    esegui3 = false;
                                                }
                                                case 1 -> {
                                                    boolean esegui4 = true;

                                                    while( esegui4 ) {
                                                        System.out.println( "Modifica dati utente, quale campo vuoi modificare?" );
                                                        System.out.println( """
                                                                0. Annulla
                                                                1. Nome
                                                                2. Cognome""" );

                                                        int sceltaModifica = scanner.nextInt();

                                                        User utenteSelezionato = utente.getById( userId );
                                                        switch (sceltaModifica) {
                                                            case 0 -> {
                                                                esegui4 = false;
                                                            }
                                                            case 1 -> {
                                                                scanner.nextLine();
                                                                System.out.println( "Che nome vuoi dare a " + utenteSelezionato.getName() + " ?" );
                                                                String nuovoNome = scanner.nextLine();

                                                                System.out.println( "Modifico in " + nuovoNome );

                                                                utente.refreshName( utenteSelezionato, nuovoNome );

                                                            }
                                                            case 2 -> {
                                                                scanner.nextLine();
                                                                System.out.println( "Che cognome vuoi dare a " + utenteSelezionato.getName()+ " " + utenteSelezionato.getLastName() + " ?" );
                                                                String nuovoCognome = scanner.nextLine();
                                                                System.out.println( "Modifico in " + nuovoCognome );

                                                                utente.refreshLastName( utenteSelezionato, nuovoCognome );
                                                            }
                                                            default -> System.out.println( "Input fuori range" );
                                                        }

                                                    }
                                                }


                                                case 2 -> {
                                                    System.out.println( """
                                                            Questa azione è irreversibile, sei sicuro?
                                                             1.SI
                                                             2.NO""" );

                                                    int sceltaEliminazione = scanner.nextInt();

                                                    if( sceltaEliminazione == 1 ) {
                                                        utente.delete( utente.getById( userId ) );
                                                        esegui3 = false;
                                                    } else {
                                                        System.out.println( "Annullo scelta" );
                                                        esegui3 = false;
                                                    }
                                                }
                                            }

                                        } catch( Exception e ) {
                                            System.out.println( "Qualcosa è andato storto, riprova" );
                                        }
                                    }
                                }

                            } catch( Exception e ) {
                                System.out.println( "Qualcosa è andato storto, riprova!" );
                                scanner.nextLine();
                            }
                        }

                    }

                    case 3 -> {
                        boolean eseguiAggiunta = true;

                        while( eseguiAggiunta ) {
                            scanner.nextLine();
                            try {
                                System.out.println( "AGGIUNGI NUOVO UTENTE" );
                                System.out.println( "Inserisci nome" );
                                String nome = scanner.nextLine();

                                System.out.println( "Inserisci cognome" );
                                String cognome = scanner.nextLine();

                                saveUtente( nome, cognome );

                                System.out.println( """
                                        Vuoi salvare un nuovo utente?
                                        1. SI
                                        2. NO""" );

                                int input = scanner.nextInt();

                                if( input == 2 ) {
                                    System.out.println( "Torno al menu utente..." );
                                    eseguiAggiunta = false;
                                }

                            } catch( Exception e ) {
                                System.out.println( "Qualcosa è andato storto, riprova!" );
                                scanner.nextLine();
                            }
                        }
                    }


                    default -> {
                        System.out.println( "Input fuori range. Riprova!" );
                    }
                }
            } catch( Exception e ) {
                System.out.println( "Qualcosa è andato storto, riprova" );
                scanner.nextLine();
            }
        }


    }
}
