package Model;

public class DonHangChiTietModel {
private String IDSanPham;
private String IDDonHang;
private int soLuongMua;
private String IDHoaDon;
public DonHangChiTietModel() {

}
public DonHangChiTietModel(String iDSanPham, String iDDonHang, int soLuongMua, String iDHoaDon) {

	IDSanPham = iDSanPham;
	IDDonHang = iDDonHang;
	this.soLuongMua = soLuongMua;
	IDHoaDon = iDHoaDon;
}
public String getIDSanPham() {
	return IDSanPham;
}
public void setIDSanPham(String iDSanPham) {
	IDSanPham = iDSanPham;
}
public String getIDDonHang() {
	return IDDonHang;
}
public void setIDDonHang(String iDDonHang) {
	IDDonHang = iDDonHang;
}
public int getSoLuongMua() {
	return soLuongMua;
}
public void setSoLuongMua(int soLuongMua) {
	this.soLuongMua = soLuongMua;
}
public String getIDHoaDon() {
	return IDHoaDon;
}
public void setIDHoaDon(String iDHoaDon) {
	IDHoaDon = iDHoaDon;
}

}
