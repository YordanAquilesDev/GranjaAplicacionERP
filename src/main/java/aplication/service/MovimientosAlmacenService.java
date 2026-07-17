package aplication.service;

import domain.model.MovimientoAlmacen;
import domain.service.JlaService;

import java.util.List;
import java.util.Optional;

public class MovimientosAlmacenService implements JlaService<MovimientoAlmacen,Integer> {

    @Override
    public int save(MovimientoAlmacen movimientoAlmacen) {
        return 0;
    }

    @Override
    public int update(MovimientoAlmacen movimientoAlmacen) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public List<MovimientoAlmacen> findAll() {
        return List.of();
    }

    @Override
    public Optional<MovimientoAlmacen> findById(Integer integer) {
        return Optional.empty();
    }
}
