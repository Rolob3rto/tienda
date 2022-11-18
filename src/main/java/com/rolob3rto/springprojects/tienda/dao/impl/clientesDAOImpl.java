package com.rolob3rto.springprojects.tienda.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.rolob3rto.springprojects.tienda.dao.ClientesDAO;
import com.rolob3rto.springprojects.tienda.model.Cliente;

@Repository
public class clientesDAOImpl extends JdbcDaoSupport implements ClientesDAO{

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
        //si no me va el aplication probar aqui
    }

    @Override
    public List<Cliente> findAll() {
        
        String query = "select * from Clientes";

        List<Cliente> clientes = getJdbcTemplate().query( query, new BeanPropertyRowMapper(Cliente.class));


        return clientes;
    }
    
    
}
