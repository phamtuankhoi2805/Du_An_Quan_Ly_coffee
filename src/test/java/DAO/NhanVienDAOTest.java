package DAO;

import org.testng.Assert;
import org.testng.annotations.Test;
import Model.NhanVienModel;
import java.util.ArrayList;

public class NhanVienDAOTest {

  @Test
  public void insertTest() {
      NhanVienDAO dao = NhanVienDAO.getInstance();
      NhanVienModel nhanVien = new NhanVienModel("NV102", null, null, null, false, null, null, null, null, 0, null);
      int result = dao.insert(nhanVien);
      Assert.assertEquals(result, 1, "Insertion should return 1 if successful");
  }

  @Test
  public void updateTest() {
      NhanVienDAO dao = NhanVienDAO.getInstance();
      NhanVienModel nhanVien = new NhanVienModel("NV101", null, null, null, false, null, null, null, null, 0, null);
      int result = dao.update(nhanVien);
      Assert.assertEquals(result, 1, "Update should return 1 if successful");
  }

  

  @Test
  public void selectAllTest() {
      NhanVienDAO dao = NhanVienDAO.getInstance();
      ArrayList<NhanVienModel> nhanViens = dao.selectAll();
      Assert.assertNotNull(nhanViens, "The result of selectAll should not be null");
      Assert.assertFalse(nhanViens.isEmpty(), "The result of selectAll should not be empty");
  }

  @Test
  public void selectAllDangLamViecTest() {
      NhanVienDAO dao = NhanVienDAO.getInstance();
      ArrayList<NhanVienModel> nhanViens = dao.selectAllDangLamViec();
      Assert.assertNotNull(nhanViens, "The result of selectAllDangLamViec should not be null");
  }

  @Test
  public void selectByIdTest() {
      NhanVienDAO dao = NhanVienDAO.getInstance();
      NhanVienModel nhanVien = new NhanVienModel("NV101", null, null, null, false, null, null, null, null, 0, null);
      NhanVienModel result = dao.selectById(nhanVien);
      Assert.assertNotNull(result, "The result of selectById should not be null");
  }

  
  @Test
  public void selectByConditionTest() {
      NhanVienDAO dao = NhanVienDAO.getInstance();
      String condition = "GioiTinh = 'true'"; // Giả sử bạn muốn tìm kiếm nhân viên nam, 'true' có thể đại diện cho giới tính nam
      ArrayList<NhanVienModel> nhanViens = dao.selectByCondition(condition);
      Assert.assertNotNull(nhanViens, "The result of selectByCondition should not be null");
  }


  @Test
  public void timkiemTest() {
      NhanVienDAO dao = NhanVienDAO.getInstance();
      String idNhanVien = "NV001"; // Thay "your_id_here" bằng ID cần tìm kiếm
      NhanVienModel result = dao.timkiem(idNhanVien);
      Assert.assertNotNull(result, "The result of timkiem should not be null");
  }


  @Test
  public void updatePassTest() {
      NhanVienDAO dao = NhanVienDAO.getInstance();
      String idNhanVien = "NV001"; // Thay "your_id_here" bằng ID của nhân viên cần cập nhật mật khẩu
      String newPassword = "12345"; // Thay "your_new_password_here" bằng mật khẩu mới
      dao.updatePass(idNhanVien, newPassword);
      // Bạn có thể thêm các khẳng định ở đây nếu cần
  }


  @Test
  public void updateCaLamTest() {
      NhanVienDAO dao = NhanVienDAO.getInstance();
      String idCaLam = "NV001"; // Thay "your_id_here" bằng ID của ca làm mới
      String idNhanVien = "CL3"; // Thay "your_employee_id_here" bằng ID của nhân viên cần cập nhật
      dao.updateCaLam(idCaLam, idNhanVien);
      // Bạn có thể thêm các khẳng định ở đây nếu cần
  }

}
