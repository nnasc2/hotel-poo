package interfaces.servico;

import entidades.Hotel;
import enums.Classificacao;

import java.util.List;

public interface IHotelServico {
    void cadastrar(Hotel novoHotel);
    void cadastrar(long id, String nome, String descricao, Classificacao classificacao, String estado, String cidade,
                    String rua, String bairro, String complemento, String numero, int cnpj);
    List<Hotel> listar();
    void alterar(long idHotel, Hotel hotel);
    void deletar(long idHotel);

}
