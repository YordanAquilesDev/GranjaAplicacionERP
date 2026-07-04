package aplicacion.repositoryimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dominio.modelos.Animal;
import dominio.repository.JpaRepository;
import presentacion.app.ConexionPostgresSQL;
/*
public class AnimalRepositoryImpl implements CrudGenerico<Animal, Integer> {
    Connection conexion;

    public AnimalRepositoryImpl() {
        this.conexion = ConexionPostgresSQL.getConexion();

    }

    @Override
    public int save(Animal animal) {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        int filasAfectadas = 0;
        try {
            String sql = """
                    INSERT INTO animal (especie,raza) VALUES
                                            (?,?)
                   ;
                    """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
            preparar = conexionPostgres.prepareStatement(sql);
            preparar.setString(1, animal.getEspecie());
            preparar.setString(2, animal.getRaza());
            filasAfectadas = preparar.executeUpdate();
            return filasAfectadas;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

        }finally {
            try{
                if(preparar!=null){preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public int update(Animal animal) {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        try{
            String sql = """
                    UPDATE animal
                    SET especie = ?,raza = ?
                    WHERE id = ?;
            """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
            preparar= conexionPostgres.prepareStatement(sql);

            return preparar.executeUpdate();
        } catch (SQLException e) {
            return -1;
        }finally {
            try{
                if(preparar!=null){preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public List<Animal> findAll(String filter) {
        return List.of();
    }

    @Override
    public int delete(Integer id) {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        try{
            String sql = """
                  DELETE FROM animal WHERE id = ?;
                  
            """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
            preparar= conexionPostgres.prepareStatement(sql);

            return preparar.executeUpdate();
        } catch (SQLException e) {
            return -1;
        }finally {
            try{
                if(preparar!=null){preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Animal findById(Integer id) {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        try {
            String sql = """
                            SELECT * FROM Animal WHERE id_animal=? ;
                    """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
            preparar = conexionPostgres.prepareStatement(sql);
            preparar.setInt(1, id);
            ResultSet resultado = preparar.executeQuery();
            resultado.next();
            return new Animal(
                    resultado.getInt("id_animal"),
                    resultado.getString("especie"),
                    resultado.getString("raza"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(preparar!=null){preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }


    public List<Animal> traerAnimalesPorConsumo() {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        ResultSet resultado=null;
        List<Animal> animales = new ArrayList<>();
        try {
            String sql = """
                            SELECT a.id_animal,a.especie,a.raza
                             FROM animal a
                             JOIN lote_animal l ON a.id_animal=l.id_animal
                             JOIN consumo_lote c ON l.id_lote=c.id_lote
                             ORDER BY c.cantidad DESC
                             LIMIT 3;
                    """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
           preparar = conexionPostgres.prepareStatement(sql);
           resultado = preparar.executeQuery();
            while (resultado.next()) {
                animales.add(new Animal(resultado.getInt("id_animal"),
                        resultado.getString("especie"),
                        resultado.getString("raza")));
            }
            return animales;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                if(preparar!=null) {preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}
                if(resultado!=null){resultado.close();}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public List<Animal> findAll() {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        ResultSet resultado=null;
        List<Animal> animales = new ArrayList<>();
        try {
            String sql = """
                            SELECT * FROM animal;
                    """;
             preparar = conexion.prepareStatement(sql);
            resultado = preparar.executeQuery();
            while (resultado.next()) {
                animales.add(new Animal(resultado.getInt("id_animal"),
                        resultado.getString("especie"),
                        resultado.getString("raza")));
            }
            return animales;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                if(preparar!=null) {preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}
                if(resultado!=null){resultado.close();}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
*/
public class AnimalRepository implements JpaRepository<Animal, Integer> {
    Connection conexion;

    public AnimalRepository () {
        this.conexion = ConexionPostgresSQL.getConexion();

    }


    public int save(Animal animal) {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        int filasAfectadas = 0;
        try {
            String sql = """
                    INSERT INTO animal (especie,raza) VALUES
                                            (?,?)
                   ;
                    """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
            preparar = conexionPostgres.prepareStatement(sql);
            preparar.setString(1, animal.getEspecie());
            preparar.setString(2, animal.getRaza());
            filasAfectadas = preparar.executeUpdate();
            return filasAfectadas;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

        }finally {
            try{
                if(preparar!=null){preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public int saveAndFindId(Animal objeto) {
        return 0;
    }

    @Override
    public int update(Animal animal) {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        try{
            String sql = """
                    UPDATE animal
                    SET especie = ?,raza = ?
                    WHERE id = ?;
            """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
            preparar= conexionPostgres.prepareStatement(sql);

            return preparar.executeUpdate();
        } catch (SQLException e) {
            return -1;
        }finally {
            try{
                if(preparar!=null){preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public int delete(Integer id) {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        try{
            String sql = """
                  DELETE FROM animal WHERE id = ?;
                  
            """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
            preparar= conexionPostgres.prepareStatement(sql);

            return preparar.executeUpdate();
        } catch (SQLException e) {
            return -1;
        }finally {
            try{
                if(preparar!=null){preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Optional<Animal> findById(Integer id) {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        try {
            String sql = """
                            SELECT * FROM Animal WHERE id_animal=? ;
                    """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
            preparar = conexionPostgres.prepareStatement(sql);
            preparar.setInt(1, id);
            ResultSet resultado = preparar.executeQuery();
            resultado.next();
            return Optional.of(new Animal(
                    resultado.getInt("id_animal"),
                    resultado.getString("especie"),
                    resultado.getString("raza")));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(preparar!=null){preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }


    public List<Animal> traerAnimalesPorConsumo() {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        ResultSet resultado=null;
        List<Animal> animales = new ArrayList<>();
        try {
            String sql = """
                            SELECT a.id_animal,a.especie,a.raza
                             FROM animal a
                             JOIN lote_animal l ON a.id_animal=l.id_animal
                             JOIN consumo_lote c ON l.id_lote=c.id_lote
                             ORDER BY c.cantidad DESC
                             LIMIT 3;
                    """;
            conexionPostgres = ConexionPostgresSQL.getConexion();
            preparar = conexionPostgres.prepareStatement(sql);
            resultado = preparar.executeQuery();
            while (resultado.next()) {
                animales.add(new Animal(resultado.getInt("id_animal"),
                        resultado.getString("especie"),
                        resultado.getString("raza")));
            }
            return animales;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                if(preparar!=null) {preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}
                if(resultado!=null){resultado.close();}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public List<Animal> findAll() {
        Connection conexionPostgres= null;
        PreparedStatement preparar=null;
        ResultSet resultado=null;
        List<Animal> animales = new ArrayList<>();
        try {
            String sql = """
                            SELECT * FROM animal;
                    """;
            preparar = conexion.prepareStatement(sql);
            resultado = preparar.executeQuery();
            while (resultado.next()) {
                animales.add(new Animal(resultado.getInt("id_animal"),
                        resultado.getString("especie"),
                        resultado.getString("raza")));
            }
            return animales;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try{
                if(preparar!=null) {preparar.close();}
                if(conexionPostgres!=null){conexionPostgres.close();}
                if(resultado!=null){resultado.close();}
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
