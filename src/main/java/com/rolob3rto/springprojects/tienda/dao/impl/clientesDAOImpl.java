package com.rolob3rto.springprojects.tienda.dao.impl;

import java.sql.Types;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.rolob3rto.springprojects.tienda.dao.ClientesDAO;
import com.rolob3rto.springprojects.tienda.model.Cliente;

@Repository
public class clientesDAOImpl extends JdbcDaoSupport implements ClientesDAO {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
        // si no me va el aplication probar aqui
    }

    @Override
    public List<Cliente> findAll() {

        String query = "select * from Clientes";

        List<Cliente> clientes = getJdbcTemplate().query(query, new BeanPropertyRowMapper(Cliente.class));

        return clientes;
    }

    @Override
    public Cliente findCliente(int codigo) {

        String query = "select * from Clientes where codigo = ?";
        Object params[] = { codigo };
        int types[] = { Types.INTEGER };

        // Cliente cliente = getJdbcTemplate().query( query, new
        // BeanPropertyRowMapper(Cliente.class));
        Cliente cliente = (Cliente) getJdbcTemplate().queryForObject(query, params, types,
                new BeanPropertyRowMapper(Cliente.class));

        return cliente;
    }

    @Override
    public void insert(Cliente cliente) {
        String query = "insert into Clientes (nombre, apellidos, email, numero, direccion, vip)" +
                "values (?,?,?,?,?,?)";

        Object[] params = {
                cliente.getNombre(),
                cliente.getApellidos(),
                cliente.getEmail(),
                cliente.getNumero(),
                cliente.getDireccion(),
                cliente.isVip()
        };

        int[] types = {
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.BOOLEAN
        };

        int update = getJdbcTemplate().update(query, params, types);

    }

    @Override
    public void update(Cliente cliente) {

        String query = "update Clientes set nombre = ?, apellidos = ?, email = ?, numero = ?, direccion = ?, vip = ? where codigo = ?";

        Object[] params = {
                cliente.getNombre(),
                cliente.getApellidos(),
                cliente.getEmail(),
                cliente.getNumero(),
                cliente.getDireccion(),
                cliente.isVip(),
                cliente.getCodigo()
        };

        int[] types = {
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.BOOLEAN,
                Types.INTEGER
        };

        int update = getJdbcTemplate().update(query, params, types);
    }

}
