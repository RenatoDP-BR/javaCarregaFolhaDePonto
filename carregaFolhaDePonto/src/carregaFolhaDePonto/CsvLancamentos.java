package carregaFolhaDePonto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CsvLancamentos {

    private LocalDate dataLançamento;
    private String diaDaSemana; 
    private String tipoDeDiaLançamento;
    private LocalTime entrada1Lançamento;
    private LocalTime saida1Lançamento;
    private LocalTime entrada2Lançamento;
    private LocalTime saida2Lançamento;
    private LocalTime entrada3Lançamento;
    private LocalTime saida3Lançamento;
    private LocalTime entrada4Lançamento;
    private LocalTime saida4Lançamento;
    private LocalTime qtdeHorasLançamento;
    private String ocorrJustLançamento;
    
}
