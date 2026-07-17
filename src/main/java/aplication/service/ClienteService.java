package aplication.service;

import java.util.List;
import java.util.Optional;

import aplication.repository.ClienteRepository;
import domain.model.Cliente;
import domain.repository.JpaRepository;
import domain.service.JlaService;

public class ClienteService implements JlaService<Cliente,Integer> {
    private final JpaRepository<Cliente,Integer> clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }

    @Override
    public int save(Cliente cliente) {
        /**
         *     El metodo guardarCliente recive como parametro
         *         un Objeto de la clase Cliente
         *         Retorna un Objeto Cliente
         **/
        if (cliente == null) {
            return 0;
        }
        // Validamos que los campos obligatorios no sean nulos
        if (cliente.getNombre() == null || cliente.getApellido() == null || cliente.getDni() == null ||
                cliente.getCelular() == null || cliente.getDireccion() == null) {
            return 0; // O lanzar una excepción según tu diseño
        }

        return clienteRepository.saveAndFindId(cliente); // Retorna el cliente guardado
    }

    @Override
    public int update(Cliente cliente) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<Cliente> findAll() {
        /**
         * El metodo obtenerTodosLosClientes
         * @return List<Cliente>
         *
         */
        return clienteRepository.findAll(); // Retorna la lista de clientes
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        /**
         * El metodo obtenerClientePorId
         * @param Long
         * @return Cliente
         *
         */

        return clienteRepository.findById(id); // Retorna el cliente encontrado por ID
    }
}
