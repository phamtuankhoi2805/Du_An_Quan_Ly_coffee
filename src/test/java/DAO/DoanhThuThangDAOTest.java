package DAO;

import org.testng.Assert;
import org.testng.annotations.Test;

import Model.ThongKeDoanhThuTheoThangModel;

import java.util.ArrayList;

public class DoanhThuThangDAOTest {

  @Test
  public void getInstanceTest() {
    // Arrange
    DoanhThuThangDAO daoInstance;

    // Act
    daoInstance = DoanhThuThangDAO.getInstance();

    // Assert
    Assert.assertNotNull(daoInstance, "Đối tượng không được null");
  }

  @Test
  public void selectAllTest() {
    // Arrange
    DoanhThuThangDAO daoInstance = DoanhThuThangDAO.getInstance();

    // Act
    ArrayList<ThongKeDoanhThuTheoThangModel> resultList = daoInstance.selectAll();

    // Assert
    Assert.assertNotNull(resultList, "Danh sách không được null");
    Assert.assertFalse(resultList.isEmpty(), "Danh sách không được trống");
    // Có thể thêm các kiểm tra khác tùy theo logic của ứng dụng và cơ sở dữ liệu
  }
}
