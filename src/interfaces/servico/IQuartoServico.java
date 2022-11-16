package interfaces.servico;

import entidades.Quarto;

import java.util.List;

public interface IQuartoServico {
    void cadastrar(Quarto quarto);
    List<Quarto> listar();
    void alterar(long idQuarto, Quarto quarto);
    void deletar(long idQuarto);
}
