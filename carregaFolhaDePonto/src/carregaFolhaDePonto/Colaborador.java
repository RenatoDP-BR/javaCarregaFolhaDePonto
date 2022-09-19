package carregaFolhaDePonto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Colaborador {

    private String codigo;
    private String nome;
    private LocalDate dataAdmissao;
    private String cargo;
    private String pisPasep;
    private String ctps;
    private List<CsvLancamentos> lancamentos;
	
}
