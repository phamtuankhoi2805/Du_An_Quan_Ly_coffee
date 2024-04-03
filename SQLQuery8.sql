SELECT TOP (1000) [IDNhanVien]
      ,[MatKhau]
      ,[TenNV]
      ,[NgaySinh]
      ,[GioiTinh]
      ,[SDT]
      ,[Email]
      ,[ChucVu]
      ,[TrangThai]
      ,[LuongCB]
      ,[IDCaLam]
  FROM [QLCafe].[dbo].[NHANVIEN]



-- Câu lệnh UPDATE để nối chuỗi giá trị IDCaLam
UPDATE NhanVien
SET IDCaLam = IDCaLam + ', ' + 'CL2'
WHERE IDNhanVien = 'NV002'