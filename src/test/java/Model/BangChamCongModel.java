package Model;

import java.sql.Date;

public class BangChamCongModel {
    private String idBangChamCong;
    private int ca;
    private Date checkIn;
    private Date checkOut;
    private String idNhanVien;
	public BangChamCongModel() {
	
	}
	public BangChamCongModel(String idBangChamCong, int ca, Date checkIn, Date checkOut, String idNhanVien) {
		
		this.idBangChamCong = idBangChamCong;
		this.ca = ca;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.idNhanVien = idNhanVien;
	}
	public String getIdBangChamCong() {
		return idBangChamCong;
	}
	public void setIdBangChamCong(String idBangChamCong) {
		this.idBangChamCong = idBangChamCong;
	}
	public int getCa() {
		return ca;
	}
	public void setCa(int ca) {
		this.ca = ca;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(String idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
    
}
