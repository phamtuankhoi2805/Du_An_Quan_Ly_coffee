package Model;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.Date;

public class BangChamCongModelTest {

    @Test
    public void testConstructorAndGetters() {
        String idBangChamCong = "123";
        int ca = 1;
        Date checkIn = new Date(System.currentTimeMillis());
        Date checkOut = new Date(System.currentTimeMillis());
        String idNhanVien = "456";

        BangChamCongModel bangChamCongModel = new BangChamCongModel(idBangChamCong, ca, checkIn, checkOut, idNhanVien);

        Assert.assertEquals(bangChamCongModel.getIdBangChamCong(), idBangChamCong);
        Assert.assertEquals(bangChamCongModel.getCa(), ca);
        Assert.assertEquals(bangChamCongModel.getCheckIn(), checkIn);
        Assert.assertEquals(bangChamCongModel.getCheckOut(), checkOut);
        Assert.assertEquals(bangChamCongModel.getIdNhanVien(), idNhanVien);
    }

    @Test
    public void testSetters() {
        BangChamCongModel bangChamCongModel = new BangChamCongModel();

        String idBangChamCong = "123";
        int ca = 1;
        Date checkIn = new Date(System.currentTimeMillis());
        Date checkOut = new Date(System.currentTimeMillis());
        String idNhanVien = "456";

        bangChamCongModel.setIdBangChamCong(idBangChamCong);
        bangChamCongModel.setCa(ca);
        bangChamCongModel.setCheckIn(checkIn);
        bangChamCongModel.setCheckOut(checkOut);
        bangChamCongModel.setIdNhanVien(idNhanVien);

        Assert.assertEquals(bangChamCongModel.getIdBangChamCong(), idBangChamCong);
        Assert.assertEquals(bangChamCongModel.getCa(), ca);
        Assert.assertEquals(bangChamCongModel.getCheckIn(), checkIn);
        Assert.assertEquals(bangChamCongModel.getCheckOut(), checkOut);
        Assert.assertEquals(bangChamCongModel.getIdNhanVien(), idNhanVien);
    }
}

