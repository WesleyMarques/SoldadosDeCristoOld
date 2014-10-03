/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Wesley
 */
public class QueryData {
    
    private ConnectionMySql conn;
    private Statement s;

    public QueryData(ConnectionMySql conn) {
        this.conn = conn;
    }
    
    public ResultSet queryD(String query) throws SQLException{
        try {
            s = conn.getConn().createStatement();
            return s.executeQuery(query); 
        } catch (Exception e) {
        }finally{
            conn.getConn().close();
            s.close();
        }
        return null;               
    }   
    
}
