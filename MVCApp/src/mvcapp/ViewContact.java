/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcapp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Orenji
 */
public class ViewContact extends JFrame{
    JLabel lNama = new JLabel("Nama");
    JLabel lNoHp = new JLabel("No Hp");
    JLabel lUmur = new JLabel("Umur");
    JLabel lEmail = new JLabel("E-mail");
    JLabel lCari = new JLabel("Cari Nama");
    
    JTextField tfNama = new JTextField();
    JTextField tfNoHp = new JTextField();
    JTextField tfUmur = new JTextField();
    JTextField tfEmail = new JTextField();
    JTextField tfCari = new JTextField();
    
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnCari = new JButton("Cari");
    JButton btnReset = new JButton("Refresh");
    
    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nama", "No Hp", "Usia", "E-mail"};

    public ViewContact() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Kontak");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900,400);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lNama);
        lNama.setBounds(510, 20, 90, 20);
        add(tfNama);
        tfNama.setBounds(510, 40, 120, 20);
        
        add(lNoHp);
        lNoHp.setBounds(510, 60, 90, 20);
        add(tfNoHp);
        tfNoHp.setBounds(510, 80, 120, 20);
        
        add(lUmur);
        lUmur.setBounds(510, 100, 90, 20);
        add(tfUmur);
        tfUmur.setBounds(510, 120, 120, 20);
        
        add(lEmail);
        lEmail.setBounds(510, 140, 90, 20);
        add(tfEmail);
        tfEmail.setBounds(510, 160, 120, 20);
        
        add(btnTambah);
        btnTambah.setBounds(510, 190, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(510, 220, 90, 20);
        
        add(lCari);
        lCari.setBounds(710, 20, 90, 20);
        
        add(tfCari);
        tfCari.setBounds(710, 40, 90, 20);
        
        add(btnCari);
        btnCari.setBounds(710, 70, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(710, 100, 90, 20);
    }
    
    public String getNama(){
        return tfNama.getText();
    }
    
    public String getNoHp(){
        return tfNoHp.getText();
    }
    
    public String getUmur(){
        return tfUmur.getText();
    }
    
    public String getEmail(){
        return tfEmail.getText();
    }
    
    public String getCariNama(){
        return tfCari.getText();
    }
}
