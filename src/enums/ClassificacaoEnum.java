package enums;

public enum ClassificacaoEnum {
    UMA_ESTRELA (1, "1 estrela"),
    DUAS_ESTRELAS (2, "2 estrelas"),
    TRES_ESTRELAS (3, "3 estrelas"),
    QUATRO_ESTRELAS (4, "4 estrelas"),
    CINCO_ESTRELAS (5, "5 estrelas");

    private String descricao;
    private int index;
    ClassificacaoEnum(int index, String descricao) {
        this.descricao = descricao;
        this.index = index;
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

    public int getIndex(){
        return this.index;
    }
}
