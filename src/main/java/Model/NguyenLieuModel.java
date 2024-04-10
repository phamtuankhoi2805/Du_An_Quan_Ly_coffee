package Model;

public class NguyenLieuModel {
private String idNguyenLieu,tenNguyenLieu;
private int soLuongTon;
private String DonViTinh;
public NguyenLieuModel() {

}
public NguyenLieuModel(String idNguyenLieu, String tenNguyenLieu, int soLuongTon, String donViTinh) {
	this.idNguyenLieu = idNguyenLieu;
	this.tenNguyenLieu = tenNguyenLieu;
	this.soLuongTon = soLuongTon;
	DonViTinh = donViTinh;
}
public String getIdNguyenLieu() {
	return idNguyenLieu;
}
public void setIdNguyenLieu(String idNguyenLieu) {
	this.idNguyenLieu = idNguyenLieu;
}
public String getTenNguyenLieu() {
	return tenNguyenLieu;
}
public void setTenNguyenLieu(String tenNguyenLieu) {
	this.tenNguyenLieu = tenNguyenLieu;
}
public int getSoLuongTon() {
	return soLuongTon;
}
public void setSoLuongTon(int soLuongTon) {
	this.soLuongTon = soLuongTon;
}
public String getDonViTinh() {
	return DonViTinh;
}
public void setDonViTinh(String donViTinh) {
	DonViTinh = donViTinh;
}




}
