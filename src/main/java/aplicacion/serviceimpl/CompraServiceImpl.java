package aplicacion.serviceimpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import aplicacion.repositoryimpl.CompraRepository;
import dominio.modelos.Compra;
import dominio.modelos.DetalleCompra;
import dominio.servicio.JlaService;

public class CompraServiceImpl implements JlaService<Compra,Integer> {
    private final CompraRepository compraRepository;

    public CompraServiceImpl() {
        this.compraRepository = new CompraRepository();
    }

    @Override
    public int save(Compra compra) {
        return 0;
    }

    @Override
    public int update(Compra compra) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<Compra> findAll() {
        return List.of();
    }

    @Override
    public Optional<Compra> findById(Integer integer) {
        return Optional.empty();
    }
}
