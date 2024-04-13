package Model;

public class TableNhapModel {
private String idNguyenLieu;
private String tenNguyenLieu;
private int soLuongTon;
<<<<<<< HEAD
=======
private int soLuongNhap;
>>>>>>> 55c9e4b1c49fdc75a318376b52e3d0ff4ab89632
private String TenNhaCC;
private String SDT;
public TableNhapModel() {

}
<<<<<<< HEAD
public TableNhapModel(String idNguyenLieu, String tenNguyenLieu, int soLuongTon, String tenNhaCC, String sDT) {
=======
public TableNhapModel(String idNguyenLieu, String tenNguyenLieu, int soLuongTon, int soLuongNhap, String tenNhaCC,
		String sDT) {
>>>>>>> 55c9e4b1c49fdc75a318376b52e3d0ff4ab89632

	this.idNguyenLieu = idNguyenLieu;
	this.tenNguyenLieu = tenNguyenLieu;
	this.soLuongTon = soLuongTon;
<<<<<<< HEAD
=======
	this.soLuongNhap = soLuongNhap;
>>>>>>> 55c9e4b1c49fdc75a318376b52e3d0ff4ab89632
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
<<<<<<< HEAD
=======
public int getSoLuongNhap() {
	return soLuongNhap;
}
public void setSoLuongNhap(int soLuongNhap) {
	this.soLuongNhap = soLuongNhap;
}
>>>>>>> 55c9e4b1c49fdc75a318376b52e3d0ff4ab89632
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

<<<<<<< HEAD


=======
>>>>>>> 55c9e4b1c49fdc75a318376b52e3d0ff4ab89632
}