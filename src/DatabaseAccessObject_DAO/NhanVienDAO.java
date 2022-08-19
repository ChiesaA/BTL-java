package DatabaseAccessObject_DAO;

import vanphongpham.NhanVien;
import ConnectionDB.*;
import java.util.*;
import java.sql.*;

public class NhanVienDAO {
	 public static List<NhanVien> selectAll() {
	        Connection connection = null;
	        try {
	        	connection = ConnectionDatabase.getConnection();
	            Statement prst = connection.createStatement();
	            ResultSet rs = prst.executeQuery("SELECT * FROM nhanvien nv, vaitro vt Where "
	                    + "nv.idvaitro = vt.idvaitro");
	            List<NhanVien> nvList = new ArrayList<>();
	            while (rs.next()) {
	                NhanVien nv = new NhanVien();
	                nv.setIDNhanVien(rs.getInt("idnhanvien"));
	                nv.setTen(rs.getString("ten").trim());
	                nv.setSdt(rs.getString("sdt").trim());
	                nv.setGioiTinh(rs.getString("gioitinh").trim());               
	                nv.setDiaChi(rs.getString("diachi").trim());
	                nv.setNgayVaoLam(rs.getDate("ngayvaolam"));
	               	nv.setIDVaiTro(rs.getInt("idvaitro"));
	                nv.setTenVaiTro(rs.getString("tenvaitro").trim());
	                nvList.add(nv);
	            }
	            return nvList;
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	 }


	    public static boolean insert(NhanVien nv) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("INSERT INTO nhanvien VALUES (?,?,?,?,?,?,?)");
	            prst.setInt(1, nv.getIDNhanVien());
	            prst.setString(2, nv.getTen());
	            prst.setString(3, nv.getSdt().trim());
	            prst.setString(4, nv.getGioiTinh().trim());
	            prst.setString(5, nv.getDiaChi().trim());
	            prst.setDate(6, ConvertDate.convertDate(nv.getNgayVaoLam()));
	            prst.setInt(7, nv.getIDVaiTro());
	            return prst.execute();

	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return false;
	    }

	    public static boolean update(NhanVien nv) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("UPDATE nhanvien SET ten = ?, sdt = ?, "
	                    +" gioitinh = ?,diachi = ?, ngayvaolam = ?, idvaitro = ? WHERE idnhanvien = ?");  
	            prst.setString(1, nv.getTen());
	            prst.setString(2, nv.getSdt().trim());
	            prst.setString(3, nv.getGioiTinh().trim());
	            prst.setString(4, nv.getDiaChi().trim());
	            prst.setDate(5, ConvertDate.convertDate(nv.getNgayVaoLam()));
	            prst.setInt(6, nv.getIDVaiTro());
	            prst.setInt(7, nv.getIDNhanVien());

	            return prst.execute();
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	        return false;
	    }

	    public static boolean delete(NhanVien nv) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("DELETE FROM nhanvien WHERE idnhanvien = ?");
	            prst.setInt(1, nv.getIDNhanVien());
	            return prst.execute();
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return false;
	    }

	    public static List<NhanVien> search(NhanVien nhanVien) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            String sql = "SELECT * FROM nhanvien nv, vaitro vt WHERE nv.idvaitro = vt.idvaitro ";
	            if (!nhanVien.getTen().isEmpty()) {
	                sql = sql + "AND nv.ten LIKE N'%" + nhanVien.getTen() + "%'";
	            }
	            if (nhanVien.getIDNhanVien() != null) {
	                sql = sql + " AND nv.idnhanvien = " + nhanVien.getIDNhanVien() + "";
	            }
	            if (nhanVien.getGioiTinh() != null) {
	                sql = sql + " AND nv.gioitinh LIKE N'" + nhanVien.getGioiTinh() + "%'";
	            }
	            if (nhanVien.getIDVaiTro() != null) {
	                sql = sql + " AND nv.idvaitro = " + nhanVien.getIDVaiTro() + "";
	            }
	            Statement prst = connection.createStatement();
	            ResultSet rs = prst.executeQuery(sql);
	            List<NhanVien> nvList = new ArrayList<>();
	            while (rs.next()) {
	                NhanVien nv = new NhanVien();
	                nv.setIDNhanVien(rs.getInt("idnhanvien"));
	                nv.setTen(rs.getString("ten").trim());
	                nv.setSdt(rs.getString("sdt").trim());
	                nv.setGioiTinh(rs.getString("gioitinh").trim());
	                nv.setDiaChi(rs.getString("diachi").trim());
	                nv.setNgayVaoLam(rs.getDate("ngayvaolam"));
	               	nv.setIDVaiTro(rs.getInt("idvaitro"));
	                nv.setTenVaiTro(rs.getString("tenvaitro").trim());
	                nvList.add(nv);
	            }
	            return nvList;
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	        return null;
	    }

	    public static NhanVien getNVByID(int idNV) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("Select * From nhanvien nv, vaitro vt Where "
	                    + "nv.idvaitro = vt.idvaitro And nv.idnhanvien Like ?");
	            prst.setInt(1,idNV);
	            ResultSet rs = prst.executeQuery();
	            while (rs.next()) {
	                NhanVien nv = new NhanVien();
	                nv.setIDNhanVien(rs.getInt("idnhanvien"));
	                nv.setTen(rs.getString("ten").trim());
	                nv.setGioiTinh(rs.getString("gioitinh").trim());
	                nv.setSdt(rs.getString("sdt").trim());
	                nv.setDiaChi(rs.getString("diachi").trim());
	                nv.setNgayVaoLam(rs.getDate("ngayvaolam"));
	               	nv.setIDVaiTro(rs.getInt("idvaitro"));
	                nv.setTenVaiTro(rs.getString("tenvaitro").trim());
	                return nv;
	            }
	        } catch (ClassNotFoundException | SQLException ex) {
	            ex.getMessage();
	        }
	        return null;
	    }

}
