package models.display;

import java.util.List;
import java.util.Scanner;

import models.Route;
import models.dao.RouteDAO;

public abstract class RouteDisplay {

	static Scanner scanner = new Scanner(System.in);

	private static void printerRoute(Route item) {

		StringBuilder vuotaGiu = new StringBuilder();

		for (String s : item.toString()
				.split("")) {
			vuotaGiu.append("-");
		}
		System.out.println(item);
		System.out.println(vuotaGiu);
	}

	private static void getRoute() {
		System.out.println("Visualizza tutte le routes");
		List<Route> database = RouteDAO.getAll();

		for (Route data : database) {
			printerRoute(data);
		}
	}

	public static void modaleRoute() {

		boolean esegui = true;

		while (esegui) {
			System.out.println("MENU ROUTE");
			System.out.println("""
					0. Torna al menu principale\s
					1. Visualizza lista routes \s
					2. Cerca per inizio e fine tratta poi modifica route
					3. Aggiungi una nuova route
					""");

			try {

				int scelta = scanner.nextInt();
				long routeId = 0;

				switch (scelta)
				{

				case 0 -> {
					System.out.println("Torno al menu principale");
					esegui = false;
				}

				case 1 -> {
					getRoute();
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
							System.out.println("Ricerca per inizio e fine tratta");

							System.out.println("Inserisci l'inizio della tratta'");
							String inizio = scanner.nextLine();

							System.out.println("Inserisci la fine della tratta");
							String fine = scanner.nextLine();

							System.out.println("ricerco tratte...");

							List<Route> findedRoutes = RouteDAO.getRouteBySF(inizio, fine);

							if (findedRoutes.isEmpty()) {
								System.out.println("Nessuna route trovata! Riprova.");
							} else if (findedRoutes.size() == 1) {
								System.out.println("Trovata una sola corrispondenza");
								printerRoute(findedRoutes.get(0));
								routeId = findedRoutes.get(0)
										.getId();
								System.out.println("Seleziono automaticamente la route: " + routeId);
								esegui2 = false;
							} else {
								System.out.println("Trovati " + findedRoutes.size() + " risultati");

								for (Route rt : findedRoutes) {
									printerRoute(rt);
								}

								System.out.println("Inserisci id rotta per selezionare");
								routeId = scanner.nextInt();
								esegui2 = false;
							}

							if (routeId != 0) {
								boolean esegui3 = true;

								while (esegui3) {
									try {
										System.out.println("Che azioni vuoi effettuare?");
										System.out.println("""
												0. Torna al menu principale\s
												1. Aggiorna dati route
												2. Elimina route
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
												System.out.println("Modifica dati route, quale campo vuoi modificare?");
												System.out.println("""
														0. Annulla
														1. Inizio tratta
														2. Fine tratta
														3. Durata tragitto""");

												int sceltaModifica = scanner.nextInt();

												Route routeSelezionato = RouteDAO.getById(routeId);
												switch (sceltaModifica)
												{
												case 0 -> {
													esegui4 = false;
												}
												case 1 -> {
													scanner.nextLine();
													System.out.println("Inserisci nuovo valore per 'inizio tratta': ");
													String nuovoInizio = scanner.nextLine();

													System.out.println("Modifico in " + nuovoInizio);

													RouteDAO.refreshStart(routeSelezionato, nuovoInizio);

												}
												case 2 -> {
													scanner.nextLine();
													System.out.println("Inserisci nuovo valore per 'fine tratta': ");
													String nuovaFine = scanner.nextLine();

													System.out.println("Modifico in " + nuovaFine);

													RouteDAO.refreshFinish(routeSelezionato, nuovaFine);
												}
												case 3 -> {
													scanner.nextLine();

													boolean isInt = true;

													while (isInt) {
														scanner.nextLine();
														try {
															
															System.out.println(
																	"Inserisci nuovo valore per 'durata tragitto': ");

															int nuovoTT = Integer.parseInt(scanner.nextLine());

														   	isInt = false;
														   	
															System.out.println("Modifico in " + nuovoTT + " min");

															RouteDAO.refreshTT(routeSelezionato, nuovoTT);
															
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
												RouteDAO.delete(RouteDAO.getById(routeId));
												esegui3 = false;
											} else {
												System.out.println("Annullo scelta");
												esegui3 = false;
											}
										}
										}

									} catch (Exception e) {
										System.out.println("Qualcosa è andato storto, riprova");
									}
								}
							}

						} catch (Exception e) {
							System.out.println("Qualcosa è andato storto, riprova!");
							scanner.nextLine();
						}
					}
				}

				case 3 -> {
					boolean eseguiAggiunta = true;

					while (eseguiAggiunta) {
						scanner.nextLine();
						try {
							System.out.println("AGGIUNGI NUOVA ROUTE");
							System.out.println("Inserisci inizio tratta");
							String inizio = scanner.nextLine();

							System.out.println("Inserisci fine tratta");
							String fine = scanner.nextLine();

							System.out.println("Inserisci tempo percorrenza");
							int tp = Integer.parseInt(scanner.nextLine());

							Route nuova = new Route(inizio, fine, tp);

							RouteDAO.save(nuova);

							System.out.println("""
									Vuoi salvare un'altra nuova route?
									1. SI
									2. NO""");

							int input = scanner.nextInt();

							if (input == 2) {
								System.out.println("Torno al menu route...");
								eseguiAggiunta = false;
							}

						} catch (Exception e) {
							System.out.println("Qualcosa è andato storto, riprova!");
							scanner.nextLine();
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

}
