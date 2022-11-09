package interfaces.servico;

import entidades.Hotel;
import enums.Estrelas;

import java.util.List;

public interface IHotelServico {
    void cadastrar (Hotel novoHotel);
    void cadastrar (long id, String nome, String descricao, Estrelas classEstrelas, String estado, String cidade,
                           String rua, String bairro, String complemento, String numero, int cnpj);
    List<Hotel> listar ();
    void deletar (long idHotel);

}
