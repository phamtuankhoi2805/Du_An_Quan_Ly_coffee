package Model;

public class TableNhapModel {
private String idNguyenLieu;
private String tenNguyenLieu;
private int soLuongTon;
private String TenNhaCC;
private String SDT;
public TableNhapModel() {

}
public TableNhapModel(String idNguyenLieu, String tenNguyenLieu, int soLuongTon, String tenNhaCC, String sDT) {

	this.idNguyenLieu = idNguyenLieu;
	this.tenNguyenLieu = tenNguyenLieu;
	this.soLuongTon = soLuongTon;
	TenNhaCC = tenNhaCC;
	SDT = sDT;
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
public String getTenNhaCC() {
	return TenNhaCC;
}
public void setTenNhaCC(String tenNhaCC) {
	TenNhaCC = tenNhaCC;
}
public String getSDT() {
	return SDT;
}
public void setSDT(String sDT) {
	SDT = sDT;
}



}