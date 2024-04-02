package Model;

import java.sql.Date;

public class CaLamViecModel {
private String idCaLam;
private String tenCaLam;
private String thoiGian;
private String Ngay;

public CaLamViecModel() {

}

public CaLamViecModel(String idCaLam, String tenCaLam, String thoiGian, String ngay) {

	this.idCaLam = idCaLam;
	this.tenCaLam = tenCaLam;
	this.thoiGian = thoiGian;
	Ngay = ngay;
}

public String getIdCaLam() {
	return idCaLam;
}

public void setIdCaLam(String idCaLam) {
	this.idCaLam = idCaLam;
}

public String getTenCaLam() {
	return tenCaLam;
}

public void setTenCaLam(String tenCaLam) {
	this.tenCaLam = tenCaLam;
}

public String getThoiGian() {
	return thoiGian;
}

public void setThoiGian(String thoiGian) {
	this.thoiGian = thoiGian;
}

public String getNgay() {
	return Ngay;
}

public void setNgay(String ngay) {
	Ngay = ngay;
}



}
