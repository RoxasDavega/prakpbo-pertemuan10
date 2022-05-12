/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Orenji
 */
public class ControllerContact {
    ModelContact modelContact;
    ViewContact viewContact;

    public ControllerContact(ModelContact modelContact, ViewContact viewContact) {
        this.modelContact = modelContact;
        this.viewContact = viewContact;
        
        if (modelContact.getBanyakData()!=0) {
            String dataKontak[][] = modelContact.readContact();
            viewContact.tabel.setModel((new JTable(dataKontak, viewContact.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        viewContact.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = viewContact.getNama();
                String NoHp = viewContact.getNoHp();
                String Umur = viewContact.getUmur();
                String Email = viewContact.getEmail();
                modelContact.insertData(Nama, NoHp, Umur, Email);
         
                String dataKontak[][] = modelContact.readContact();
                viewContact.tabel.setModel((new JTable(dataKontak, viewContact.namaKolom)).getModel());
            }
        });
        
        viewContact.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = viewContact.getNama();
                String NoHp = viewContact.getNoHp();
                String Umur = viewContact.getUmur();
                String Email = viewContact.getEmail();
                modelContact.updateContact(Nama, NoHp, Umur, Email);
                
                String dataKontak[][] = modelContact.readContact();
                viewContact.tabel.setModel((new JTable(dataKontak, viewContact.namaKolom)).getModel());
            }
        });
        
        viewContact.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Nama = viewContact.getCariNama();
                
                if (Nama.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                }
                else {
                    String dataKontak[][] = modelContact.cariContact(Nama);
                    viewContact.tabel.setModel((new JTable(dataKontak, viewContact.namaKolom)).getModel());
                }
                
            }
        });
        
        viewContact.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String dataKontak[][] = modelContact.readContact();
                viewContact.tabel.setModel((new JTable(dataKontak, viewContact.namaKolom)).getModel());
            }
        });
        
        viewContact.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewContact.tabel.getSelectedRow();
                int kolom = viewContact.tabel.getSelectedColumn(); // ga kepake sekarang

                String dataterpilih = viewContact.tabel.getValueAt(baris, 1).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus NoHp " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelContact.deleteContact(dataterpilih);
                    String dataKontak[][] = modelContact.readContact();
                    viewContact.tabel.setModel(new JTable(dataKontak, viewContact.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        }
        );
    }
}
