package Model;

import java.sql.Date;

public class DonHangModel {
private String idDonHang;
private Date ngayMua;
private String idNhanVien;
public DonHangModel() {

}
public DonHangModel(String idDonHang, Date ngayMua, String idNhanVien) {

	this.idDonHang = idDonHang;
	this.ngayMua = ngayMua;
	this.idNhanVien = idNhanVien;
}
public String getIdDonHang() {
	return idDonHang;
}
public void setIdDonHang(String idDonHang) {
	this.idDonHang = idDonHang;
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
