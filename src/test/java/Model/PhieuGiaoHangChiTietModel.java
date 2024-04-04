package Model;

public class PhieuGiaoHangChiTietModel {
private String idNguyenLieu,idPhieuGiao;
private int soLuongNlGiao;
public PhieuGiaoHangChiTietModel() {

}
public PhieuGiaoHangChiTietModel(String idNguyenLieu, String idPhieuGiao, int soLuongNlGiao) {

	this.idNguyenLieu = idNguyenLieu;
	this.idPhieuGiao = idPhieuGiao;
	this.soLuongNlGiao = soLuongNlGiao;
}
public String getIdNguyenLieu() {
	return idNguyenLieu;
}
public void setIdNguyenLieu(String idNguyenLieu) {
	this.idNguyenLieu = idNguyenLieu;
}
public String getIdPhieuGiao() {
	return idPhieuGiao;
}
public void setIdPhieuGiao(String idPhieuGiao) {
	this.idPhieuGiao = idPhieuGiao;
}
public int getSoLuongNlGiao() {
	return soLuongNlGiao;
}
public void setSoLuongNlGiao(int soLuongNlGiao) {
	this.soLuongNlGiao = soLuongNlGiao;
}

}
