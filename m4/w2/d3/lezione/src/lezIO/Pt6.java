package lezIO;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Pt6 {
	
	public static void main(String[] args) {
		String f1Name = "docs/f1.txt";
		File f1 = new File(f1Name);
		String encoding = "UTF-8";
		
		if(f1.exists()) {
			System.out.println("Il file " + f1Name + " esiste");
			System.out.println(f1.getName());
			System.out.println(f1.getPath());
			System.out.println(f1.length());
			System.out.println(f1.lastModified());
			
			try {
				FileUtils.writeStringToFile(f1, "Hello world!", encoding, true);
			} catch (IOException e) {
			System.out.println("errore scrittura");
			}
		}else {
			System.out.println("non esiste");
		}
		
		try {
			String f1Content = FileUtils.readFileToString(f1, encoding);
			
			System.out.println(f1Content);
			
		} catch (IOException e) {
			System.out.println("errore lettura");
		} 
	}

}
