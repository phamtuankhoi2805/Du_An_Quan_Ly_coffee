package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ThongKeDoanhThuTheoNamModelTest {

    @Test
    public void testGetNam() {
        // Arrange
        ThongKeDoanhThuTheoNamModel thongKe = new ThongKeDoanhThuTheoNamModel("2023", 10000000);
        
        // Act
        String nam = thongKe.getNam();
        
        // Assert
        Assert.assertEquals(nam, "2023");
    }

    @Test
    public void testGetDoanhThu() {
        // Arrange
        ThongKeDoanhThuTheoNamModel thongKe = new ThongKeDoanhThuTheoNamModel("2023", 10000000);
        
        // Act
        int doanhThu = thongKe.getDoanhThu();
        
        // Assert
        Assert.assertEquals(doanhThu, 10000000);
    }

    @Test
    public void testSetNam() {
        // Arrange
        ThongKeDoanhThuTheoNamModel thongKe = new ThongKeDoanhThuTheoNamModel("2023", 10000000);
        
        // Act
        thongKe.setNam("2024");
        
        // Assert
        Assert.assertEquals(thongKe.getNam(), "2024");
    }

    @Test
    public void testSetDoanhThu() {
        // Arrange
        ThongKeDoanhThuTheoNamModel thongKe = new ThongKeDoanhThuTheoNamModel("2023", 10000000);
        
        // Act
        thongKe.setDoanhThu(15000000);
        
        // Assert
        Assert.assertEquals(thongKe.getDoanhThu(), 15000000);
    }
}

