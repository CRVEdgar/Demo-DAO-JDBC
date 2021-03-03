/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.util.ArrayList;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Departament;

/**
 *
 * @author Edgar
 */
public class ProgramaDepto {
    public static void main(String[] args) {
        Departament depto;
        DepartmentDao depDao = DaoFactory.createDepartmentDao();
        
        System.out.println("===========TESTE INSERT===========");
        //depDao.insert(new Departament(null, "STA"));
        System.out.println("Inserido com sucesso");
        
        
        System.out.println("===========TESTE UPDATE===========");
        //depDao.update(new Departament(8, "EPM"));
        System.out.println("Atualizado com sucesso");
        
        
        System.out.println("===========TESTE DELETE===========");
        //depDao.deleteById(10);
        System.out.println("Apagado com sucesso");
        
        
        System.out.println("===========TESTE BUSCA PELO ID DO VENDEDOR===========");
        depto = depDao.findByIdSeller(7);
        System.out.println("Busca realizada com sucesso || DEPARTAMENTO: " + depto);
        
        
        System.out.println("===========TESTE BUSCANDO TODOS OS DEPARTAMENTOS===========");
        List<Departament> deptLista = new ArrayList<>();
        deptLista = depDao.findAll();
        for( Departament depAll:deptLista ){
            System.out.println(depAll);
        }
        
    }
}
