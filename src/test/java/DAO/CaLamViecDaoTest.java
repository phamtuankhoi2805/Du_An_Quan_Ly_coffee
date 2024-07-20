package DAO;

import org.testng.annotations.Test;

import Model.CaLamViecModel;
import Model.NhanVienModel;

import java.util.ArrayList;

public class CaLamViecDaoTest {

    @Test
    public void deleteTest() {
        // Tạo đối tượng CaLamViecModel tương ứng
    	 CaLamViecModel caLamViec = new CaLamViecModel("CL22", "Ca A", "8h - 16h", "2024-04-06");

        // Thực hiện delete
        int result = CaLamViecDao.getInstance().delete(caLamViec);

        // Kiểm tra kết quả
        assert result == 1 : "Delete method should return 1 if successful";
    }

    @Test
    public void getInstanceTest() {
        // Thực hiện getInstance
        CaLamViecDao instance = CaLamViecDao.getInstance();

        // Kiểm tra kết quả
        assert instance != null : "GetInstance method should return a non-null object";
    }

    @Test
    public void insertTest() {
        // Tạo đối tượng CaLamViecModel tương ứng
        CaLamViecModel caLamViec = new CaLamViecModel("CL22", "Ca A", "8h - 16h", "2024-04-06");

        // Thực hiện insert
        int result = CaLamViecDao.getInstance().insert(caLamViec);

        // Kiểm tra kết quả
        assert result == 1 : "Insert method should return 1 if successful";
    }

    @Test
    public void selectAllTest() {
        // Thực hiện selectAll
        ArrayList<CaLamViecModel> result = CaLamViecDao.getInstance().selectAll();

        // Kiểm tra kết quả
        assert result != null && !result.isEmpty() : "SelectAll method should return a non-empty list initially";
    }

    @Test
    public void selectByConditionTest() {
        // Đặt điều kiện là ngày làm việc
        String ngayLamViec = "2024-04-06";

        // Thực hiện selectByCondition
        ArrayList<CaLamViecModel> result = CaLamViecDao.getInstance().selectByCondition(ngayLamViec);

        // Kiểm tra kết quả
        assert !result.isEmpty() : "SelectByCondition method should return a non-empty list";
    }

    @Test
    public void selectByCondition1Test() {
        // Đặt ID ca làm việc để tìm kiếm nhân viên
        String idCalam = "CL1";

        // Thực hiện selectByCondition1
        ArrayList<NhanVienModel> result = CaLamViecDao.getInstance().selectByCondition1(idCalam);

        // Kiểm tra kết quả
        assert !result.isEmpty() : "SelectByCondition1 method should return a non-empty list";
        System.out.println("Number of employees in shift " + idCalam + ": " + result.size());
        for (NhanVienModel nv : result) {
            System.out.println("Employee ID: " + nv.getIdCaLam() + ", Employee Name: " + nv.getTenNV());
        }
    }




    @Test
    public void selectByIdTestCaLamViecModel() {
        // Tạo ID cần tìm
        String IDCaLam = "CL1";

        // Thực hiện selectById
        CaLamViecModel result = CaLamViecDao.getInstance().selectById(new CaLamViecModel(IDCaLam, null, null, null));

        // Kiểm tra kết quả
        assert result != null : "SelectById method should return a non-null object";
    }



    @Test
    public void selectByIdTestString() {
        // Tạo ID cần tìm
        String IDCaLam = "CL1";

        // Thực hiện selectById
        CaLamViecModel result = CaLamViecDao.getInstance().selectById(new CaLamViecModel(IDCaLam, null, null, null));

        // Kiểm tra kết quả
        assert result != null : "SelectById method should return a non-null object";
    }


    @Test
    public void updateTest() {
        // Tạo đối tượng CaLamViecModel tương ứng
        CaLamViecModel caLamViec = new CaLamViecModel("CL3", "Ca B", "8h - 17h", "2024-04-06");

        // Thực hiện update
        int result = CaLamViecDao.getInstance().update(caLamViec);

        // Kiểm tra kết quả
        assert result == 1 : "Update method should return 1 if successful";
    }
}
