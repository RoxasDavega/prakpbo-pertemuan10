/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Orenji
 */
public class ModelContact {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbcontact?useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;

    public ModelContact() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String[][] readContact(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][4]; //baris, kolom nya ada 4
            
            String query = "Select * from contact"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("Nama"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("NoHp");                
                data[jmlData][2] = resultSet.getString("Umur");
                data[jmlData][3] = resultSet.getString("Email");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public String[][] cariContact(String nama){
        try{
            int jmlData = 0;
            
            String query = "Select * from contact WHERE Nama LIKE '%" + nama + "%'"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            
            String data[][] = new String[jmlData][4]; //baris, kolom nya ada 3
            
            
            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
            else {
                jmlData = 0;
                query = "Select * from contact WHERE Nama LIKE '%" + nama + "%'"; 
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    data[jmlData][0] = resultSet.getString("Nama"); //harus sesuai nama kolom di mysql
                    data[jmlData][1] = resultSet.getString("NoHp");                
                    data[jmlData][2] = resultSet.getString("Umur");
                    data[jmlData][3] = resultSet.getString("Email");
                    jmlData++;
                }
                
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void insertData(String Nama, String NoHp, String Umur, String Email){
        int jmlData=0;
        try {
           String query = "Select * from contact WHERE NoHp=" + NoHp; 
           System.out.println(Nama + " " + NoHp + " " + Umur + " " + Email);
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO contact VALUES('"+Nama+"','"+NoHp+"','"+Umur+"','"+Email+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateContact(String Nama, String NoHp, String Umur, String Email){
        int jmlData=0;
         try {
           String query = "Select * from contact WHERE NoHp=" + NoHp; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE contact SET Nama='" + Nama + "', Umur='" + Umur + "', Email='" + Email + "' WHERE NoHp=" + NoHp;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from contact";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteContact (String NoHp) {
        try{
            String query = "DELETE FROM contact WHERE NoHp = '"+NoHp+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
