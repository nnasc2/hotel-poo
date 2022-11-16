package enums;

public enum PagamentoEnum {
    Avista("A vista"),Debito("debito"), Credito("Credito");
    private String descricao;

    PagamentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }

    public static PagamentoEnum getEnum(String value) {
        if (value == null)
            throw new IllegalArgumentException();
        for (PagamentoEnum v : values())
            if (value.equalsIgnoreCase(v.getDescricao()))
                return v;
        throw new IllegalArgumentException();
    }
}
