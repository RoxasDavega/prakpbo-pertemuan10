/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcapp;

/**
 *
 * @author Orenji
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         /*
            Langkah 1, buat main
            Langkah 2, buat view
            Langkah 3, buat method untuk mengambil data textfield di view
            Langkah 4, import library mysql
            Langkah 5, tambahkan atribut dan variabel di model
            Langkah 6, buat koneksi di constructor model
            Langkah 7, buat method utk CRUD
            Langkah 8, Buat controller dan action listener
            Langkah 9, buat semua objek MVC di Main
        */
         ViewContact vc = new ViewContact();
         ModelContact mc = new ModelContact();
         ControllerContact cc = new ControllerContact(mc, vc);
    }
    
}
