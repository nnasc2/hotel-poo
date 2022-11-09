package servicos;

import entidades.Hotel;
import enums.Estrelas;
import interfaces.servico.IHotelServico;
import repositorios.HotelRepositorio;

import java.util.ArrayList;
import java.util.List;

public class HotelServico implements IHotelServico {

    @Override
    public void cadastrar (Hotel novoHotel) {
        try {
            HotelRepositorio.getInstance().salvar(novoHotel);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void cadastrar (long id, String nome, String descricao, Estrelas classEstrelas, String estado, String cidade,
                           String rua, String bairro, String complemento, String numero, int cnpj) {
        try {
            Hotel novoHotel = new Hotel();
            novoHotel.setId(id);
            novoHotel.setNome(nome);
            novoHotel.setDescricao(descricao);
            novoHotel.setClassEstrelas(classEstrelas);
            novoHotel.setEstado(estado);
            novoHotel.setRua(rua);
            novoHotel.setBairro(bairro);
            novoHotel.setComplemento(complemento);
            novoHotel.setNumero(numero);
            novoHotel.setCnpj(cnpj);

            HotelRepositorio.getInstance().salvar(novoHotel);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Hotel> listar () {
        return HotelRepositorio.getInstance().retornar();
    }

    @Override
    public void deletar (long idHotel) {
        HotelRepositorio.getInstance().deletar(idHotel);
    }

    public List<String> listarCidades () {
        List<String> cidades = new ArrayList<>();
        return cidades;
    }

    public List<Hotel> listarPorCidade (String cidade) {
        return HotelRepositorio.getInstance().retornar();
    }
}
