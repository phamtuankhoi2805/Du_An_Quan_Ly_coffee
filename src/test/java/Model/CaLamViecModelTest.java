package Model;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CaLamViecModelTest {

    @Test
    public void testConstructorAndGetters() {
<<<<<<< HEAD
        String idCaLam = "cl9";
        String tenCaLam = "Ca Sáng";
        String thoiGian = "8:00 - 12:00";
        String ngay = "2024-04-06";
        String idNhanVien = "NV001";
=======
        String idCaLam = "123";
        String tenCaLam = "Ca Sáng";
        String thoiGian = "8:00 - 12:00";
        String ngay = "2024-04-06";
        String idNhanVien = "456";
>>>>>>> 55c9e4b1c49fdc75a318376b52e3d0ff4ab89632

        CaLamViecModel caLamViecModel = new CaLamViecModel(idCaLam, tenCaLam, thoiGian, ngay, idNhanVien);

        Assert.assertEquals(caLamViecModel.getIdCaLam(), idCaLam);
        Assert.assertEquals(caLamViecModel.getTenCaLam(), tenCaLam);
        Assert.assertEquals(caLamViecModel.getThoiGian(), thoiGian);
        Assert.assertEquals(caLamViecModel.getNgay(), ngay);
        Assert.assertEquals(caLamViecModel.getIdNhanVien(), idNhanVien);
    }

    @Test
    public void testSetters() {
        CaLamViecModel caLamViecModel = new CaLamViecModel();

        String idCaLam = "123";
        String tenCaLam = "Ca Chiều";
        String thoiGian = "13:00 - 17:00";
        String ngay = "2024-04-06";
        String idNhanVien = "789";

        caLamViecModel.setIdCaLam(idCaLam);
        caLamViecModel.setTenCaLam(tenCaLam);
        caLamViecModel.setThoiGian(thoiGian);
        caLamViecModel.setNgay(ngay);
        caLamViecModel.setIdNhanVien(idNhanVien);

        Assert.assertEquals(caLamViecModel.getIdCaLam(), idCaLam);
        Assert.assertEquals(caLamViecModel.getTenCaLam(), tenCaLam);
        Assert.assertEquals(caLamViecModel.getThoiGian(), thoiGian);
        Assert.assertEquals(caLamViecModel.getNgay(), ngay);
        Assert.assertEquals(caLamViecModel.getIdNhanVien(), idNhanVien);
    }
}

