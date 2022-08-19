package DatabaseAccessObject_DAO;

import vanphongpham.VaiTro;
import ConnectionDB.*;
import java.util.*;
import java.sql.*;

public class VaiTroDAO {

    public static List<VaiTro> selectAll() {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            Statement prst = connection.createStatement();
            ResultSet rs = prst.executeQuery("SELECT * FROM vaitro");
            List<VaiTro> vaiTroList = new ArrayList<>();
            while (rs.next()) {
                VaiTro vt = new VaiTro();
                vt.setIDVaiTro(rs.getInt("idvaitro"));
                vt.setTenVaiTro(rs.getString("tenvaitro"));
                vt.setMoTa(rs.getString("mota"));
                vaiTroList.add(vt);
            }
            return vaiTroList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static boolean insert(VaiTro vt) {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("INSERT INTO vaitro VALUES (?,?,?)");
            prst.setInt(1, vt.getIDVaiTro());
            prst.setString(2, vt.getTenVaiTro());
            prst.setString(3, vt.getMoTa());
            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean update(VaiTro vt) {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("UPDATE vaitro SET"
                    + " tenvaitro = ?,mota = ? WHERE idvaitro = ?");
            prst.setString(1, vt.getTenVaiTro());
            prst.setString(2, vt.getMoTa());
            prst.setInt(3, vt.getIDVaiTro());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean delete(VaiTro vt) {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("DELETE FROM vaitro WHERE idvaitro = ?");
            prst.setInt(1, vt.getIDVaiTro());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


}
