package enums;

public enum PagamentoEnum {
    Avista("A vista", 1), Debito("Debito", 2), Credito("Credito", 3);
    private String descricao;
    private int index;

    PagamentoEnum(String descricao, int index) {
        this.descricao = descricao;
        this.index = index;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getIndex() {
        return this.index;
    }

    public static PagamentoEnum getEnum(String value) {
        if (value == null)
            throw new IllegalArgumentException();
        for (PagamentoEnum v : values())
            if (value.equalsIgnoreCase(v.getDescricao()))
                return v;
        throw new IllegalArgumentException();
    }

    public static PagamentoEnum intToPagamentoEnum(int index){
        return switch(index){
            case 1 -> PagamentoEnum.Avista;
            case 2 -> PagamentoEnum.Debito;
            case 3 -> PagamentoEnum.Credito;
            default -> null;
        };
    }
}
