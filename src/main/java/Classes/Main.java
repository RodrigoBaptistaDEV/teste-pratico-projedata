package Classes;

import java.util.List;
import java.util.Map;
import static Service.FuncionarioService.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Funcionario> funcionarioMap = insereFuncionariosConformeTabela();

        funcionarioMap.remove("João");

        imprimirInformacoes(funcionarioMap);

        aplicarAumentoSalario(funcionarioMap);

        imprimirInformacoes(funcionarioMap);

        Map<String, List<Funcionario>> funcionariosPorFuncao = agruparFuncionariosPorFuncao(funcionarioMap);

        imprimirMapFuncionariosPorFuncao(funcionariosPorFuncao);

        imprimirAniversariantesPorMes(funcionarioMap, 10);
        imprimirAniversariantesPorMes(funcionarioMap, 12);

        imprimirFuncionarioMaisVelho(funcionarioMap);

        imprimirFuncionariosOrdemAlfabetica(funcionarioMap);

        imprimirTotalSalarios(funcionarioMap);

        imprimirSalariosMinimos(funcionarioMap);
    }
}
