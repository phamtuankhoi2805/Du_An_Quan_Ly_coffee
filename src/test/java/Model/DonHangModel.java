package Model;

import java.sql.Date;

public class DonHangModel {
private String idDonHang,tenDonHang;
private Date ngayMua;
private String idNhanVien;
public DonHangModel() {

}
public DonHangModel(String idDonHang, String tenDonHang, Date ngayMua, String idNhanVien) {

	this.idDonHang = idDonHang;
	this.tenDonHang = tenDonHang;
	this.ngayMua = ngayMua;
	this.idNhanVien = idNhanVien;
}
public String getIdDonHang() {
	return idDonHang;
}
public void setIdDonHang(String idDonHang) {
	this.idDonHang = idDonHang;
}
public String getTenDonHang() {
	return tenDonHang;
}
public void setTenDonHang(String tenDonHang) {
	this.tenDonHang = tenDonHang;
}
public Date getNgayMua() {
	return ngayMua;
}
public void setNgayMua(Date ngayMua) {
	this.ngayMua = ngayMua;
}
public String getIdNhanVien() {
	return idNhanVien;
}
public void setIdNhanVien(String idNhanVien) {
	this.idNhanVien = idNhanVien;
}

}
