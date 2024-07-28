package Model;

public class ThongKeDoanhThuTheoNamModel {
private String nam;
private int doanhThu;
public ThongKeDoanhThuTheoNamModel() {

}
public ThongKeDoanhThuTheoNamModel(String nam, int doanhThu) {

	this.nam = nam;
	this.doanhThu = doanhThu;
}
public String getNam() {
	return nam;
}
public void setNam(String nam) {
	this.nam = nam;
}
public int getDoanhThu() {
	return doanhThu;
}
public void setDoanhThu(int doanhThu) {
	this.doanhThu = doanhThu;
}


}
