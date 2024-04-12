package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.NhanVienModel;
import Model.TableNhapModel;

public class TableNhapDAO implements DAOInterface<TableNhapModel> {
	public static TableNhapDAO getInstance() {
		return new TableNhapDAO();
	}
	
	@Override
	public int insert(TableNhapModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TableNhapModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(TableNhapModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<TableNhapModel> selectAll() {
		  ArrayList<TableNhapModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "SELECT DISTINCT NguyenLieu.IDNguyenLieu, NguyenLieu.TenNguyenLieu, NguyenLieu.SoLuongTon, NhaCungCap.TenNhaCC, NhaCungCap.SDT\n"
		        		+ "FROM NguyenLieu\n"
		        		+ "JOIN PhieuGiaoHangChiTiet ON NguyenLieu.IDNguyenLieu = PhieuGiaoHangChiTiet.IDNguyenLieu\n"
		        		+ "JOIN PhieuGiaoHang ON PhieuGiaoHangChiTiet.IDPhieuGiao = PhieuGiaoHang.IDPhieuGiao\n"
		        		+ "JOIN NhaCungCap ON PhieuGiaoHang.IDNhaCC = NhaCungCap.IDNhaCC;";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		            String idNguyenLieu = rs.getString("IDNguyenLieu");
		            String TenNguyenLieu = rs.getString("TenNguyenLieu");
		            int soLuongTon = rs.getInt("SoLuongTon");
		
		            String TenNhaCC = rs.getString("TenNhaCC");

		            String SDT = rs.getString("SDT");
		           
		      TableNhapModel tbln =  new TableNhapModel(idNguyenLieu, TenNguyenLieu, soLuongTon, TenNhaCC, SDT);
		            ketQua.add(tbln);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}

	@Override
	public TableNhapModel selectById(TableNhapModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TableNhapModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
