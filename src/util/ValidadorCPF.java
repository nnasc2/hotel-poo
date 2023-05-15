package util;

public class ValidadorCPF {

    public static boolean eValido(String cpf){
        if (cpf.length() != 11 || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666")
                || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999")){
            return false;
        }
        int r1 = (cpf.charAt(0) * 10) + (cpf.charAt(1) * 9) + (cpf.charAt(2) * 8) + (cpf.charAt(3) * 7) + (cpf.charAt(4) * 6) + (cpf.charAt(5) * 5) + (cpf.charAt(6) * 4) + (cpf.charAt(7) * 3) + (cpf.charAt(8) * 2);
        if (r1 == cpf.charAt(10) * 10 % 11){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String cpf = "12345678901";
    }
}
