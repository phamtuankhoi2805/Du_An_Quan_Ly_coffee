


  SELECT NguyenLieu.IDNguyenLieu, NguyenLieu.TenNguyenLieu, NguyenLieu.SoLuongTon, 0 AS SoLuongNhap, NhaCungCap.TenNhaCC, NhaCungCap.SDT
FROM NguyenLieu
JOIN PhieuGiaoHangChiTiet ON NguyenLieu.IDNguyenLieu = PhieuGiaoHangChiTiet.IDNguyenLieu
JOIN PhieuGiaoHang ON PhieuGiaoHangChiTiet.IDPhieuGiao = PhieuGiaoHang.IDPhieuGiao
JOIN NhaCungCap ON PhieuGiaoHang.IDNhaCC = NhaCungCap.IDNhaCC;

select * from NGUYENLIEU
select * from PHIEUGIAOHANG
select * from PHIEUGIAOHANGCHITIET
select * from NHACUNGCAP
