package Model;

public class SanPhamModel {
private String idSanPham,tenSP;
private double giaBan;
private String hinh,LoaiSP;
public SanPhamModel() {

}
public SanPhamModel(String idSanPham, String tenSP, double giaBan, String hinh, String loaiSP) {
	
	this.idSanPham = idSanPham;
	this.tenSP = tenSP;
	this.giaBan = giaBan;
	this.hinh = hinh;
	LoaiSP = loaiSP;
}
public String getIdSanPham() {
	return idSanPham;
}
public void setIdSanPham(String idSanPham) {
	this.idSanPham = idSanPham;
}
public String getTenSP() {
	return tenSP;
}
public void setTenSP(String tenSP) {
	this.tenSP = tenSP;
}
public double getGiaBan() {
	return giaBan;
}
public void setGiaBan(double giaBan) {
	this.giaBan = giaBan;
}
public String getHinh() {
	return hinh;
}
public void setHinh(String hinh) {
	this.hinh = hinh;
}
public String getLoaiSP() {
	return LoaiSP;
}
public void setLoaiSP(String loaiSP) {
	LoaiSP = loaiSP;
}
@Override
public String toString() {
	return "SanPhamModel [idSanPham=" + idSanPham + ", tenSP=" + tenSP + ", giaBan=" + giaBan + ", hinh=" + hinh
			+ ", LoaiSP=" + LoaiSP + "]";
}




}
