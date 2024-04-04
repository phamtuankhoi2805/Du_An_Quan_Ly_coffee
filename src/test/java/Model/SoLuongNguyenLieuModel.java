package Model;

public class SoLuongNguyenLieuModel {
private String idSanPham;
private String idNguyenLieu;
private int soLuongNguyenLieu;

public SoLuongNguyenLieuModel() {

}

public SoLuongNguyenLieuModel(String idSanPham, String idNguyenLieu, int soLuongNguyenLieu) {

	this.idSanPham = idSanPham;
	this.idNguyenLieu = idNguyenLieu;
	this.soLuongNguyenLieu = soLuongNguyenLieu;
}

public String getIdSanPham() {
	return idSanPham;
}

public void setIdSanPham(String idSanPham) {
	this.idSanPham = idSanPham;
}

public String getIdNguyenLieu() {
	return idNguyenLieu;
}

public void setIdNguyenLieu(String idNguyenLieu) {
	this.idNguyenLieu = idNguyenLieu;
}

public int getSoLuongNguyenLieu() {
	return soLuongNguyenLieu;
}

public void setSoLuongNguyenLieu(int soLuongNguyenLieu) {
	this.soLuongNguyenLieu = soLuongNguyenLieu;
}

}
