package Model;

import java.sql.Date;

public class HoaDonModel {
private String IDHoaDon;
private double thanhTien;
private Date thoiGianMua;
private String IDKhuyenMai;
public HoaDonModel() {

}
public HoaDonModel(String iDHoaDon, double thanhTien, Date thoiGianMua, String iDKhuyenMai) {
	
	IDHoaDon = iDHoaDon;
	this.thanhTien = thanhTien;
	this.thoiGianMua = thoiGianMua;
	IDKhuyenMai = iDKhuyenMai;
}
public String getIDHoaDon() {
	return IDHoaDon;
}
public void setIDHoaDon(String iDHoaDon) {
	IDHoaDon = iDHoaDon;
}
public double getThanhTien() {
	return thanhTien;
}
public void setThanhTien(double thanhTien) {
	this.thanhTien = thanhTien;
}
public Date getThoiGianMua() {
	return thoiGianMua;
}
public void setThoiGianMua(Date thoiGianMua) {
	this.thoiGianMua = thoiGianMua;
}
public String getIDKhuyenMai() {
	return IDKhuyenMai;
}
public void setIDKhuyenMai(String iDKhuyenMai) {
	IDKhuyenMai = iDKhuyenMai;
}

}
