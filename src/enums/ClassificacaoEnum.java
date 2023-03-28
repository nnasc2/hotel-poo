package enums;

public enum ClassificacaoEnum {
    UMA_ESTRELA ("1 estrela"),
    DUAS_ESTRELAS ("2 estrelas"),
    TRES_ESTRELAS ("3 estrelas"),
    QUATRO_ESTRELAS ("4 estrelas"),
    CINCO_ESTRELAS ("5 estrelas");

    private String descricao;
    ClassificacaoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}
