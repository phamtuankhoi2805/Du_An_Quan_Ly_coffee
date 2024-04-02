package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBCUtil;

import Model.NhanVienModel;
import Model.SanPhamModel;

public class SanPhamDAO implements DAOInterface<SanPhamModel> {
	public static SanPhamDAO getInstance() {
		return new SanPhamDAO();
	}

	@Override
	public int insert(SanPhamModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = Database.JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="INSERT INTO SANPHAM (IDSanPham, TenSP, GiaBan,Hinh,TrangThai) VALUES(?, ?, ?,?,?)";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, t.getIdSanPham());
	            statement.setString(2, t.getTenSP());
	            statement.setDouble(3, t.getGiaBan());
	            statement.setString(4, t.getHinh());
	            statement.setString(5, t.getTrangThai());
	            // Bước 3: Thực thi truy vấn
	            ketQua = statement.executeUpdate();

	            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

	            // Bước 4: Đóng kết nối
	            JDBCUtil.closeConnection(con);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	@Override
	public int update(SanPhamModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="UPDATE SANPHAM SET  TenSP=?, GiaBan=?,Hinh=?,TrangThai =?  WHERE IDSanPham=?";
	            PreparedStatement statement = con.prepareStatement(sql);
	           
	            statement.setString(1, t.getTenSP());
	            statement.setDouble(2, t.getGiaBan());
	            statement.setString(3, t.getHinh());
	            statement.setString(4, t.getTrangThai());
	            statement.setString(5, t.getIdSanPham());
	            // Bước 3: Thực thi truy vấn
	            ketQua = statement.executeUpdate();

	            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

	            // Bước 4: Đóng kết nối
	            JDBCUtil.closeConnection(con);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ketQua;
	}
	public int updateNoImage(SanPhamModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="UPDATE SANPHAM SET  TenSP=?, GiaBan=?,TrangThai=? WHERE IDSanPham=?";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, t.getTenSP());
	            statement.setDouble(2, t.getGiaBan());
	            statement.setString(3, t.getTrangThai());
	            statement.setString(4, t.getIdSanPham());
	            // Bước 3: Thực thi truy vấn
	            ketQua = statement.executeUpdate();

	            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

	            // Bước 4: Đóng kết nối
	            JDBCUtil.closeConnection(con);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ketQua;
	}
	@Override
	public int delete(SanPhamModel t) {
		 int ketQua = 0;
	        try {
	            // Bước 1: Kết nối CSDL
	            Connection con = JDBCUtil.getConnection();

	            // Bước 2: Tạo prepared statement
	            String sql="DELETE FROM SANPHAM WHERE IDSanPham=?";
	            PreparedStatement statement = con.prepareStatement(sql);

	            statement.setString(1, t.getIdSanPham());

	            // Bước 3: Thực thi truy vấn
	            ketQua = statement.executeUpdate();

	            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

	            // Bước 4: Đóng kết nối
	            JDBCUtil.closeConnection(con);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return ketQua;
	}

	@Override
	public ArrayList<SanPhamModel> selectAll() {
		 ArrayList<SanPhamModel> ketQua = new ArrayList<>();
		    try {
		        // Bước 1: Kết nối CSDL
		        Connection con = JDBCUtil.getConnection();

		        // Bước 2: Tạo prepared statement
		        String sql = "SELECT * FROM SANPHAM";
		        PreparedStatement statement = con.prepareStatement(sql);

		        ResultSet rs = statement.executeQuery();

		        while (rs.next()) {
		            String idSanPham = rs.getString("IDSanPham");
		            String tenSP = rs.getString("TenSP");
		            double giaBan = rs.getDouble("GiaBan");
		            String Hinh = rs.getString("Hinh");
		            String TrangThai = rs.getString("TrangThai");
		       SanPhamModel sp = new SanPhamModel(idSanPham, tenSP, giaBan, Hinh,TrangThai);
		            ketQua.add(sp);
		        }

		        // Bước 3: Đóng kết nối
		        JDBCUtil.closeConnection(con);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return ketQua;
	}

	@Override
	public SanPhamModel selectById(SanPhamModel t) {
		SanPhamModel ketQua = null;
        try {
            // Bước 1: Kết nối CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Tạo prepared statement
            String sql = "SELECT * FROM SANPHAM WHERE IDSanPham = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, t.getIdSanPham());

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String idSanPham = rs.getString("IDSanPham");
	            String tenSP = rs.getString("TenSP");
	            double giaBan = rs.getDouble("GiaBan");
	            String Hinh = rs.getString("Hinh");
	            String TrangThai = rs.getString("TrangThai");
	       SanPhamModel sp = new SanPhamModel(idSanPham, tenSP, giaBan, Hinh,TrangThai);

                ketQua = sp;
            }

            // Bước 3: Đóng kết nối
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
	}

	@Override
	public ArrayList<SanPhamModel> selectByCondition(String condition) {
		ArrayList<SanPhamModel> ketQua = new ArrayList<>();
		try {
			// Bước 1: Kết nối CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: Tạo prepared statement
			String sql = "SELECT * FROM SANPHAM WHERE " + condition;
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
			    String idSanPham = rs.getString("IDSanPham");
	            String tenSP = rs.getString("TenSP");
	            double giaBan = rs.getDouble("GiaBan");
	            String Hinh = rs.getString("Hinh");
	            String TrangThai = rs.getString("TrangThai");
	       SanPhamModel sp = new SanPhamModel(idSanPham, tenSP, giaBan, Hinh,TrangThai);
				ketQua.add(sp);
			}

			// Bước 3: Đóng kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	

	
}
