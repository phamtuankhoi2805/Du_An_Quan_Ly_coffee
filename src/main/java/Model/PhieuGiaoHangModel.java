package Model;

import java.sql.Date;

public class PhieuGiaoHangModel {
private String idPhieuGiao;
private String ngayGiaoHang;
private double tongTienGiaoHang;
private String idNhaCC;
public PhieuGiaoHangModel() {

}
public PhieuGiaoHangModel(String idPhieuGiao, String ngayGiaoHang, double tongTienGiaoHang, String idNhaCC) {

	this.idPhieuGiao = idPhieuGiao;
	this.ngayGiaoHang = ngayGiaoHang;
	this.tongTienGiaoHang = tongTienGiaoHang;
	this.idNhaCC = idNhaCC;
}
public String getIdPhieuGiao() {
	return idPhieuGiao;
}
public void setIdPhieuGiao(String idPhieuGiao) {
	this.idPhieuGiao = idPhieuGiao;
}
public String getNgayGiaoHang() {
	return ngayGiaoHang;
}
public void setNgayGiaoHang(String ngayGiaoHang) {
	this.ngayGiaoHang = ngayGiaoHang;
}
public double getTongTienGiaoHang() {
	return tongTienGiaoHang;
}
public void setTongTienGiaoHang(double tongTienGiaoHang) {
	this.tongTienGiaoHang = tongTienGiaoHang;
}
public String getIdNhaCC() {
	return idNhaCC;
}
public void setIdNhaCC(String idNhaCC) {
	this.idNhaCC = idNhaCC;
}


}
