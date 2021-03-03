/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        SimpleDateFormat formatacao = new SimpleDateFormat("yyyy-MM-dd");
 
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
        
        System.out.println("======= TESTANDO BUSCA TODOS OS REGISTROS ======");
        List<Seller> listaAll = sellerDao.findAll();
        
        for(Seller venAll: listaAll){
            System.out.println(venAll);
        }
        
        System.out.println("======= TESTANDO INSERCAO DE NOVOS REGISTROS ======");
        try {
            Seller novoVendedor = new Seller(1, "Vitoria", "vitoria@gmail.com", formatacao.parse("1975-02-16"), 4000.00, deptoSearch);
            sellerDao.insert(novoVendedor);
            System.out.println("NOVO VENDEDOR INSERIDO || ID: " + novoVendedor.getId());
        } catch (ParseException ex) {
            System.out.println("ERRO NA DATA: " + ex.getMessage());
            //Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("======= TESTANDO UPDATE DE REGISTROS ======");
        vendedor = sellerDao.findById(1); // procurando no banco o vendedor do ID informado no parametro
        vendedor.setName("Lucas Piton");
        sellerDao.update(vendedor);
        System.out.println("Atualizacao concluida");
    }
}
