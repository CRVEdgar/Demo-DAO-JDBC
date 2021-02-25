/*
CLASSE QUE REALIZA AS OPERAÇÕES CRUD NO BANCO
 */
package model.dao.implement;

import db.DB;
import db.DbException;
import java.util.List;
import model.dao.SellerDao;
import model.entities.Seller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import model.entities.Departament;

/**
 *
 * @author Edgar
 */
public class SellerDaoJDBC implements SellerDao{
    
    private Connection conn;
    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Seller obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        
        String comando = "SELECT seller.*,department.Name as DepName"
                        + " FROM seller INNER JOIN department"
                        + " ON seller.DepartmentId = department.Id"
                        + " WHERE seller.Id = ?";
        try{
            st = conn.prepareStatement(comando);
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){ //testa se rs retornou algum resultado da consulta
                Departament dep = instantiateDepartment(rs); //instancia a partir da funcao descrita no final deste classe
                
                Seller vendedor = instantiateSeller(rs, dep); //instancia a partir da funcao descrita no final deste classe
                
                return vendedor;
            }
            return null;
        }catch(SQLException e){
            throw new DbException(e.getMessage());         
        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        
    }

    @Override
    public List<Seller> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Departament instantiateDepartment(ResultSet rs) throws SQLException {
        Departament dep = new Departament();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        
        return dep;  
    }

    private Seller instantiateSeller(ResultSet rs, Departament dep) throws SQLException {
        
        Seller vendedor  = new Seller();
        vendedor.setName(rs.getString("Name"));
        vendedor.setId(rs.getInt("Id"));
        vendedor.setEmail(rs.getString("Email"));
        vendedor.setDepartment(dep);
        vendedor.setBirthdate(rs.getDate("BirthDate"));
        vendedor.setBasesalary(rs.getDouble("BaseSalary"));
        
        return vendedor;
    }
    
}
