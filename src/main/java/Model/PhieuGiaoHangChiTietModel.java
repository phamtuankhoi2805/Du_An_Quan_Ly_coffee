package Model;

public class PhieuGiaoHangChiTietModel {
private String idNguyenLieu,idPhieuGiao;
private int soLuongNlGiao;
private double donGiaNL;
public PhieuGiaoHangChiTietModel() {

}
public PhieuGiaoHangChiTietModel(String idNguyenLieu, String idPhieuGiao, int soLuongNlGiao, double donGiaNL) {

	this.idNguyenLieu = idNguyenLieu;
	this.idPhieuGiao = idPhieuGiao;
	this.soLuongNlGiao = soLuongNlGiao;
	this.donGiaNL = donGiaNL;
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
public double getDonGiaNL() {
	return donGiaNL;
}
public void setDonGiaNL(double donGiaNL) {
	this.donGiaNL = donGiaNL;
}


}
