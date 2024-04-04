package Model;

public class SoLuongMuaModel {
private String idSanPham,idDonHang;
private int soLuongMua;
public SoLuongMuaModel() {

}
public SoLuongMuaModel(String idSanPham, String idDonHang, int soLuongMua) {

	this.idSanPham = idSanPham;
	this.idDonHang = idDonHang;
	this.soLuongMua = soLuongMua;
}
public String getIdSanPham() {
	return idSanPham;
}
public void setIdSanPham(String idSanPham) {
	this.idSanPham = idSanPham;
}
public String getIdDonHang() {
	return idDonHang;
}
public void setIdDonHang(String idDonHang) {
	this.idDonHang = idDonHang;
}
public int getSoLuongMua() {
	return soLuongMua;
}
public void setSoLuongMua(int soLuongMua) {
	this.soLuongMua = soLuongMua;
}

}
