package DAO;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import Model.SanPhamModel;

public class SanPhamDAOTest {
  
  private SanPhamDAO sanPhamDAO;
  
  @BeforeClass
  public void setUp() {
    sanPhamDAO = SanPhamDAO.getInstance();
  }
  
  @AfterClass
  public void tearDown() {
    sanPhamDAO = null;
  }
  
  @Test
  public void testInsert() {
    SanPhamModel sanPham = new SanPhamModel("SP011", "Sản phẩm 1", 1000.0, "hinh1.jpg", "Active");
    int result = sanPhamDAO.insert(sanPham);
    assertEquals(result, 1, "Insert method should return 1 if successful");
  }
  
  @Test(dependsOnMethods = { "testInsert" })
  public void testUpdate() {
    SanPhamModel sanPham = new SanPhamModel("SP004", "Sản phẩm 1 updated", 1500.0, "hinh1_updated.jpg", "Inactive");
    int result = sanPhamDAO.update(sanPham);
    assertEquals(result, 1, "Update method should return 1 if successful");
  }
  
  @Test(dependsOnMethods = { "testUpdate" })
  public void testUpdateNoImage() {
    SanPhamModel sanPham = new SanPhamModel("SP011", "Sản phẩm 1 updated", 1500.0, null, "Active");
    int result = sanPhamDAO.updateNoImage(sanPham);
    assertEquals(result, 1, "UpdateNoImage method should return 1 if successful");
  }
  
  @Test(dependsOnMethods = { "testUpdateNoImage" })
  public void testDelete() {
      // Insert một sản phẩm vào CSDL trước khi thử xóa
      SanPhamModel sanPham = new SanPhamModel("SP010", "Sản phẩm test", 1000.0, "hinh_test.jpg", "Active");
      sanPhamDAO.insert(sanPham);
      
      // Xóa sản phẩm vừa được thêm vào
      int result = sanPhamDAO.delete(sanPham);
      
      // Kiểm tra xem kết quả có phải là 1 hay không
      assertEquals(result, 1, "Delete method should return 1 if successful");
  }

  
  @Test
  public void testSelectAll() {
      // Kiểm tra ban đầu danh sách sản phẩm trả về từ phương thức selectAll() không rỗng
      ArrayList<SanPhamModel> sanPhamList = sanPhamDAO.selectAll();
      assertFalse(sanPhamList.isEmpty(), "SelectAll method should return a non-empty list initially");
  }

  
  @Test(dependsOnMethods = { "testInsert" })
  public void testSelectById() {
    SanPhamModel sanPham = new SanPhamModel("SP001", null, 0.0, null, null);
    SanPhamModel result = sanPhamDAO.selectById(sanPham);
    assertEquals(result.getIdSanPham(), "SP001", "SelectById method should return the correct SanPhamModel object");
  }
  
  @Test
  public void testSelectByCondition() {
    ArrayList<SanPhamModel> list = sanPhamDAO.selectByCondition("");
    assertEquals(list.size(), 0, "SelectByCondition method should return an empty list initially");
  }
}
