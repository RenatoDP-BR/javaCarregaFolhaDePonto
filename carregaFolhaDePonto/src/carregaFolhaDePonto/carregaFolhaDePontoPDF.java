package carregaFolhaDePonto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;	

import CsvLancamentos; /* nao estou sabendo como puxar a classe CsvLancamentos */
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class carregaFolhaDePontoPDF {

	public static void main(String[] args) {

	    String arquivoCSV = "C:\\Users\\renat\\Documents\\curso java nttdata\\Espelho de Ponto por Período (2).csv";
	    String linha, 
	           nomeFuncionario = "";
        boolean novoCartao = true; 
        boolean jaObtiveMesLancamentos, 
    	        jaObtiveDadosFuncionario, 
    	        JaContabilizeiLancamentos;
        int cntLinhaCartao, 
            mesCartaoLancamentos,
            anoCartaoLancamentos, 
            idFuncionario = 0;
        
	    try {
	    	try (BufferedReader bufferArquivo = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoCSV), "ISO-8859-1"))) {
				while ((linha = bufferArquivo.readLine()) != null) {
					
					cntLinhaCartao++; 
					
			        int indexInicial = linha.indexOf("Cartão");
			        int indexFinal = linha.indexOf("Ponto");
			        System.out.println("Linha " + cntLinhaCartao + " do Cartao de Ponto:" + linha);
			        
                    if (linha.substring(indexInicial, indexFinal - 1) != "Cartão de Ponto") {
                        if (jaObtiveMesLancamentos = false &
                           cntLinhaCartao == 2) {
                        	System.out.println("Mes do Cartao de Ponto:" + linha.substring(9, 10));
                        	mesCartaoLancamentos = Integer.parseInt(linha.substring(9, 10));
                        	jaObtiveMesLancamentos = true;
                        	continue;
                        }
                        else {
                        	if (jaObtiveDadosFuncionario = false &
                                cntLinhaCartao == 6) {
            			        indexFinal = linha.indexOf("-");
                            	System.out.println("Id do Funcionario:" + linha.substring(0, indexFinal - 1));
                            	idFuncionario = Integer.parseInt(linha.substring(0, indexFinal - 1));
            			        indexInicial = linha.indexOf("-");
            			        indexFinal = linha.indexOf(",");
            			        nomeFuncionario = linha.substring(indexInicial, indexFinal);
            			        jaObtiveDadosFuncionario = true;
                            	continue;
                        	} 
                        	else {
                        		if (JaContabilizeiLancamentos = false &
                                    cntLinhaCartao >= 12) {
                        			for (int diaMesLancamento = 1; diaMesLancamento < ultimoDiaMesLancamento(mesCartaoLancamentos, anoCartaoLancamentos)+1; diaMesLancamento++) {
                        				  
                        				  contabilizaLancamentos(linha);
                        			}
                        			JaContabilizeiLancamentos = true;
                        		}
                        	}
                        }
                    } else {
                    	jaObtiveMesLancamentos = false;
                    	jaObtiveDadosFuncionario = false;
                    	JaContabilizeiLancamentos = false;
                    	cntLinhaCartao = 1; 
                    	continue; 
                    }
                    	
                    } /* fim de While */

				} /* fim do try do buffer */
	    	
			} /* fim do try inteiro */
	    

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
    }
	
private static void contabilizaLancamentos(String dadosLancamentos) {

	/* o objetivo é transformar o dadosLancamentos (em formato csv) em CsvLancamento (tabulando ele em campos),
	 * para ser mais facilmente contabilizado */
	
	System.out.println(dadosLancamentos);
}


private static Integer ultimoDiaMesLancamento(Integer mesCartao, Integer anoCartao) {
	
	/* o objetivo é pegar o ultimo dia do mes/ano enviado... pra isso vou procurar pra ver se já tem alguma função 
	 * que já me calcule isso, pois tem anos bissextos em que fevereiro tem 29 dias */
	
	return 31; 
	
}

}