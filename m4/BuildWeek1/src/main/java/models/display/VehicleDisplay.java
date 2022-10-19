package models.display;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import models.Vehicle;
import models.VehicleType;
import models.dao.VehicleDAO;

public class VehicleDisplay {

	static Scanner scanner = new Scanner(System.in);

	private static void printerVehicle(Vehicle item) {

		StringBuilder vuotaGiu = new StringBuilder();

		for (String s : item.toString()
				.split("")) {
			vuotaGiu.append("-");
		}
		System.out.println(item);
		System.out.println(vuotaGiu);
	}

	private static void getVehicle() {
		System.out.println("Visualizzo il catalogo veicoli");
		List<Vehicle> database = VehicleDAO.getAll();

		for (Vehicle data : database) {
			printerVehicle(data);
		}
	}

	public static void modaleVehicle() {
		boolean esegui = true;

		while (esegui) {
			System.out.println("MENU VEICOLI");
			System.out.println("""
					0. Torna al menu principale\s
					1. Visualizza lista veicoli \s
					2. Cerca per ID
					3. Aggiungi un nuovo veicolo
					""");

			try {
				int scelta = scanner.nextInt();
				long veId = 0;

				switch (scelta)
				{
				case 0 -> {
					System.out.println("Torno al menu principale");
					esegui = false;
				}

				case 1 -> {
					getVehicle();
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
							System.out.println("Ricerca per ID");

							System.out.println("Inserisci ID veicolo");
							Long vehicleID = scanner.nextLong();

							System.out.println("ricerco veicolo...");

							Vehicle findedVehicle = VehicleDAO.getById(vehicleID);

							if (findedVehicle.equals(null)) {
								System.out.println("Nessun veicolo trovato! Riprova.");
							} else {
								System.out.println("Trovato");
								printerVehicle(findedVehicle);
								esegui2 = false;
							}

							if (vehicleID != 0) {
								boolean esegui3 = true;

								while (esegui3) {
									try {
										System.out.println("Che azioni vuoi effettuare?");
										System.out.println("""
												0. Torna al menu principale\s
												1. Aggiorna dati veicolo
												2. Elimina veicolo
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
														.println("Modifica dati veicolo, quale campo vuoi modificare?");
												System.out.println("""
														0. Annulla
														1. Stato di servizio
														2. Data manutenzione""");

												int sceltaModifica = scanner.nextInt();

												Vehicle selectedVehicle = VehicleDAO.getById(vehicleID);
												switch (sceltaModifica)
												{
												case 0 -> {
													esegui4 = false;
												}
												case 1 -> {
													boolean eseguiService = false;

													do {
														scanner.nextLine();
														System.out.println("Il mezzo " + selectedVehicle.getId()
																+ " è in servizio? 1: si, 2: no");
														short servizio = scanner.nextShort();

														if (servizio == 1){
															eseguiService = false;
															selectedVehicle.setService(true);
															
															if (!selectedVehicle.getIsService())
																System.err.println(
																		"La manutenzione è scaduta impossibile mettere in servizio il mezzo");
														}else if(servizio == 2){
															eseguiService = false;
															selectedVehicle.setService(false);
														}else {
															eseguiService = true;
															System.out.println("Unexpected value: " + servizio);
														}

													} while (eseguiService);

													VehicleDAO.refresh(selectedVehicle);

												}
												case 2 -> {
													scanner.nextLine();
													System.out.println("La Manutenzione scade il: "
															+ selectedVehicle.getMaintenance()
															+ ", inserire numero di mesi prossima manutezione: ");
													int month = scanner.nextInt();

													LocalDate newMaintenance = LocalDate.now()
															.plusMonths(month);
													System.out.println("Modifico in " + newMaintenance);

													selectedVehicle.setMaintenance(newMaintenance);

													VehicleDAO.refresh(selectedVehicle);
												}
												default -> System.out.println("Input fuori range");
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
												VehicleDAO.delete(VehicleDAO.getById(vehicleID));
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
							System.out.println("AGGIUNGI NUOVO VEICOLO");

							boolean newVehicle = false;

							do {
								System.out.println("Inserisci tipo di veicolo: 1: BUS | 2: TRAM");
								int type = scanner.nextInt();
								
								if(type == 1){
									
									Vehicle v = new Vehicle(VehicleType.BUS);
									
									VehicleDAO.save(v);

									newVehicle = false;
								}else if(type == 2){
									
									Vehicle v = new Vehicle(VehicleType.TRAM);
																		
									VehicleDAO.save(v);

									newVehicle = false;
								}else {
									newVehicle = true;
									System.out.println("Unexpected value: " + type);
								}

							} while (newVehicle);

							System.out.println("""
									Vuoi salvare un nuovo veicolo?
									1. SI
									2. NO""");

							int input = scanner.nextInt();

							if (input == 2) {
								System.out.println("Torno al menu veicolo...");
								eseguiAggiunta = false;
							}

						} catch (Exception e) {
							System.out.println("Qualcosa è andato storto, riprova!" + e );
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
