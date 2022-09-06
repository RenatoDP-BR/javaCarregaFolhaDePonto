package carregaFolhaDePonto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;	

public class carregaFolhaDePontoPDF {

	public static void main(String[] args) {

	    String arquivoCSV = "C:\\Users\\renat\\Documents\\curso java nttdata\\Espelho de Ponto por Período (2).csv";
	    String linha = "";
	    try {
	    	BufferedReader bufferArquivo = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoCSV), "ISO-8859-1"));
	        while ((linha = bufferArquivo.readLine()) != null) {

	            System.out.println("Linha Lida:" + linha);

	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
    }
	
	
}