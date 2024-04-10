package DAO;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import Model.TableNhapModel;

public class TableNhapDAOTest {

  @Test
  public void getInstanceTest() {
    // Kiểm tra rằng phương thức getInstance() không trả về null
    Assert.assertNotNull(TableNhapDAO.getInstance());
  }

  @Test
  public void selectAllTest() {
    // Tạo một đối tượng DAO
    TableNhapDAO tableNhapDAO = TableNhapDAO.getInstance();
    
    // Gọi phương thức selectAll()
    ArrayList<TableNhapModel> result = tableNhapDAO.selectAll();
    
    // Kiểm tra rằng kết quả không rỗng
    Assert.assertNotEquals(result.size(), 0);
  }
}
