package DatabaseAccessObject_DAO;


import vanphongpham.SanPham;
import ConnectionDB.*;
import java.util.*;
import java.sql.*;

public class SanPhamDAO {
	 public static List<SanPham> selectAll() {
		 Connection connection = null;
	        try {
	        	connection = ConnectionDatabase.getConnection();
	            Statement prst = connection.createStatement();
	            ResultSet rs = prst.executeQuery("SELECT * FROM sanpham");
	            List<SanPham> sanPhamList = new ArrayList<>();
	            while (rs.next()) {
	                SanPham sp = new SanPham();
	                sp.setIDSanPham(rs.getInt("idsanpham"));
	                sp.setTenSanPham(rs.getString("tensp"));
	                sp.setGia(rs.getInt("gia"));
	                sp.setSoLuong(rs.getInt("soluong"));
	                sp.setNgayNhap(rs.getDate("ngaynhap"));
	                sp.setTrangThai(rs.getString("trangthai"));
	                sanPhamList.add(sp);
	            }
	            return sanPhamList;
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }
	 

	    public static boolean insert(SanPham sp) {
	    	Connection connection = null;
	        try {
	        	connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("INSERT INTO sanpham VALUES (?,?,?,?,?,?)");
	            prst.setInt(1, sp.getIDSanPham());
	            prst.setString(2, sp.getTenSanPham());
	            prst.setInt(3, sp.getGia());
	            prst.setInt(4, sp.getSoLuong());
	            prst.setDate(5, ConvertDate.convertDate(sp.getNgayNhap()));
	            prst.setString(6, sp.getTrangThai());
	            return prst.execute();

	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return false;
	    }

	    public static boolean update(SanPham sp) {
	    	Connection connection = null;
	        try {
	        	connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("UPDATE sanpham SET tensp = ?, "
	                    + " gia = ?, soluong = ?, ngaynhap = ?, trangthai = ? WHERE idsanpham = ?");	           
	            prst.setString(1, sp.getTenSanPham());
	            prst.setInt(2, sp.getGia());
	            prst.setInt(3, sp.getSoLuong());
	            prst.setDate(4, ConvertDate.convertDate(sp.getNgayNhap()));
	            prst.setString(5, sp.getTrangThai());
	            prst.setInt(6, sp.getIDSanPham());
	            return prst.execute();
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	        return false;
	    }

	    public static boolean delete(SanPham sp) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("DELETE FROM sanpham WHERE idsanpham = ?");
	            prst.setInt(1, sp.getIDSanPham());
	            return prst.execute();
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	        return false;
	    }

	    public static List<SanPham> search(SanPham sanpham) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            String sql = "SELECT * FROM sanpham sp Where idsanpham";
	            if (sanpham.getIDSanPham() != null) {
	                sql = sql + " AND idsanpham = " + sanpham.getIDSanPham() + "";
	            }
	            if (!sanpham.getTenSanPham().isEmpty()) {
	                sql = sql + " AND sp.tensp LIKE N'%" + sanpham.getTenSanPham() + "%'";
	            }
	            if (sanpham.getNgayNhap() != null) {
	                sql = sql + " AND sp.ngaynhap = '" + ConvertDate.convertDate(sanpham.getNgayNhap()) + "'";
	            }
	            if (!sanpham.getTrangThai().isEmpty()) {
	                sql = sql + " AND sp.trangthai LIKE N'%" + sanpham.getTrangThai() + "%'";
	            }
	            Statement prst = connection.createStatement();
	            ResultSet rs = prst.executeQuery(sql);
	            List<SanPham> spList = new ArrayList<>();
	            while (rs.next()) {
	                SanPham sp = new SanPham();
	                sp.setIDSanPham(rs.getInt("idsanpham"));
	                sp.setTenSanPham(rs.getString("tensp"));
	                sp.setGia(rs.getInt("gia"));
	                sp.setSoLuong(rs.getInt("soluong"));
	                sp.setNgayNhap(rs.getDate("ngaynhap"));
	                sp.setTrangThai(rs.getString("trangthai"));
	                spList.add(sp);
	            }
	            return spList;
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	        return null;
	    }
	    
	    public static SanPham getSanPhamByID(int idSanPham) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("select  * from "
	            		+ "sanpham as sp where idsanpham = ?");
	            prst.setInt(1,idSanPham);
	            ResultSet rs = prst.executeQuery();
	            while (rs.next()) {
	                SanPham sp = new SanPham();
	                sp.setIDSanPham(rs.getInt("idsanpham"));
	                sp.setTenSanPham(rs.getString("tensp"));
	                sp.setGia(rs.getInt("gia"));
	                sp.setSoLuong(rs.getInt("soluong"));
	                sp.setNgayNhap(rs.getDate("ngaynhap"));
	                sp.setTrangThai(rs.getString("trangthai"));

	                return sp;
	            }
	        } catch (ClassNotFoundException | SQLException ex) {
	            ex.getMessage();
	        }
	        return null;
	    }

  

}
