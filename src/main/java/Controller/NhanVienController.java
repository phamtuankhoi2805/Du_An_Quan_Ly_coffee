package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DAO.SanPhamDAO;
import Model.SanPhamModel;
import View.TestSP;

public class NhanVienController implements ActionListener {
	ArrayList<SanPhamModel> listSP = SanPhamDAO.getInstance().selectAll();

	
	public NhanVienController() {

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
