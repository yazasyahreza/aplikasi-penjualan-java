/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prjposyaza;

import java.sql.*;

/**
 *
 * @author HP
 */
public class Database {
    
    Connection con;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/pos_yaza_xiirpl1";
    private final String user = "root";
    private final String pwd = "";
    public Statement stm;
  
    /** Create a new instance of database **/
    
//    Method 1 (Koneksi Database)
    public void koneksi(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
            stm = con.createStatement();
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException e) {
            System.out.println("Error:\nKoneksi Data Gagal\n"+e.getMessage());
         }catch (SQLException e){
            System.out.println("Error:\nKoneksi Data Gagal\n"+e.getMessage());
        }
    }
    
//    Method 2 (Ambil data / cek data) (Select)
    public ResultSet ambilData(String SQL){
        try {
            Statement st=con.createStatement();
            return st.executeQuery(SQL);
        } catch (Exception e) {
            System.out.println("Error:\nPengecekan data gagal diakses");
            return null;
        }
    }
    
//    Method 3 Aksi(Insert,Update,Delete)
    public void aksi(String SQL){
        try {
            Statement st=con.createStatement();
            st.executeUpdate(SQL);
        } catch (Exception e) {
            System.out.println("Error:\nAksi gagal diakses");
        }
    }
    
}


