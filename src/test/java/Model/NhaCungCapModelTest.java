package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NhaCungCapModelTest {

    @Test
    public void testGetIdNhaCC() {
        // Arrange
        NhaCungCapModel nhaCC = new NhaCungCapModel("1", "tuanKhoiGroup","Dia Chi A", "123456789");
        
        // Act
        String idNhaCC = nhaCC.getIdNhaCC();
        
        // Assert
        Assert.assertEquals(idNhaCC, "1");
    }

    @Test
    public void testGetDiaChi() {
        // Arrange
    	 NhaCungCapModel nhaCC = new NhaCungCapModel("1", "tuanKhoiGroup","Dia Chi A", "123456789");
         
        
        // Act
        String diaChi = nhaCC.getDiaChi();
        
        // Assert
        Assert.assertEquals(diaChi, "Dia Chi A");
    }

    @Test
    public void testGetSoDienThoai() {
        // Arrange
    	 NhaCungCapModel nhaCC = new NhaCungCapModel("1", "tuanKhoiGroup","Dia Chi A", "123456789");
         
        
        // Act
        String soDienThoai = nhaCC.getSoDienThoai();
        
        // Assert
        Assert.assertEquals(soDienThoai, "123456789");
    }

    @Test
    public void testSetDiaChi() {
        // Arrange
    	 NhaCungCapModel nhaCC = new NhaCungCapModel("1", "tuanKhoiGroup","Dia Chi A", "123456789");
         
        
        // Act
        nhaCC.setDiaChi("Dia Chi B");
        
        // Assert
        Assert.assertEquals(nhaCC.getDiaChi(), "Dia Chi B");
    }

    @Test
    public void testSetSoDienThoai() {
        // Arrange
    	 NhaCungCapModel nhaCC = new NhaCungCapModel("1", "tuanKhoiGroup","Dia Chi A", "123456789");
         
        
        // Act
        nhaCC.setSoDienThoai("987654321");
        
        // Assert
        Assert.assertEquals(nhaCC.getSoDienThoai(), "987654321");
    }
}

