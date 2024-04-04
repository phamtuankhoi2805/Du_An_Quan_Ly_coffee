package Model;

import java.sql.Date;

public class HoaDonModel {
private String idHoaDon;
private int soLuong;
private double donGia;
private String khuyenMai;
private Date thoiGianMua;
private double thanhTien;
private String idSanPham,idDonHang,idKhuyenMai;
public HoaDonModel() {

}
public HoaDonModel(String idHoaDon, int soLuong, double donGia, String khuyenMai, Date thoiGianMua, double thanhTien,
		String idSanPham, String idDonHang, String idKhuyenMai) {

	this.idHoaDon = idHoaDon;
	this.soLuong = soLuong;
	this.donGia = donGia;
	this.khuyenMai = khuyenMai;
	this.thoiGianMua = thoiGianMua;
	this.thanhTien = thanhTien;
	this.idSanPham = idSanPham;
	this.idDonHang = idDonHang;
	this.idKhuyenMai = idKhuyenMai;
}
public String getIdHoaDon() {
	return idHoaDon;
}
public void setIdHoaDon(String idHoaDon) {
	this.idHoaDon = idHoaDon;
}
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
public double getDonGia() {
	return donGia;
}
public void setDonGia(double donGia) {
	this.donGia = donGia;
}
public String getKhuyenMai() {
	return khuyenMai;
}
public void setKhuyenMai(String khuyenMai) {
	this.khuyenMai = khuyenMai;
}
public Date getThoiGianMua() {
	return thoiGianMua;
}
public void setThoiGianMua(Date thoiGianMua) {
	this.thoiGianMua = thoiGianMua;
}
public double getThanhTien() {
	return thanhTien;
}
public void setThanhTien(double thanhTien) {
	this.thanhTien = thanhTien;
}
public String getIdSanPham() {
	return idSanPham;
}
public void setIdSanPham(String idSanPham) {
	this.idSanPham = idSanPham;
}
public String getIdDonHang() {
	return idDonHang;
}
public void setIdDonHang(String idDonHang) {
	this.idDonHang = idDonHang;
}
public String getIdKhuyenMai() {
	return idKhuyenMai;
}
public void setIdKhuyenMai(String idKhuyenMai) {
	this.idKhuyenMai = idKhuyenMai;
}

}
