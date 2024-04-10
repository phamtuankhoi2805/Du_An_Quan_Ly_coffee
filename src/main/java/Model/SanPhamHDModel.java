package Model;

public class SanPhamHDModel {
	private String idSanPham,tenSP;
	private double giaBan;
	private int soLuong;
	private String hinh,LoaiSP;
	public SanPhamHDModel(String idSanPham, String tenSP, double giaBan, int soLuong, String hinh, String loaiSP) {

		this.idSanPham = idSanPham;
		this.tenSP = tenSP;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.hinh = hinh;
		LoaiSP = loaiSP;
	}
	public String getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public String getLoaiSP() {
		return LoaiSP;
	}
	public void setLoaiSP(String loaiSP) {
		LoaiSP = loaiSP;
	}
	@Override
	public String toString() {
		return "SanPhamHDModel [idSanPham=" + idSanPham + ", tenSP=" + tenSP + ", giaBan=" + giaBan + ", soLuong="
				+ soLuong + ", hinh=" + hinh + ", LoaiSP=" + LoaiSP + "]";
	}
	
}
