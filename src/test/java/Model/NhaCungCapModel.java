package Model;

public class NhaCungCapModel {
private String idNhaCC,diaChi,soDienThoai;

public NhaCungCapModel() {

}

public NhaCungCapModel(String idNhaCC, String diaChi, String soDienThoai) {
	
	this.idNhaCC = idNhaCC;
	this.diaChi = diaChi;
	this.soDienThoai = soDienThoai;
}

public String getIdNhaCC() {
	return idNhaCC;
}

public void setIdNhaCC(String idNhaCC) {
	this.idNhaCC = idNhaCC;
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
