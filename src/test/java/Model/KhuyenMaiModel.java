package Model;

public class KhuyenMaiModel {
private String idKhuyenMai;
private String tenKhuyenMai,dieuKienKM;
private float tongTru;
public KhuyenMaiModel() {

}
public KhuyenMaiModel(String idKhuyenMai, String tenKhuyenMai, String dieuKienKM, float tongTru) {

	this.idKhuyenMai = idKhuyenMai;
	this.tenKhuyenMai = tenKhuyenMai;
	this.dieuKienKM = dieuKienKM;
	this.tongTru = tongTru;
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
public float getTongTru() {
	return tongTru;
}
public void setTongTru(float tongTru) {
	this.tongTru = tongTru;
}


}