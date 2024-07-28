package Model;

public class LoaiNguyenLieuModel {
private String idNguyenLieu,tenLoaiNguyenLieu;

public LoaiNguyenLieuModel() {

}

public LoaiNguyenLieuModel(String idNguyenLieu, String tenLoaiNguyenLieu) {

	this.idNguyenLieu = idNguyenLieu;
	this.tenLoaiNguyenLieu = tenLoaiNguyenLieu;
}

public String getIdNguyenLieu() {
	return idNguyenLieu;
}

public void setIdNguyenLieu(String idNguyenLieu) {
	this.idNguyenLieu = idNguyenLieu;
}

public String getTenLoaiNguyenLieu() {
	return tenLoaiNguyenLieu;
}

public void setTenLoaiNguyenLieu(String tenLoaiNguyenLieu) {
	this.tenLoaiNguyenLieu = tenLoaiNguyenLieu;
}

}
