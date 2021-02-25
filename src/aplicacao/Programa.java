/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

/**
 *
 * @author Edgar
 */
public class Programa {
    public static void main(String[] args) {
 
        //(INJECAO DE DEPENDENCIA SEM EXPLICITAR A IMPLEMENTACAO)
        SellerDao sellerDao = DaoFactory.createSellerDao(); //desta forma o programa conhece apenas a interface
        // SellerDao -> DaoFactory -> createSellerDao -> SellerDaoJDBC -> retorna uma dos metodos escolhidos/"chamado" -> Seller (entidade) -> "chamar" um dos metodos
        
        Seller vendedor = sellerDao.findById(3);
        System.out.println(vendedor);
    }
}
