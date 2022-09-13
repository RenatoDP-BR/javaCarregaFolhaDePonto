package carregaFolhaDePonto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.IOException;	

import carregaFolhaDePonto.CsvLancamentos;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class carregaFolhaDePontoPDF {

	public static void main(String[] args) {

	    String arquivoCSV = "C:\\Users\\renat\\Documents\\curso java nttdata\\Espelho de Ponto por Período (2).csv";
	    String linha, 
	           nomeFuncionario = "";
        boolean novoCartao = true; 
        boolean jaObtiveMesLancamentos = false, 
    	        jaObtiveDadosFuncionario = false, 
    	        JaContabilizeiLancamentos = false,
    	        JaGraveiLancamentos = false;
        int cntLinhaCartao = 0, 
            mesCartaoLancamentos = 0,
            anoCartaoLancamentos = 0, 
            idFuncionario = 0, 
            indexFinal = 0, 
            indexInicial = 0;
        
	    	try (BufferedReader bufferArquivo = new BufferedReader(new InputStreamReader(new FileInputStream(arquivoCSV), "ISO-8859-1"))) {
				while ((linha = bufferArquivo.readLine()) != null) {
					
					cntLinhaCartao++; 
					
			        System.out.println("Linha " + cntLinhaCartao + " do Cartao de Ponto:" + linha);
                    if (!linha.contentEquals("Cartão de Ponto,,,,,,,,,,,")) {
                        if (jaObtiveMesLancamentos == false &
                           cntLinhaCartao == 2) {
                        	System.out.println("Mes do Cartao de Ponto:" + linha.substring(12, 14));
                        	System.out.println("Ano do Cartao de Ponto:" + linha.substring(15, 19));
                        	mesCartaoLancamentos = Integer.parseInt(linha.substring(12, 14));
                        	anoCartaoLancamentos = Integer.parseInt(linha.substring(15, 19));
                        	jaObtiveMesLancamentos = true;
                        	continue;
                        }
                        else {
                        	if (jaObtiveDadosFuncionario == false &
                                cntLinhaCartao == 6) {
            			        indexFinal = linha.indexOf("-");
                            	System.out.println("Id do Funcionario:" + linha.substring(0, indexFinal - 1));
                            	idFuncionario = Integer.parseInt(linha.substring(0, indexFinal - 1));
            			        indexInicial = linha.indexOf("-");
            			        indexFinal = linha.indexOf(",");
            			        nomeFuncionario = linha.substring(indexInicial+2, indexFinal);
            			        jaObtiveDadosFuncionario = true;
                            	continue;
                        	} 
                        	else {
                        		if (JaContabilizeiLancamentos == false &
                                    cntLinhaCartao >= 12) {
                        			for (int diaMesLancamento = 1; diaMesLancamento < ultimoDiaMesLancamento(mesCartaoLancamentos, anoCartaoLancamentos)+1; diaMesLancamento++) {
                        				  
                        				  contabilizaLancamentos(linha);
                        			}
                        			JaContabilizeiLancamentos = true;
                        		}
                        		else {
                        			if (JaContabilizeiLancamentos == true &
                        				JaGraveiLancamentos == false) {
//                        				gravarBancoDeDadosLancamentosFunc(CsvLancamento);
                        				JaGraveiLancamentos = true;
                        			}
                        		}
                        	}
                        }
                    } else {
                    	jaObtiveMesLancamentos = false;
                    	jaObtiveDadosFuncionario = false;
                    	JaContabilizeiLancamentos = false;
                    	JaGraveiLancamentos = false;
                    	cntLinhaCartao = 1; 
                    	continue; 
                    }                    	
                }
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				} 
	    
	
private static void contabilizaLancamentos(String dadosLancamentos) {

	//* o objetivo é transformar o dadosLancamentos (em formato csv) em CsvLancamento (tabulando ele em campos),
	// * para ser mais facilmente contabilizado */
	
	System.out.println(dadosLancamentos);
}

private static void gravarBancoDeDadosLancamentosFunc(Object CsvLancamento) {

	//* O objetivo é gravar no banco de dados de lancamentos o objeto recebido
	
	System.out.println("Teste de Gravacao em Banco de Dados");
}

private static Integer ultimoDiaMesLancamento(Integer mesCartao, Integer anoCartao) {
	
	//* o objetivo é pegar o ultimo dia do mes/ano enviado... pra isso vou procurar pra ver se já tem alguma função 
	// * que já me calcule isso, pois tem anos bissextos em que fevereiro tem 29 dias */
	
	return 31; 
	
}

}