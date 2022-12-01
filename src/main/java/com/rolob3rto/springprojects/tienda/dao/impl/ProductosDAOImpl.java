package com.rolob3rto.springprojects.tienda.dao.impl;

import java.sql.Types;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.rolob3rto.springprojects.tienda.dao.ProductosDAO;
import com.rolob3rto.springprojects.tienda.model.Producto;

@Repository
public class ProductosDAOImpl extends JdbcDaoSupport implements ProductosDAO {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
        // si no me va el aplication probar aqui
    }

    @Override
    public List<Producto> findAll() {

        String query = "select * from Productos";

        List<Producto> productos = getJdbcTemplate().query(query, new BeanPropertyRowMapper(Producto.class));

        return productos;
    }

    @Override
    public Producto findProducto(int codigo) {

        String query = "select * from Productos where codigo = ?";
        Object params[] = { codigo };
        int types[] = { Types.INTEGER };

        // Producto producto = getJdbcTemplate().query( query, new
        // BeanPropertyRowMapper(Producto.class));
        Producto producto = (Producto) getJdbcTemplate().queryForObject(query, params, types,
                new BeanPropertyRowMapper(Producto.class));

        return producto;
    }

    @Override
    public void insert(Producto producto) {
        String query = "insert into Productos (nombre, descripcion, precio, img)" +
                "values (?,?,?,?)";

        Object[] params = {
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getImg()
        };

        int[] types = {
                Types.VARCHAR,
                Types.VARCHAR,
                Types.FLOAT,
                Types.BLOB
        };

        int update = getJdbcTemplate().update(query, params, types);

    }

    @Override
    public void update(Producto producto) {

        String query = "update Productos set nombre = ?, descripcion = ?, precio = ? where codigo = ?";

        Object[] params = {
            producto.getNombre(),
            producto.getDescripcion(),
            producto.getPrecio(),
            producto.getCodigo()
            
    };

    int[] types = {
            Types.VARCHAR,
            Types.VARCHAR,
            Types.FLOAT,
            Types.INTEGER            
    };

        int update = getJdbcTemplate().update(query, params, types);
    }

    @Override
    public void delete(int codigo) {
        
        String query = "delete from Productos where codigo = ?";

        Object[] params = {            
            codigo
    };

        int[] types = {           
            Types.INTEGER
    };

    int delete = getJdbcTemplate().update(query, params, types);
        
    }
    @Override
    public void updateImg(Producto producto) {
        
        String query = "update Productos set img = ? where codigo = ?";

        Object[] params = {
            producto.getImg(),
            producto.getCodigo()
    };

    int[] types = {
            Types.BLOB,
            Types.INTEGER
    };

        int update = getJdbcTemplate().update(query, params, types);
    }

}
