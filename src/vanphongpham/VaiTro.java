package vanphongpham;

public class VaiTro {

    private Integer idVaiTro;
    private String tenVaiTro;
    private String moTa;

 public VaiTro() {
    }

    public VaiTro(String tenVaiTro, String moTa) {
        this.tenVaiTro = tenVaiTro;
        this.moTa = moTa;
    }

    public VaiTro(Integer idVaiTro) {
        this.idVaiTro = idVaiTro;
    }

    public VaiTro(Integer idVaiTro, String tenVaiTro, String moTa) {
        this.idVaiTro = idVaiTro;
        this.tenVaiTro = tenVaiTro;
        this.moTa = moTa;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
