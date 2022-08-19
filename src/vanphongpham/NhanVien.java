package vanphongpham;
import java.util.*;

public class NhanVien {

    private Integer idNhanVien;
    private String ten;
    private String gioiTinh;
    private String sdt;
    private String diaChi;
    private Date ngayVaoLam;
    private Integer idVaiTro;
    private String tenVaiTro;
    
    public NhanVien() {
    }

    public NhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
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
    
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
    
    public Integer getIDVaiTro() {
        return idVaiTro;
    }

    public void setIDVaiTro(Integer idVaiTro) {
        this.idVaiTro = idVaiTro;
    }
    
    public String getTenVaiTro() {
        return tenVaiTro;
    }

    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }

}

