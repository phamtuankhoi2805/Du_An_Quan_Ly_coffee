package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DAO.NguyenLieuDAO;
import DAO.NhanVienDAO;
import DAO.SoLuongNguyenLieuDAO;
import Model.NguyenLieuModel;
import Model.NhanVienModel;
import Model.SoLuongNguyenLieuModel;
import View.ThemChiTietView;

public class ThemNguyenLieuController implements ActionListener {
private ThemChiTietView tctv;
private NguyenLieuModel nlm;
private SoLuongNguyenLieuModel slnlm ;
int i;
 ArrayList<NguyenLieuModel> ListNl = NguyenLieuDAO.getInstance().selectAll();
 ArrayList<SoLuongNguyenLieuModel> ListSoLuongNL = SoLuongNguyenLieuDAO.getInstance().selectAll(); 
	public ThemNguyenLieuController(ThemChiTietView tctv, NguyenLieuModel nlm, SoLuongNguyenLieuModel slnlm) {

	this.tctv = tctv;
	this.nlm = nlm;
	this.slnlm = slnlm;
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
