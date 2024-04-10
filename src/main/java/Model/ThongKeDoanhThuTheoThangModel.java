package Model;

public class ThongKeDoanhThuTheoThangModel {
private String nam,thang;
private int doanhThu;
private int tongDon;
public ThongKeDoanhThuTheoThangModel() {
	
}
public ThongKeDoanhThuTheoThangModel(String nam, String thang, int doanhThu, int tongDon) {

	this.nam = nam;
	this.thang = thang;
	this.doanhThu = doanhThu;
	this.tongDon = tongDon;
}
public String getNam() {
	return nam;
}
public void setNam(String nam) {
	this.nam = nam;
}
public String getThang() {
	return thang;
}
public void setThang(String thang) {
	this.thang = thang;
}
public int getDoanhThu() {
	return doanhThu;
}
public void setDoanhThu(int doanhThu) {
	this.doanhThu = doanhThu;
}
public int getTongDon() {
	return tongDon;
}
public void setTongDon(int tongDon) {
	this.tongDon = tongDon;
}



}
