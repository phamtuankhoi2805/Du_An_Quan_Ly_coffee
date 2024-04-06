package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ThongKeDoanhThuTheoThangModelTest {

    @Test
    public void testGetNam() {
        // Arrange
        ThongKeDoanhThuTheoThangModel thongKe = new ThongKeDoanhThuTheoThangModel("2023", "05", 10000000, 20);
        
        // Act
        String nam = thongKe.getNam();
        
        // Assert
        Assert.assertEquals(nam, "2023");
    }

    @Test
    public void testGetThang() {
        // Arrange
        ThongKeDoanhThuTheoThangModel thongKe = new ThongKeDoanhThuTheoThangModel("2023", "05", 10000000, 20);
        
        // Act
        String thang = thongKe.getThang();
        
        // Assert
        Assert.assertEquals(thang, "05");
    }

    @Test
    public void testGetDoanhThu() {
        // Arrange
        ThongKeDoanhThuTheoThangModel thongKe = new ThongKeDoanhThuTheoThangModel("2023", "05", 10000000, 20);
        
        // Act
        int doanhThu = thongKe.getDoanhThu();
        
        // Assert
        Assert.assertEquals(doanhThu, 10000000);
    }

    @Test
    public void testGetTongDon() {
        // Arrange
        ThongKeDoanhThuTheoThangModel thongKe = new ThongKeDoanhThuTheoThangModel("2023", "05", 10000000, 20);
        
        // Act
        int tongDon = thongKe.getTongDon();
        
        // Assert
        Assert.assertEquals(tongDon, 20);
    }

    @Test
    public void testSetNam() {
        // Arrange
        ThongKeDoanhThuTheoThangModel thongKe = new ThongKeDoanhThuTheoThangModel("2023", "05", 10000000, 20);
        
        // Act
        thongKe.setNam("2024");
        
        // Assert
        Assert.assertEquals(thongKe.getNam(), "2024");
    }

    @Test
    public void testSetThang() {
        // Arrange
        ThongKeDoanhThuTheoThangModel thongKe = new ThongKeDoanhThuTheoThangModel("2023", "05", 10000000, 20);
        
        // Act
        thongKe.setThang("06");
        
        // Assert
        Assert.assertEquals(thongKe.getThang(), "06");
    }

    @Test
    public void testSetDoanhThu() {
        // Arrange
        ThongKeDoanhThuTheoThangModel thongKe = new ThongKeDoanhThuTheoThangModel("2023", "05", 10000000, 20);
        
        // Act
        thongKe.setDoanhThu(15000000);
        
        // Assert
        Assert.assertEquals(thongKe.getDoanhThu(), 15000000);
    }

    @Test
    public void testSetTongDon() {
        // Arrange
        ThongKeDoanhThuTheoThangModel thongKe = new ThongKeDoanhThuTheoThangModel("2023", "05", 10000000, 20);
        
        // Act
        thongKe.setTongDon(30);
        
        // Assert
        Assert.assertEquals(thongKe.getTongDon(), 30);
    }
}

