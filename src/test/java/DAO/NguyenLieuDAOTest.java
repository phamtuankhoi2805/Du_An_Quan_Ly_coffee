package DAO;

import org.testng.Assert;
import org.testng.annotations.Test;

import Model.NguyenLieuModel;

import java.util.ArrayList;

public class NguyenLieuDAOTest {

  @Test
  public void insertTest() {
    // Arrange
    NguyenLieuDAO daoInstance = NguyenLieuDAO.getInstance();
    NguyenLieuModel nguyenLieuModel = new NguyenLieuModel("ID1", "Tên nguyên liệu", 100, "Đơn vị tính");

    // Act
    int result = daoInstance.insert(nguyenLieuModel);

    // Assert
    Assert.assertNotEquals(result, 0, "Không thành công khi chèn nguyên liệu mới");
  }

  @Test
  public void selectAllTest() {
    // Arrange
    NguyenLieuDAO daoInstance = NguyenLieuDAO.getInstance();

    // Act
    ArrayList<NguyenLieuModel> resultList = daoInstance.selectAll();

    // Assert
    Assert.assertNotNull(resultList, "Danh sách không được null");
    Assert.assertFalse(resultList.isEmpty(), "Danh sách không được trống");
    // Có thể thêm các kiểm tra khác tùy theo logic của ứng dụng và cơ sở dữ liệu
  }

  @Test
  public void updateTest() {
    // Arrange
    NguyenLieuDAO daoInstance = NguyenLieuDAO.getInstance();
    NguyenLieuModel nguyenLieuModel = new NguyenLieuModel("ID1", "Tên nguyên liệu sửa", 150, "Đơn vị tính sửa");

    // Act
    int result = daoInstance.update(nguyenLieuModel);

    // Assert
    Assert.assertNotEquals(result, 0, "Không thành công khi cập nhật thông tin nguyên liệu");
  }

  @Test
  public void updateSoLuongTonTest() {
    // Arrange
    NguyenLieuDAO daoInstance = NguyenLieuDAO.getInstance();
    NguyenLieuModel nguyenLieuModel = new NguyenLieuModel("ID1", "Tên nguyên liệu", 200, "Đơn vị tính");

    // Act
    int result = daoInstance.updateSoLuongTon(nguyenLieuModel);

    // Assert
    Assert.assertNotEquals(result, 0, "Không thành công khi cập nhật số lượng tồn của nguyên liệu");
  }
}
