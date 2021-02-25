/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.dao.implement.SellerDaoJDBC;

/**
 *
 * @author Edgar
 */
public class DaoFactory {
    
    public static SellerDao createSellerDao(){
       return new SellerDaoJDBC(); 
    }
}
