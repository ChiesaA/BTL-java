package DatabaseAccessObject_DAO;

import vanphongpham.*;
import ConnectionDB.*;
import java.util.*;
import java.sql.*;

public class HoaDonDAO {

    public static List<HoaDon> selectAll() {
        Connection connection = null;
        try {
        	connection = ConnectionDatabase.getConnection();
            Statement prst = connection.createStatement();
            ResultSet rs = prst.executeQuery("SELECT hd.*, nv.ten "
                    + " FROM hoadon hd, nhanvien nv Where "
                    + " hd.idnhanvien = nv.idnhanvien");
                   // + " AND hd.idhoadon = ct.idhoadon");
            List<HoaDon> hdList = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIDHoaDon(rs.getInt("idhoadon"));
                hd.setIDNhanVien(rs.getInt("idnhanvien"));
                hd.setTen(rs.getString("ten").trim());
                hd.setNgayBan(rs.getDate("ngayban"));
                hd.setTongGia(rs.getInt("tonggia"));
                hdList.add(hd);
            }
            return hdList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<HoaDon> search(HoaDon hoadon) {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            String sql = "SELECT hd.*, nv.Ten"
                    + " FROM hoadon hd, nhanvien nv Where "
                    + " hd.idnhanvien = nv.idnhanvien ";
            if (hoadon.getIDNhanVien() != null) {
                sql = sql + " AND nv.idnhanvien LIKE N'%" + hoadon.getIDNhanVien() + "%'";
            }
            if (hoadon.getIDHoaDon() != null) {
                sql = sql + " AND idhoadon = " + hoadon.getIDHoaDon() + " ";
            }
            if (hoadon.getNgayBan() != null) {
                sql = sql + " AND ngayban = '" + ConvertDate.convertDate(hoadon.getNgayBan()) + "' ";
            }
            Statement prst = connection.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<HoaDon> hdList = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIDHoaDon(rs.getInt("idhoadon"));
                hd.setIDNhanVien(rs.getInt("idnhanvien"));
                hd.setTen(rs.getString("ten").trim());
                hd.setNgayBan(rs.getDate("ngayban"));
                hd.setTongGia(rs.getInt("tonggia"));
                hdList.add(hd);
            }
            return hdList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static boolean insert(HoaDon hd) {
    	Connection connection = null;
        try {
        	connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("INSERT INTO hoadon VALUES (?,?,?,?)");
            prst.setInt(1, hd.getIDHoaDon());
            prst.setInt(2, hd.getIDNhanVien());
            prst.setDate(3, ConvertDate.convertDate(hd.getNgayBan()));
            prst.setInt(4, hd.getTongGia());
            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static boolean update(HoaDon hd) {
    	Connection connection = null; 
        try {
        	connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("UPDATE hoadon SET idnhanvien = ?, "
                    + " ngayban = ?, tonggia = ? WHERE idhoadon = ?");	           
            prst.setInt(1, hd.getIDNhanVien());
            prst.setDate(2, ConvertDate.convertDate(hd.getNgayBan()));
            prst.setInt(3, hd.getTongGia());
            prst.setInt(4, hd.getIDHoaDon());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } 
        return false;
    }
    
    public static boolean delete(HoaDon hd) {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("DELETE FROM hoadon WHERE idhoadon = ?");
            prst.setInt(1, hd.getIDHoaDon());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } 
        return false;
    }
    
    public static List<HoaDon> report(java.sql.Date from, java.sql.Date to) {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            String sql = "SELECT hd.*, nv.Ten"
                    + " FROM hoadon hd, nhanvien nv Where "
                    + " hd.idnhanvien = nv.idnhanvien ";
            if (from != null) {
                sql = sql + " AND hd.ngayban >= '" + ConvertDate.convertDate(from) + "'";
            }
            if (to != null) {
                sql = sql + " AND hd.ngayban <= N'" + ConvertDate.convertDate(to) + "'";
            }
            
            Statement prst = connection.createStatement();
            ResultSet rs = prst.executeQuery(sql);
            List<HoaDon> hdList = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIDHoaDon(rs.getInt("idhoadon"));
                hd.setIDNhanVien(rs.getInt("idnhanvien"));
                hd.setTen(rs.getString("ten").trim());
                hd.setNgayBan(rs.getDate("ngayban"));
                hd.setTongGia(rs.getInt("tonggia"));
                hdList.add(hd);
            }
            return hdList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static HoaDon getHoaDon(Integer idHoaDon) {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("select  * from "
            		+ "hoadon as hd,nhanvien as nv where idhoadon = ? and nv.idnhanvien = hd.idnhanvien ");
            prst.setInt(1,idHoaDon);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIDHoaDon(rs.getInt("idhoadon"));
                hd.setIDNhanVien(rs.getInt("idnhanvien"));
                hd.setTen(rs.getString("ten").trim());
                hd.setNgayBan(rs.getDate("ngayban"));
                hd.setTongGia(rs.getInt("tonggia"));
                return hd;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
