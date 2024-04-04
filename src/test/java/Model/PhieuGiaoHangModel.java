package Model;

import java.sql.Date;

public class PhieuGiaoHangModel {
private String idPhieuGiao;
private Date ngayGiaoHang;
private String idNhaCC;
public PhieuGiaoHangModel() {
	super();
}
public PhieuGiaoHangModel(String idPhieuGiao, Date ngayGiaoHang, String idNhaCC) {
	super();
	this.idPhieuGiao = idPhieuGiao;
	this.ngayGiaoHang = ngayGiaoHang;
	this.idNhaCC = idNhaCC;
}
public String getIdPhieuGiao() {
	return idPhieuGiao;
}
public void setIdPhieuGiao(String idPhieuGiao) {
	this.idPhieuGiao = idPhieuGiao;
}
public Date getNgayGiaoHang() {
	return ngayGiaoHang;
}
public void setNgayGiaoHang(Date ngayGiaoHang) {
	this.ngayGiaoHang = ngayGiaoHang;
}
public String getIdNhaCC() {
	return idNhaCC;
}
public void setIdNhaCC(String idNhaCC) {
	this.idNhaCC = idNhaCC;
}

}
