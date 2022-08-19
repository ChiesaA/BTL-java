package vanphongpham;

import java.util.Date;

public class SanPham {

    private Integer idSanPham;
    private String tenSanPham;
    private Integer gia;
    private Integer soLuong;
    private Date ngayNhap;
    private String trangThai;

    public SanPham() {
    }

    public Integer getIDSanPham() {
        return idSanPham;
    }

    public void setIDSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }
    
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
