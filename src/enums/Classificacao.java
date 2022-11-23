package enums;

import java.util.Optional;

public enum Classificacao {
    UMA_ESTRELA ("1 estrela"),
    DUAS_ESTRELAS ("2 estrelas"),
    TRES_ESTRELAS ("3 estrelas"),
    QUATRO_ESTRELAS ("4 estrelas"),
    CINCO_ESTRELAS ("4 estrelas");

    private String descricao;
    Classificacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}
