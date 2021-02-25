/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.util.List;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Departament;
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
        System.out.println("======= TESTANDO BUSCA POR ID ======");
        Seller vendedor = sellerDao.findById(3);
        System.out.println(vendedor);
        
        System.out.println("======= TESTANDO BUSCA POR ID DO DEPARTAMENTO ======");
        Departament deptoSearch =  new Departament(2, null);
        List<Seller> lista = sellerDao.findByDepartment(deptoSearch);
        
        for(Seller ven: lista){
            System.out.println(ven);
        }
    }
}
