package Model;

import java.sql.Date;

public class PhieuGiaoHangModel {
private String idPhieuGiao;
<<<<<<< HEAD
private String ngayGiaoHang;
private double tongTienGiaoHang;
private String idNhaCC;
public PhieuGiaoHangModel() {

}
public PhieuGiaoHangModel(String idPhieuGiao, String ngayGiaoHang, double tongTienGiaoHang, String idNhaCC) {

	this.idPhieuGiao = idPhieuGiao;
	this.ngayGiaoHang = ngayGiaoHang;
	this.tongTienGiaoHang = tongTienGiaoHang;
=======
private Date ngayGiaoHang;
private String idNhaCC;
public PhieuGiaoHangModel() {
	super();
}
public PhieuGiaoHangModel(String idPhieuGiao, Date ngayGiaoHang, String idNhaCC) {
	super();
	this.idPhieuGiao = idPhieuGiao;
	this.ngayGiaoHang = ngayGiaoHang;
>>>>>>> 55c9e4b1c49fdc75a318376b52e3d0ff4ab89632
	this.idNhaCC = idNhaCC;
}
public String getIdPhieuGiao() {
	return idPhieuGiao;
}
public void setIdPhieuGiao(String idPhieuGiao) {
	this.idPhieuGiao = idPhieuGiao;
}
<<<<<<< HEAD
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
=======
public Date getNgayGiaoHang() {
	return ngayGiaoHang;
}
public void setNgayGiaoHang(Date ngayGiaoHang) {
	this.ngayGiaoHang = ngayGiaoHang;
}
>>>>>>> 55c9e4b1c49fdc75a318376b52e3d0ff4ab89632
public String getIdNhaCC() {
	return idNhaCC;
}
public void setIdNhaCC(String idNhaCC) {
	this.idNhaCC = idNhaCC;
}

<<<<<<< HEAD

=======
>>>>>>> 55c9e4b1c49fdc75a318376b52e3d0ff4ab89632
}
