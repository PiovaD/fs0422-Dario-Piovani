package main;

import java.util.List;

import catalogoBibliotecario.ArchiveMaker;
import catalogoBibliotecario.dao.ArchiveDAO;
import catalogoBibliotecario.dao.UserDAO;
import catalogoBibliotecario.prestito.Loan;
import utils.LogColor;

public class Main {

	public static void main(String[] args) {
		
		//ArchiveMaker.maker();
				
		List<Loan> lLoan = ArchiveDAO.currentlyLoanItemsByLibCard("0010256851");
		
		printList(lLoan);
			
		
		System.err.println("THE END");

	}
	
	private static <E> void printList(List<E> list) {
		System.out.println();
		for(E elm : list) {
			System.out.println(LogColor.GREEN(elm + ""));
		}
		
		System.out.printf("%n--------------------------------------%n");
	}

}
