package teste;

import util.ValidadorCPF;

public class TesteValidadorCPF {
    public static void main(String[] args) {
        String cpfInvalido = "12345678901";
        String cpfInvalidoConhecido = "55555555555";
        String cpfInvalidoConhecido2 = "00000000000";
        String cpfValido = "52998224725";
        // String cpfInvalido = "";
        // String cpfValido = "";
        String cpfValido1 = "76449334843";

        String mensagem = ValidadorCPF.eValido(cpfInvalidoConhecido) ? "CPF válido" : "CPF inválido";
        System.out.println(mensagem);
    }
}
