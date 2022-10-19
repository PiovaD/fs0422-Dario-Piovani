package models.display;

import java.util.Scanner;
import java.util.List;
import models.Route;
import models.Vehicle;
import models.Voyage;
import models.dao.RouteDAO;
import models.dao.VehicleDAO;
import models.dao.VoyageDAO;

public class VoyageDisplay {

	static Scanner scanner = new Scanner(System.in);

	private static void printerVoyage(Voyage item) {

		StringBuilder vuotaGiu = new StringBuilder();
		for (String s : item.toString()
				.split("")) {
			vuotaGiu.append("-");
		}
		System.out.println(item);
		System.out.println(vuotaGiu);
	}

	private static void getVoyage() {
		System.out.println("Visualizza tutti i voyage");
		List<Voyage> database = VoyageDAO.getAll();
	try{
		for (Voyage data : database) {
			System.out.println(data);;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
		
	}

	public static void modaleVoyage() {

		boolean esegui = true;

		while (esegui) {
			System.out.println("MENU VOYAGE");
			System.out.println("""
					0. Torna al menu principale\s
					1. Visualizza lista voyages \s
					2. Cerca per veicolo ID e rotta ID poi modifica Voyage
					3. Aggiungi una nuovo Voyage
					""");
			try {

				int scelta = scanner.nextInt();
				long voyageId = 0;

				switch (scelta)
				{

				case 0 -> {
					System.out.println("Torno al menu principale");
					esegui = false;
				}

				case 1 -> {
					getVoyage();
				}

				case 2 -> {
					boolean esegui2 = true;
					int count = 0;

					while (esegui2) {
						if (count == 0) {
							scanner.nextLine();
						}
						count++;

						try {
							System.out.println("Ricerca per veicolo ID e rotta ID poi modifica Voyage");

							System.out.println("Inserisci l'ID del veicolo:");
							int idVeicolo = Integer.parseInt(scanner.nextLine());

							System.out.println("Inserisci l'ID della route:'");
							int idRoute = Integer.parseInt(scanner.nextLine());

							System.out.println("ricerco voyages...");

							List<Voyage> findedVoyage = VoyageDAO.getRouteByIDS(idVeicolo, idRoute);
							
							

							if (findedVoyage.isEmpty()) {
								System.out.println("Nessun voyage trovato! Riprova.");
							} else if (findedVoyage.size() == 1) {
								System.out.println("Trovata una sola corrispondenza");
								printerVoyage(findedVoyage.get(0));
								voyageId = findedVoyage.get(0)
										.getId();
								System.out.println("Seleziono automaticamente il voyage: " + voyageId);
								esegui2 = false;
							} else {
								System.out.println("Trovati " + findedVoyage.size() + " risultati");

								for (Voyage rt : findedVoyage) {
									printerVoyage(rt);
								}

								System.out.println("Inserisci id voyage per selezionare");
								voyageId = scanner.nextInt();
								esegui2 = false;
							}

							if (voyageId != 0) {
								boolean esegui3 = true;

								while (esegui3) {
									try {
										System.out.println("Che azioni vuoi effettuare?");
										System.out.println("""
												0. Torna al menu principale\s
												1. Aggiorna dati voyage
												2. Elimina voyage
												""");

										int sceltaAzione = scanner.nextInt();

										switch (sceltaAzione)
										{
										case 0 -> {
											esegui3 = false;
										}
										case 1 -> {
											boolean esegui4 = true;

											while (esegui4) {
												System.out
														.println("Modifica dati voyage, quale campo vuoi modificare?");
												System.out.println("""
														0. Annulla
														1. Vehicle ID
														2. Route ID
														3. Tempo medio percorenza""");

												int sceltaModifica = scanner.nextInt();

												Voyage voyageSelezionato = VoyageDAO.getById(voyageId);
												switch (sceltaModifica)
												{
												case 0 -> {
													esegui4 = false;
												}
												case 1 -> {
													//scanner.nextLine();
													System.out.println("Inserisci nuovo valore per 'Vehicle ID': ");
													Long newVID = Long.parseLong(scanner.nextLine());

													if (VehicleDAO.getById(newVID) == null) {
														System.out.println(
																"Il Veicolo con ID " + newVID + " non esiste.");
													} else {
														System.out.println("Modifico in " + newVID);

														VoyageDAO.refreshVehicle(voyageSelezionato, newVID);
													}
												}
												case 2 -> {
													//scanner.nextLine();
													System.out.println("Inserisci nuovo valore per 'Route ID': ");
													Long newRID = Long.parseLong(scanner.nextLine());

													if (RouteDAO.getById(newRID) == null) {
														System.out
																.println("La route con ID " + newRID + " non esiste.");
													} else {
														System.out.println("Modifico in " + newRID);

														VoyageDAO.refreshRoute(voyageSelezionato, newRID);
													}
												}
												case 3 -> {
													//scanner.nextLine();

													boolean isInt = true;

													while (isInt) {
														scanner.nextLine();
														try {

															System.out.println(
																	"Inserisci nuovo valore per 'tempo medio percorrenza': ");

															int nuovoAVG = Integer.parseInt(scanner.nextLine());

															isInt = false;

															System.out.println("Modifico in " + nuovoAVG + " min");

															VoyageDAO.refreshAvgTime(voyageSelezionato, nuovoAVG);

														} catch (NumberFormatException nfe) {
															System.out.println("Qualcosa è andato storto, riprova!");
															scanner.nextLine();
														}
													}

												}
												default -> System.out.println("Input non valido");
												}

											}
										}

										case 2 -> {
											System.out.println("""
													Questa azione è irreversibile, sei sicuro?
													 1.SI
													 2.NO""");

											int sceltaEliminazione = scanner.nextInt();

											if (sceltaEliminazione == 1) {
												VoyageDAO.delete(VoyageDAO.getById(voyageId));
												esegui3 = false;
											} else {
												System.out.println("Annullo scelta");
												esegui3 = false;
											}
										}
										}

									} catch (Exception e) {
										System.out.println("Qualcosa è andato storto, riprova" + e);
									}
								}
							}

						} catch (Exception e) {
							System.out.println("Qualcosa è andato storto, riprova!"  + e);
							scanner.nextLine();
						}
					}
				}

				case 3 -> {
					boolean eseguiAggiunta = true;

					while (eseguiAggiunta) {
						if(VehicleDAO.getAll().size() == 0 || RouteDAO.getAll().size() == 0){
							System.out.println("Non ci sono Veicoli o Route da associare, creali!");
							eseguiAggiunta = false;
						}else{
						scanner.nextLine();	
						try {
							System.out.println("AGGIUNGI NUOVA VOYAGE");
							Long newVID = inserisciLong("ID del veicolo"); 
							Vehicle VHold = VehicleDAO.getById(newVID); 
							
							if(VHold == null){
								throw new Exception("ID inserito non corrisponed a nessun Vehicle.");
							}
							if(VHold.getIsService() == false){
								throw new Exception("Veicolo inserito in manutenzione.");
							}

							Long newRID = inserisciLong("ID della tratta");
							Route RHold = RouteDAO.getById(newRID);
							if(RHold == null){
								throw new Exception("ID inserito non corrisponed a nessuna Route");
							}

							int avg = inserisciInt("tempo medio percorrenza");

							Voyage nuovoVoy = new Voyage(VHold, RHold, avg);

							VoyageDAO.save(nuovoVoy);

							System.out.println("""
									Vuoi salvare un'altro Voyage?
									1. SI
									2. NO""");

							int input = scanner.nextInt();

							if (input == 2) {
								System.out.println("Torno al menu voyage...");
								eseguiAggiunta = false;
							}
						} catch (Exception e) {
							System.out.println("Qualcosa è andato storto, riprova!");
							scanner.nextLine();
						}
						}

					}
				}

				default -> {
					System.out.println("Input fuori range. Riprova!");
				}
				}
			} catch (Exception e) {
				System.out.println("Qualcosa è andato storto, riprova");
				scanner.nextLine();
			}

		}

	}

	private static int inserisciInt(String msg) {
		boolean isInt = true;
		while (isInt) {
			try {

				System.out.println("Inserisci " + msg + " : ");

				int inserito = Integer.parseInt(scanner.nextLine());

				isInt = false;

				return inserito;

			} catch (NumberFormatException e) {
				isInt = true;
			}
		}
		System.out.println("Non so come ma sei arrivato qua");
		return (Integer) null;
	}

	private static long inserisciLong(String msg) {
		boolean isLong = true;
		while (isLong) {
			try {

				System.out.println("Inserisci " + msg + " : ");

				Long inserito = Long.parseLong(scanner.nextLine());

				isLong = false;

				return inserito;

			} catch (NumberFormatException e) {
				isLong = true;
			}
		}
		System.out.println("Non so come ma sei arrivato qua");
		return (Integer) null;
	}



}
