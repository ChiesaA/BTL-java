package DatabaseAccessObject_DAO;

import vanphongpham.ChiTietHoaDon;
import vanphongpham.HoaDon;
import vanphongpham.SanPham;
import ConnectionDB.*;
import java.util.*;
import java.sql.*;

public class ChiTietHoaDonDAO {
	
	public static List<ChiTietHoaDon> selectAll() {
        Connection connection = null;
        try {
        	connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("Select * From chitiethoadon ct, sanpham sp, hoadon hd"
                    + " Where ct.idhoadon = hd.idhoadon  And ct.idsanpham = sp.idsanpham");
            ResultSet rs = prst.executeQuery();
            List<ChiTietHoaDon> cthdList = new ArrayList<>();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon();
                ct.setIDHoaDon(rs.getInt("idhoadon"));
                ct.setIDSanPham(rs.getInt("idsanpham"));
                ct.setTenSanPham(rs.getString("tensp"));
                ct.setDonGia(rs.getInt("gia"));
                ct.setSoLuong(rs.getInt("soluong"));
                ct.setThanhTien(rs.getInt("thanhtien"));
                cthdList.add(ct);
            }
            return cthdList;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static boolean insert(ChiTietHoaDon cthd) {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("INSERT INTO chitiethoadon VALUES (?,?,?,?)");
            prst.setInt(1, cthd.getIDHoaDon());
            prst.setInt(2, cthd.getIDSanPham());
            prst.setInt(3, cthd.getSoLuong());
            prst.setInt(4, cthd.getThanhTien());
            return prst.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static boolean delete(ChiTietHoaDon cthd) {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("DELETE FROM chitiethoadon WHERE "
            		+ "idsanpham = ? "
            		+ "and idhoadon = ? "
            		+ "and soluong = ? ");
            prst.setInt(1, cthd.getIDSanPham());
            prst.setInt(2, cthd.getIDHoaDon());
            prst.setInt(3, cthd.getSoLuong());
            return prst.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } 
        return false;
    } 

    public static List<ChiTietHoaDon> getCTHD(int idhoadon) {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("Select * From chitiethoadon ct, sanpham sp"
                    + " Where idhoadon = ? And ct.idsanpham = sp.idsanpham");
            prst.setInt(1, idhoadon);
            ResultSet rs = prst.executeQuery();
            List<ChiTietHoaDon> listCTDH = new ArrayList<ChiTietHoaDon>();
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setIDHoaDon(rs.getInt("idhoadon"));
                cthd.setIDSanPham(rs.getInt("idsanpham"));
                cthd.setTenSanPham(rs.getString("tensp"));
                cthd.setDonGia(rs.getInt("gia"));
                cthd.setSoLuong(rs.getInt("soluong"));
                cthd.setThanhTien(rs.getInt("thanhtien"));
                listCTDH.add(cthd);
            }
            return listCTDH;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return null;
    }
    
    
    public static ChiTietHoaDon Tonggia(int idhoadon) {
    	Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            PreparedStatement prst = connection.prepareStatement("select sum(thanhtien) as sum "
            		+ "from chitiethoadon  where idhoadon = ?");
            prst.setInt(1,idhoadon);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon ct = new ChiTietHoaDon();;
                ct.setThanhTien(rs.getInt("sum"));
                return ct;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return null;
    }
}

