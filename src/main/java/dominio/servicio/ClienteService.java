package dominio.servicio;

import dominio.modelos.Cliente;

import java.util.List;

public interface ClienteService {
    int guardarCliente(Cliente cliente);

    Cliente obtenerClientePorId(Long id);

    List<Cliente> obtenerTodosLosClientes();

}
