package com.rolob3rto.springprojects.tienda.dao.mappers;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.mysql.cj.protocol.Resultset;
import com.rolob3rto.springprojects.tienda.model.Cliente;

public class ClienteMapper implements RowMapper<Cliente>{

    @Override
    @Nullable
    public Cliente mapRow(Resultset rs, int rowNum) throws SQLException{

        Cliente cliente = new Cliente();
    }
}
