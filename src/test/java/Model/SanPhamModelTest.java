package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SanPhamModelTest {

    @Test
    public void testGetIdSanPham() {
        // Arrange
        SanPhamModel sanPham = new SanPhamModel("SP001", "Sản phẩm A", 1000000.0, "hinh_sanpham.jpg", "Hoạt động");
        
        // Act
        String idSanPham = sanPham.getIdSanPham();
        
        // Assert
        Assert.assertEquals(idSanPham, "SP001");
    }

    @Test
    public void testGetTenSP() {
        // Arrange
        SanPhamModel sanPham = new SanPhamModel("SP001", "Sản phẩm A", 1000000.0, "hinh_sanpham.jpg", "Hoạt động");
        
        // Act
        String tenSP = sanPham.getTenSP();
        
        // Assert
        Assert.assertEquals(tenSP, "Sản phẩm A");
    }

    @Test
    public void testGetGiaBan() {
        // Arrange
        SanPhamModel sanPham = new SanPhamModel("SP001", "Sản phẩm A", 1000000.0, "hinh_sanpham.jpg", "Hoạt động");
        
        // Act
        double giaBan = sanPham.getGiaBan();
        
        // Assert
        Assert.assertEquals(giaBan, 1000000.0);
    }

    @Test
    public void testGetHinh() {
        // Arrange
        SanPhamModel sanPham = new SanPhamModel("SP001", "Sản phẩm A", 1000000.0, "hinh_sanpham.jpg", "Hoạt động");
        
        // Act
        String hinh = sanPham.getHinh();
        
        // Assert
        Assert.assertEquals(hinh, "hinh_sanpham.jpg");
    }

    @Test
    public void testGetLoaiSP() {
        // Arrange
        SanPhamModel sanPham = new SanPhamModel("SP001", "Sản phẩm A", 1000000.0, "hinh_sanpham.jpg", "Tăng Lực");
        
        // Act
        String LoaiSP = sanPham.getLoaiSP();
        
        // Assert
        Assert.assertEquals(LoaiSP, "Tăng Lực");
    }

    // Similarly, write test methods for other getters and setters...
}

