package DAO;

import org.testng.Assert;
import org.testng.annotations.Test;

import Model.KhuyenMaiModel;

import java.util.ArrayList;

public class KhuyenMaiDAOTest {

  @Test
  public void getInstanceTest() {
    // Arrange
    KhuyenMaiDAO daoInstance;

    // Act
    daoInstance = KhuyenMaiDAO.getInstance();

    // Assert
    Assert.assertNotNull(daoInstance, "Đối tượng không được null");
  }

  @Test
  public void insertTest() {
    // Arrange
    KhuyenMaiDAO daoInstance = KhuyenMaiDAO.getInstance();
    KhuyenMaiModel khuyenMaiModel = new KhuyenMaiModel("KM005", "Giảm giá 60%", "Tổng tiền lớn hơn 699k", 0.6f);

    // Act
    int result = daoInstance.insert(khuyenMaiModel);

    // Assert
    Assert.assertNotEquals(result, 0, "Không thành công khi chèn khuyến mãi mới");
  }

  @Test
  public void selectAllTest() {
    // Arrange
    KhuyenMaiDAO daoInstance = KhuyenMaiDAO.getInstance();

    // Act
    ArrayList<KhuyenMaiModel> resultList = daoInstance.selectAll();

    // Assert
    Assert.assertNotNull(resultList, "Danh sách không được null");
    Assert.assertFalse(resultList.isEmpty(), "Danh sách không được trống");
    // Có thể thêm các kiểm tra khác tùy theo logic của ứng dụng và cơ sở dữ liệu
  }

  @Test
  public void updateTest() {
    // Arrange
    KhuyenMaiDAO daoInstance = KhuyenMaiDAO.getInstance();
    KhuyenMaiModel khuyenMaiModel = new KhuyenMaiModel("KM005", "Giảm giá 60%", "Tổng tiền lớn hơn 699k", 0.6f);

    // Act
    int result = daoInstance.update(khuyenMaiModel);

    // Assert
    Assert.assertNotEquals(result, 0, "Không thành công khi cập nhật khuyến mãi");
  }
}
