package Service;

import Classes.Funcionario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class FuncionarioService {
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public static Map<String, Funcionario> insereFuncionariosConformeTabela() {
        Map<String, Funcionario> funcionariosMap = new LinkedHashMap<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File jsonFile = new File("src/main/resources/funcionarios.json");

            Funcionario[] funcionarioArray = mapper.readValue(jsonFile, Funcionario[].class);

            for (Funcionario funcionario : funcionarioArray) {
                funcionariosMap.put(funcionario.getNome(), funcionario);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo JSON: " + e.getMessage());
        }

        return funcionariosMap;
    }

    public static void aplicarAumentoSalario(Map<String, Funcionario> funcionarioMap) {
        for (Funcionario funcionario : funcionarioMap.values()) {
            BigDecimal salarioAtual = funcionario.getSalario();
            BigDecimal aumento = salarioAtual.multiply(BigDecimal.valueOf(0.1));
            BigDecimal salarioNovo = salarioAtual.add(aumento);
            funcionario.setSalario(salarioNovo);
            funcionarioMap.put(funcionario.getNome(), funcionario);
        }
    }

    public static void imprimirInformacoes(Map<String, Funcionario> funcionarioMap){
        for (Funcionario funcionario : funcionarioMap.values()) {
            System.out.println(funcionario.toString());
        }
    }

    public static Map<String, List<Funcionario>> agruparFuncionariosPorFuncao(Map<String, Funcionario> funcionarioMap) {
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        for (Funcionario funcionario : funcionarioMap.values()) {
            String funcao = funcionario.getFuncao();

            List<Funcionario> listaFuncionarios = funcionariosPorFuncao.getOrDefault(funcao, new ArrayList<>());

            listaFuncionarios.add(funcionario);

            funcionariosPorFuncao.put(funcao, listaFuncionarios);
        }

        return funcionariosPorFuncao;
    }

    public static void imprimirMapFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            String funcao = entry.getKey();
            List<Funcionario> funcionarios = entry.getValue();

            System.out.println("Função: " + funcao + " {");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario.toString());
            }
            System.out.println("}");
        }
    }

    public static void imprimirAniversariantesPorMes(Map<String, Funcionario> funcionarioMap, int mes) {
        System.out.println("Funcionários que fazem aniversário no mês " + mes + ":");
        for (Funcionario funcionario : funcionarioMap.values()) {
            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
            if (mesAniversario == mes) {
                System.out.println(funcionario.toString());
            }
        }
    }

    public static void imprimirFuncionarioMaisVelho(Map<String, Funcionario> funcionarioMap) {
        Funcionario funcionarioMaisVelho = null;
        int idadeMaisVelho = 0;

        for (Funcionario funcionario : funcionarioMap.values()) {
            LocalDate dataNascimento = funcionario.getDataNascimento();
            int idade = calcularIdade(dataNascimento);

            if (funcionarioMaisVelho == null || idade > idadeMaisVelho) {
                funcionarioMaisVelho = funcionario;
                idadeMaisVelho = idade;
            }
        }

        if (funcionarioMaisVelho != null) {
            System.out.println("Funcionário mais velho:");
            System.out.println("Nome: " + funcionarioMaisVelho.getNome());
            System.out.println("Idade: " + idadeMaisVelho);
        } else {
            System.out.println("Não há funcionários cadastrados.");
        }
    }

    private static int calcularIdade(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now();
        return Period.between(dataNascimento, hoje).getYears();
    }

    public static void imprimirFuncionariosOrdemAlfabetica(Map<String, Funcionario> funcionarioMap) {
        List<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarioMap.values());

        // Ordena a lista de funcionários pelo nome usando Collections.sort()
        Collections.sort(funcionariosOrdenados, (f1, f2) -> f1.getNome().compareTo(f2.getNome()));

        System.out.println("Funcionários em ordem alfabética:");
        for (Funcionario funcionario : funcionariosOrdenados) {
            System.out.println(funcionario);
        }
    }

    public static void imprimirTotalSalarios(Map<String, Funcionario> funcionarioMap) {
        BigDecimal totalSalarios = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarioMap.values()) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }

        System.out.println("Total dos salários dos funcionários: R$ " + totalSalarios);
    }

    public static void imprimirSalariosMinimos(Map<String, Funcionario> funcionarioMap) {
        for (Funcionario funcionario : funcionarioMap.values()) {
            BigDecimal salario = funcionario.getSalario();
            BigDecimal salariosMinimos = salario.divide(SALARIO_MINIMO, 2, RoundingMode.DOWN);

            System.out.println(funcionario.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        }
    }


}
