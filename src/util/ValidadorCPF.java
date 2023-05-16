package util;

import java.sql.SQLOutput;

public class ValidadorCPF {

    public static boolean eValido(String cpf){

        if (cpf.length() != 11 || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666")
                || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999")
                || cpf.equals("00000000000")){
            return false;
        }

        int[] vetorCPF = new int[11];

        for (int i = 0; i < 11; i++){
            vetorCPF[i] = Character.getNumericValue(cpf.charAt(i));
        }

        int validador1 = vetorCPF[9];
        int validador2 = vetorCPF[10];

        int r1 = (vetorCPF[0]) + (vetorCPF[1] * 2) + (vetorCPF[2] * 3) + (vetorCPF[3] * 4)
                + (vetorCPF[4] * 5) + (vetorCPF[5] * 6) + (vetorCPF[6] * 7) + (vetorCPF[7] * 8)
                + (vetorCPF[8] * 9);

        r1 %= 11;

        if (r1 == 10){ r1 = 0; }

        int r2 = (vetorCPF[1]) + (vetorCPF[2] * 2) + (vetorCPF[3] * 3) + (vetorCPF[4] * 4)
                + (vetorCPF[5] * 5) + (vetorCPF[6] * 6) + (vetorCPF[7] * 7) + (vetorCPF[8] * 8)
                + (vetorCPF[9] * 9);

        r2 %= 11;

        if (r2 == 10){ r2 = 0; }

        if (r1 == validador1){
            if (r2 == validador2){
                return true;
            }
        }
        return false;
    }
}
