package dominio.repository;

import dominio.modelos.Cliente;

import java.util.List;

public interface ClienteRepository {
    int guardar(Cliente cliente);
    Cliente traerPorId(Integer id);
    void borrarCliente(Cliente cliente);
    int updateCliente(Cliente cliente);
    List<Cliente> listarClientes();

}
