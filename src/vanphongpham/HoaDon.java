package vanphongpham;

import java.util.*;

public class HoaDon {

    private Integer idHoaDon;
    private Date ngayBan;
    private Integer idNhanVien;
    private String ten;
    private Integer tongGia;

	public Integer getIDHoaDon() {
        return idHoaDon;
    }

    public void setIDHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public Integer getIDNhanVien() {
        return idNhanVien;
    }

    public void setIDNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }
    
    public String getTen() {
        return ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public Integer getTongGia() {
        return tongGia;
    }

    public void setTongGia(Integer tongGia) {
        this.tongGia = tongGia;
    }
}
