package Model;

public class ThongKeDoanhThuTheoNamModel {
private String nam;
private int doạnhThu;
public ThongKeDoanhThuTheoNamModel() {

}
public ThongKeDoanhThuTheoNamModel(String nam, int doạnhThu) {

	this.nam = nam;
	this.doạnhThu = doạnhThu;
}
public String getNam() {
	return nam;
}
public void setNam(String nam) {
	this.nam = nam;
}
public int getDoạnhThu() {
	return doạnhThu;
}
public void setDoạnhThu(int doạnhThu) {
	this.doạnhThu = doạnhThu;
}

}
