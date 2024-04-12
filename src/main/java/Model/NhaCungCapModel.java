package Model;

public class NhaCungCapModel {
private String idNhaCC,tenNhaCC,diaChi,soDienThoai;

public NhaCungCapModel() {

}

public NhaCungCapModel(String idNhaCC, String tenNhaCC, String diaChi, String soDienThoai) {

	this.idNhaCC = idNhaCC;
	this.tenNhaCC = tenNhaCC;
	this.diaChi = diaChi;
	this.soDienThoai = soDienThoai;
}

public String getIdNhaCC() {
	return idNhaCC;
}

public void setIdNhaCC(String idNhaCC) {
	this.idNhaCC = idNhaCC;
}

public String getTenNhaCC() {
	return tenNhaCC;
}

public void setTenNhaCC(String tenNhaCC) {
	this.tenNhaCC = tenNhaCC;
}

public String getDiaChi() {
	return diaChi;
}

public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}

public String getSoDienThoai() {
	return soDienThoai;
}

public void setSoDienThoai(String soDienThoai) {
	this.soDienThoai = soDienThoai;
}



}
