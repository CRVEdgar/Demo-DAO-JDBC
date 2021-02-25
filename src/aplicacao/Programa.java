/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import model.entities.Departament;

/**
 *
 * @author Edgar
 */
public class Programa {
    public static void main(String[] args) {
        Departament depto = new Departament(1, "Livros");
        System.out.println(depto);
    }
}
