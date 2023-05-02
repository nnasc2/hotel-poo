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

    public static ClassificacaoEnum intToClassificacaoEnum(int num){
        return switch (num){
            case 1 -> ClassificacaoEnum.UMA_ESTRELA;
            case 2 -> ClassificacaoEnum.DUAS_ESTRELAS;
            case 3 -> ClassificacaoEnum.TRES_ESTRELAS;
            case 4 -> ClassificacaoEnum.QUATRO_ESTRELAS;
            case 5 -> ClassificacaoEnum.CINCO_ESTRELAS;
            default -> ClassificacaoEnum.UMA_ESTRELA;
        };
    }

    public int getValue(){
        return this.value;
    }

}
