package Model;

public class KhuyenMaiModel {
private String idKhuyenMai;
private String tenKhuyenMai,dieuKienKM;
public KhuyenMaiModel() {

}
public KhuyenMaiModel(String idKhuyenMai, String tenKhuyenMai, String dieuKienKM) {

	this.idKhuyenMai = idKhuyenMai;
	this.tenKhuyenMai = tenKhuyenMai;
	this.dieuKienKM = dieuKienKM;
}
public String getIdKhuyenMai() {
	return idKhuyenMai;
}
public void setIdKhuyenMai(String idKhuyenMai) {
	this.idKhuyenMai = idKhuyenMai;
}
public String getTenKhuyenMai() {
	return tenKhuyenMai;
}
public void setTenKhuyenMai(String tenKhuyenMai) {
	this.tenKhuyenMai = tenKhuyenMai;
}
public String getDieuKienKM() {
	return dieuKienKM;
}
public void setDieuKienKM(String dieuKienKM) {
	this.dieuKienKM = dieuKienKM;
}

}