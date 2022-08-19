package carregaFolhaDePonto;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class carregaFolhaDePontoPDF {

	public static void main(String[] args) {
		
		File espelhoDePontoPDF = new File("C:\\Users\\renat\\Documents\\curso java nttdata\\Espelho de Ponto - Comp 08-22 - Ponto extraido em 16-08 - 08-23.PDF");
		
		try {
			if (!espelhoDePontoPDF.exists()) {
				System.out.println("Espelho de ponto não existe");
			}
            PDFParser parser = new PDFParser(new RandomAccessBufferedFileInputStream(espelhoDePontoPDF));
            parser.parse();
            COSDocument cosDoc = parser.getDocument();
            PDFTextStripper pdfStripper = new PDFTextStripper();
            PDDocument pdDoc = new PDDocument(cosDoc);
            for (int i = 1; i <= pdDoc.getNumberOfPages(); i++) {
                pdfStripper.setStartPage(i);
                pdfStripper.setEndPage(i);
                String parsedText = pdfStripper.getText(pdDoc);
                interpretaPaginaPDFLida(parsedText);
                System.out.println("Página " + i + ": " + parsedText);
            }
		}
		catch (IOException e) {
            e.printStackTrace();
        }
		finally {	
		}		
    }
	
	public static void interpretaPaginaPDFLida(String parsedText) {
		
	}
	
	
}