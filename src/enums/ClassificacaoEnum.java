package enums;

public enum ClassificacaoEnum {
    UMA_ESTRELA ("1 estrela", 1),
    DUAS_ESTRELAS ("2 estrelas", 2),
    TRES_ESTRELAS ("3 estrelas", 3),
    QUATRO_ESTRELAS ("4 estrelas", 4),
    CINCO_ESTRELAS ("5 estrelas", 5);

    private String descricao;
    private int value;
    ClassificacaoEnum(String descricao, int value) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getValue(){
        return this.value;
    }

}
