package Model;

public class RowData {
    private String idNguyenLieu;
    private String tenNguyenLieu;
    private int soLuongGiao;
    private double donGia;
    private String donViTinh;
    private String idNhaCC;
    private String tenNCC;
    private String DiaChi;
    private String sdt;
    private String ngayGiao;
    private double tongTien;
    
	public RowData() {
	
	}

	public RowData(String idNguyenLieu, String tenNguyenLieu, int soLuongGiao, double donGia, String donViTinh,
			String idNhaCC, String tenNCC, String diaChi, String sdt, String ngayGiao, double tongTien) {

		this.idNguyenLieu = idNguyenLieu;
		this.tenNguyenLieu = tenNguyenLieu;
		this.soLuongGiao = soLuongGiao;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.idNhaCC = idNhaCC;
		this.tenNCC = tenNCC;
		DiaChi = diaChi;
		this.sdt = sdt;
		this.ngayGiao = ngayGiao;
		this.tongTien = tongTien;
	}

	public String getIdNguyenLieu() {
		return idNguyenLieu;
	}

	public void setIdNguyenLieu(String idNguyenLieu) {
		this.idNguyenLieu = idNguyenLieu;
	}

	public String getTenNguyenLieu() {
		return tenNguyenLieu;
	}

	public void setTenNguyenLieu(String tenNguyenLieu) {
		this.tenNguyenLieu = tenNguyenLieu;
	}

	public int getSoLuongGiao() {
		return soLuongGiao;
	}

	public void setSoLuongGiao(int soLuongGiao) {
		this.soLuongGiao = soLuongGiao;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public String getIdNhaCC() {
		return idNhaCC;
	}

	public void setIdNhaCC(String idNhaCC) {
		this.idNhaCC = idNhaCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getNgayGiao() {
		return ngayGiao;
	}

	public void setNgayGiao(String ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
    
}
