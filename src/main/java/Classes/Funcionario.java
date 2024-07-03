package Classes;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String salarioFormatado = formatarSalario(this.salario);

        return String.format("Nome: %s\n" +
                        "Data de Nascimento: %s\n" +
                        "Salário: %s\n" +
                        "Função: %s\n",
                this.getNome(),
                this.getDataNascimento().format(dateFormatter),
                salarioFormatado,
                this.getFuncao());
    }

    public String formatarSalario(BigDecimal valor){
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.GERMAN);
        return df.format(valor);
    }

}
