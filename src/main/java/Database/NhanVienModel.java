
package Model;

import java.security.Identity;
import java.sql.Date;

public class NhanVienModel {
	private String idNhanVien, matKhau, tenNV;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String soDienThoai, Email, chucVu, trangThai;
	private double luongCB;
	private String idCaLam;

	public NhanVienModel() {

	}

	public NhanVienModel(String idNhanVien, String matKhau, String tenNV, Date ngaySinh, boolean gioiTinh,
			String soDienThoai, String email, String chucVu, String trangThai, double luongCB, String idCaLam) {
		super();
		this.idNhanVien = idNhanVien;
		this.matKhau = matKhau;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.Email = email;
		this.chucVu = chucVu;
		this.trangThai = trangThai;
		this.luongCB = luongCB;
		this.idCaLam = idCaLam;
	}

	public String getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(String idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public double getLuongCB() {
		return luongCB;
	}

	public void setLuongCB(double luongCB) {
		this.luongCB = luongCB;
	}

	public String getIdCaLam() {
		return idCaLam;
	}

	public void setIdCaLam(String idCaLam) {
		this.idCaLam = idCaLam;
	}

	@Override
	public String toString() {
		return "NhanVienModel [idNhanVien=" + idNhanVien + ", matKhau=" + matKhau + ", tenNV=" + tenNV + ", ngaySinh="
				+ ngaySinh + ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai + ", Email=" + Email
				+ ", chucVu=" + chucVu + ", trangThai=" + trangThai + ", luongCB=" + luongCB + ", idCaLam=" + idCaLam
				+ "]";
	} 

}
