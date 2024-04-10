CREATE DATABASE QLCafe
GO
USE QLCafe
GO
-- Bảng Nhân Viên
CREATE TABLE NHANVIEN(
IDNhanVien varchar(10) not null primary key,
MatKhau varchar(20),
TenNV nvarchar(50),
NgaySinh date,
GioiTinh bit,
SDT varchar(11),
Email nvarchar(30),
ChucVu nvarchar(20),
TrangThai nvarchar(20),
LuongCB money,
IDCaLam varchar(10) not null
)
GO
-- Bảng Ca Làm Việc
CREATE TABLE CALAMVIEC(
IDCaLam varchar(10) not null primary key,
TenCaLam nvarchar(20),
ThoiGian varchar(30),
Ngay varchar(30)
)
GO
-- Bảng Loại Nguyên Liệu
CREATE TABLE LOAINGUYENLIEU(
IDLoaiNguyenLieu nvarchar(20) not null primary key,
TenLoaiNguyenLieu nvarchar(20)
)
GO
--Bảng Nguyên Liệu
CREATE TABLE NGUYENLIEU(
IDNguyenLieu varchar(10) not null primary key,
TenNguyenLieu nvarchar(20),
SoLuongTon int,
DonViTinh nvarchar(20),
IDLoaiNguyenLieu varchar(10) not null
)
GO
-- Bảng Phiếu xuất hàng (Số lượng nguyên liệu lấy ra )
CREATE TABLE PHIEUXUATHANG(
IDPhieuXuat varchar(10) not null primary key,
SoLuongNLXuatRa int,
NgayXuat date,
IDNguyenLieu varchar(10) not null,
IDNhanVien varchar(10) not null
)
GO
--Bảng Đơn Hàng
CREATE TABLE DONHANG(
IDDonHang varchar(10) not null primary key,
TenDonHang varchar(20),
NgayMuaHang date,
IDNhanVien varchar(10) not null
)
GO
-- Bảng Sản Phẩm
CREATE TABLE SANPHAM(
IDSanPham varchar(10) not null primary key,
TenSP nvarchar(30),
GiaBan money,
Hinh varchar(50),
TrangThai nvarchar(50)
)
GO
-- Bảng Số Lượng Mua (Số lượng mua của các sản phẩm trong đơn hàng)
CREATE TABLE CHITIETDONHANG(
IDSanPham varchar(10) not null,
IDDonHang varchar(10) not null,
SoLuongMua int,
IDHoaDon varchar(10), 
primary key(IDSanPham,IDDonHang)

)
ALTER TABLE ChiTietDonHang
ADD IDHoaDon varchar(10),
ADD CONSTRAINT FK_ChiTietDonHang_HoaDon
FOREIGN KEY (IDHoaDon) REFERENCES HoaDon(IDHoaDon);
-- Bảng Hoá Đơn
CREATE TABLE HOADON(
IDHoaDon varchar(10) not null primary key,
DonGia float,
SoLuong int,
TongTien float,	
Giam float,
ThanhTien float,
ThoiGianMua date,
IDSanPham varchar(10) not null,
IDDonHang varchar(10) not null,
IDKhuyenMai varchar(10)
)
GO
-- Bảng Khuyến Mãi
CREATE TABLE KHUYENMAI(
IDKhuyenMai varchar(10) not null primary key,
LoaiKM float,
DieuKienKM nvarchar(50)
)
GO
-- Bảng Nhà Cung Cấp
CREATE TABLE NHACUNGCAP(
IDNhaCC varchar(10) not null primary key,
TenNhaCC nvarchar(30),
DiaChi nvarchar(125),
SDT varchar(11)
)
GO
-- Bảng Phiếu Giao Hàng
CREATE TABLE PHIEUGIAOHANG(
IDPhieuGiao varchar(10) not null primary key,
NgayGiaoHang date,
TongTienGiaoHang money,
IDNhaCC varchar(10) not null
)
GO
-- Bảng Phiếu Giao Hàng Chi Tiết
CREATE TABLE PHIEUGIAOHANGCHITIET(
IDNguyenLieu varchar(10) not null,
IDPhieuGiao varchar(10) not null,
SoLuongNLGiao int,
DonGiaNL money,
primary key(IDNguyenLieu,IDPhieuGiao)
)
GO
-- Bảng Phiếu đặt hàng
CREATE TABLE PHIEUDATHANG(
IDPhieuDatHang varchar(10) not null primary key,
NgayDatHang date,
IDNhaCC varchar(10),
IDNhanVien varchar(10)
)
GO
--Bảng Phiếu đặt hàng chi tiết
CREATE TABLE PHIEUDATHANGCHITIET(
IDPhieuDatHang varchar(10) not null,
IDNguyenLieu varchar(10) not null,
SoLuongDat int,
primary key(IDPhieuDatHang,IDNguyenLieu)
)
GO
-- Tạo khoá ngoại Bảng Nhân Viên
ALTER TABLE NHANVIEN
ADD CONSTRAINT FK_NhanVien_CaLam FOREIGN KEY (IDCaLam) REFERENCES CALAMVIEC(IDCaLam)
GO
-- Tạo khoá ngoại Bảng Đơn Hàng
ALTER TABLE DONHANG
ADD CONSTRAINT FK_DonHang_NhanVien FOREIGN KEY (IDNhanVien) REFERENCES NHANVIEN(IDNhanVien)
GO
-- Tạo khoá ngoại Chi tiết đơn hàng
ALTER TABLE CHITIETDONHANG
ADD CONSTRAINT FK_ChiTietDH_SanPham FOREIGN KEY (IDSanPham) REFERENCES SANPHAM(IDSanPham),
	CONSTRAINT FK_ChiTietDH_DonHang FOREIGN KEY (IDDonHang) REFERENCES DONHANG(IDDonHang)
GO
-- Tạo khoá ngoại Hoá Đơn
ALTER TABLE HOADON
ADD CONSTRAINT FK_HoaDon_SanPham FOREIGN KEY (IDSanPham) REFERENCES SANPHAM(IDSanPham),
	CONSTRAINT FK_HoaDon_DonHang FOREIGN KEY (IDDonHang) REFERENCES DONHANG(IDDonHang),
	CONSTRAINT FK_HoaDon_KhuyenMai FOREIGN KEY (IDKhuyenMai) REFERENCES KHUYENMAI(IDKhuyenMai)
GO
-- Tạo khoá ngoại Bảng Nguyên Liệu
ALTER TABLE NGUYENLIEU
ADD CONSTRAINT FK_NguyenLieu_LoaiNguyenLieu FOREIGN KEY (IDLoaiNguyenLieu) REFERENCES LOAINGUYENLIEU(IDLoaiNguyenLieu)
GO
-- Tạo khoá ngoại Phiếu Xuất Hàng
ALTER TABLE PHIEUXUATHANG
ADD CONSTRAINT FK_PhieuXuat_NhanVien FOREIGN KEY (IDNhanVien) REFERENCES NHANVIEN(IDNhanVien),
	CONSTRAINT FK_PhieuXuat_NguyenLieu FOREIGN KEY (IDNguyenLieu) REFERENCES NGUYENLIEU(IDNguyenLieu)
GO
-- Tạo khoá ngoại Bảng Phiếu Giao Hàng
ALTER TABLE PHIEUGIAOHANG
ADD CONSTRAINT FK_PhieuGH_NhaCC FOREIGN KEY (IDNhaCC) REFERENCES NHACUNGCAP(IDNhaCC)
GO
-- Tạo khoá ngoại Phiếu Giao Hàng Chi Tiết
ALTER TABLE PHIEUGIAOHANGCHITIET
ADD CONSTRAINT FK_PhieuGHCT_NguyenLieu FOREIGN KEY (IDNguyenLieu) REFERENCES NGUYENLIEU(IDNguyenLieu),
	CONSTRAINT FK_PhieuGHCT_PhieuGH FOREIGN KEY (IDPhieuGiao) REFERENCES PHIEUGIAOHANG(IDPhieuGiao)
GO
-- Tạo khoá ngoại Phiếu Đặt Hàng
ALTER TABLE PHIEUDATHANG
ADD CONSTRAINT FK_PhieuDH_NhaCC FOREIGN KEY (IDNhaCC) REFERENCES NHACUNGCAP(IDNhaCC),
	CONSTRAINT FK_PhieuDH_NhanVien FOREIGN KEY (IDNhanVien) REFERENCES NHANVIEN(IDNhanVien)
GO
-- Tạo khoá ngoại Phiếu Đặt Hàng Chi Tiết
ALTER TABLE PHIEUDATHANGCHITIET
ADD CONSTRAINT FK_PhieuDHCT_PhieuDH FOREIGN KEY (IDPhieuDatHang) REFERENCES PHIEUDATHANG(IDPhieuDatHang),
	CONSTRAINT FK_PhieuDHCT_NguyenLieu FOREIGN KEY (IDNguyenLieu) REFERENCES NGUYENLIEU(IDNguyenLieu)
GO
-- Trigger update số lượng tồn trong bảng nguyên liệu (SoLuongTon = SoLuongTon + SoLuongNLGiao)
CREATE OR ALTER TRIGGER Update_SoLuongTon
ON PHIEUGIAOHANGCHITIET
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Update SoLuongTon trong bảng NGUYENLIEU
    UPDATE NGUYENLIEU
    SET SoLuongTon = NGUYENLIEU.SoLuongTon + inserted.SoLuongNLGiao
    FROM NGUYENLIEU
    INNER JOIN inserted ON NGUYENLIEU.IDNguyenLieu = inserted.IDNguyenLieu;
END
GO
-- Trigger update số lượng tồn trong bảng nguyên liệu (SoLuongTon = SoLuongTon - SoLuongNLXuatRa)
CREATE OR ALTER TRIGGER Update_SoLuongTon_SLNL
ON PHIEUXUATHANG
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;
    
    -- Update SoLuongTon trong bảng NGUYENLIEU
    UPDATE NGUYENLIEU
    SET SoLuongTon = NGUYENLIEU.SoLuongTon - inserted.SoLuongNLXuatRa
    FROM NGUYENLIEU
    INNER JOIN inserted ON NGUYENLIEU.IDNguyenLieu = inserted.IDNguyenLieu;
END
GO
-- Procedure thống kê doanh thu theo tháng
--Lệnh chạy: EXEC ThongKeDoanhThuTheoThang
CREATE PROCEDURE ThongKeDoanhThuTheoThang
AS
BEGIN
    SELECT 
        MONTH(ThoiGianMua) AS Thang,
        YEAR(NgayLapHD) AS Nam,
        SUM(ThanhTien) AS DoanhThu
    FROM HOADON
    GROUP BY YEAR(ThoiGianMua), MONTH(ThoiGianMua)
    ORDER BY Nam, Thang;
END
GO
CREATE OR ALTER  PROCEDURE ThongKeDoanhThuTheoThang
AS
BEGIN
    SELECT 
        MONTH(ThoiGianMua) AS Thang,
        YEAR(ThoiGianMua) AS Nam,
        SUM(ThanhTien) AS DoanhThu,
        COUNT(*) AS TongDonHang
    FROM HOADON
    GROUP BY YEAR(ThoiGianMua), MONTH(ThoiGianMua)
    ORDER BY Nam, Thang;
END
GO
--chay EXEC DemTongDonTheoThang;

--Procedure thống kê doanh thu theo năm
--Lệnh chạy: EXEC ThongKeDoanhThuTheoNam
CREATE PROCEDURE ThongKeDoanhThuTheoNam
AS
BEGIN
    SELECT 
        YEAR(ThoiGianMua) AS Nam,
        SUM(ThanhTien) AS DoanhThu
    FROM HOADON
    GROUP BY YEAR(ThoiGianMua)
    ORDER BY Nam;
END
GO


-- Chèn dữ liệu vào bảng CALAMVIEC
INSERT INTO CALAMVIEC (IDCaLam, TenCaLam, ThoiGian, Ngay)
VALUES 
('CL001', N'Ca sáng', '08:00 - 12:59','2023-01-01'),
('CL002', N'Ca chiều', '13:00 - 17:59','2023-01-01'),
('CL003', N'Ca tối', '18:00 - 21:59','2023-01-01'),
('CL004', N'Ca đêm', '22:00 - 7:59','2023-01-01'),
('CL005', N'Ca linh hoạt', NULL,'2023-01-01')
GO
-- Chèn dữ liệu vào bảng NHANVIEN
INSERT INTO NHANVIEN (IDNhanVien, MatKhau, TenNV, NgaySinh, GioiTinh, SDT, Email, ChucVu, TrangThai, LuongCB, IDCaLam)
VALUES 
('NV001', 'quanly', N'Trần Văn A', '1990-05-15', 1, '0987654321', 'avt@gmail.com', N'Quản lý', N'Đang làm việc', 100000, 'CL001'),
('NV002', 'nhanvien', N'Nguyễn Thị B', '1995-10-20', 0, '0123456789', 'bnt@gmail.com', N'Nhân viên', N'Đang làm việc', 20000, 'CL002'),
('NV003', 'nhanvien', N'Lê Văn C', '1988-12-10', 1, '0999999999', 'clv@gmail.com', N'Nhân viên', N'Đang làm việc', 20000, 'CL003'),
('NV004', 'nhanvien', N'Hồ Thị D', '1992-04-25', 0, '0977777777', 'dht@gmail.com', N'Nhân viên', N'Đang làm việc', 20000, 'CL001'),
('NV005', 'nhanvien', N'Phạm Văn E', '1997-09-30', 1, '0966666666', 'epv@gmail.com', N'Nhân viên', N'Đang làm việc', 20000, 'CL002')
GO

-- Chèn dữ liệu vào bảng LOAINGUYENLIEU
INSERT INTO LOAINGUYENLIEU (IDLoaiNguyenLieu, TenLoaiNguyenLieu)
VALUES 
('NL001', N'Nguyên liệu thô'),
('NL002', N'Đồ uống'),
('NL003', N'Dinh dưỡng'),
('NL004', N'Vật liệu bao bì'),
('NL005', N'Phụ gia')
GO
-- Chèn dữ liệu vào bảng NGUYENLIEU
INSERT INTO NGUYENLIEU (IDNguyenLieu, TenNguyenLieu, SoLuongTon, IDLoaiNguyenLieu)
VALUES 
('NL001', N'Ca cao', 100, 'NL002'),
('NL002', N'Cam', 50, 'NL001'),
('NL003', N'Dưa hấu', 200, 'NL001'),
('NL004', N'Nước khoáng', 300, 'NL003'),
('NL005', N'Ly nhựa', 150, 'NL004')
GO
-- Chèn dữ liệu vào bảng SANPHAM
INSERT INTO SANPHAM (IDSanPham, TenSP, GiaBan, Hinh)
VALUES 
('SP001', N'Cà phê đen', 25000, NULL),
('SP002', N'Cà phê sữa', 30000, NULL),
('SP003', N'Nước ngọt lon', 15000, NULL),
('SP004', N'Nước suối', 10000, NULL),
('SP005', N'Sinh tố trái cây', 35000, NULL)
GO
-- Chèn dữ liệu vào bảng Phiếu xuất hàng
INSERT INTO PHIEUXUATHANG(IDPhieuXuat, SoLuongNLXuatRa, NgayXuat, IDNguyenLieu, IDNhanVien)
VALUES 
('PX001',10, '2023-01-01', 'NL001','NV001'),
('PX002',20, '2023-01-01', 'NL002','NV001'),
('PX003',15, '2023-03-01', 'NL001','NV002'),
('PX004',10, '2023-04-01', 'NL003','NV002'),
('PX005',10, '2023-05-01', 'NL004','NV003')
GO
-- Chèn dữ liệu vào bảng DONHANG
INSERT INTO DONHANG (IDDonHang, TenDonHang, NgayMuaHang, IDNhanVien)
VALUES 
('DH001', N'Đơn hàng 1', '2024-01-02', 'NV001'),
('DH002', N'Đơn hàng 2', '2024-01-03', 'NV002'),
('DH003', N'Đơn hàng 3', '2024-01-04', 'NV003'),
('DH004', N'Đơn hàng 4', '2024-01-05', 'NV004'),
('DH005', N'Đơn hàng 5', '2024-02-01', 'NV005'),

('DH006', N'Đơn hàng 6', '2024-02-02', 'NV005'),
('DH007', N'Đơn hàng 7', '2024-02-03', 'NV005'),
('DH008', N'Đơn hàng 8', '2024-02-04', 'NV005'),
('DH009', N'Đơn hàng 9', '2024-03-01', 'NV005'),
('DH010', N'Đơn hàng 10', '2024-03-02', 'NV001'),
('DH011', N'Đơn hàng 11', '2024-03-03', 'NV001'),
('DH012', N'Đơn hàng 12', '2024-03-04', 'NV001'),
('DH013', N'Đơn hàng 13', '2024-03-05', 'NV003'),
('DH014', N'Đơn hàng 14', '2024-04-01', 'NV003'),
('DH015', N'Đơn hàng 15', '2024-04-02', 'NV003'),
('DH016', N'Đơn hàng 16', '2024-04-03', 'NV004'),
('DH017', N'Đơn hàng 17', '2024-04-04', 'NV004'),
('DH018', N'Đơn hàng 18', '2024-05-01', 'NV004'),
('DH019', N'Đơn hàng 19', '2024-05-02', 'NV002'),
('DH020', N'Đơn hàng 20', '2024-05-03', 'NV002')
GO



-- Chèn dữ liệu vào bảng CHITIETDONHANG
INSERT INTO CHITIETDONHANG (IDSanPham, IDDonHang, SoLuongMua, IDHoaDon)
VALUES 
('SP001', 'DH001', 3),
('SP002', 'DH002', 2),
('SP002', 'DH003', 1),
('SP003', 'DH004', 5),
('SP004', 'DH005', 1),
('SP003', 'DH005', 1),
('SP001', 'DH005', 1),
('SP002', 'DH006', 5),
('SP002', 'DH007', 1),
('SP004', 'DH007', 1),
('SP003', 'DH007', 1),
('SP003', 'DH008', 1),
('SP001', 'DH009', 2),
('SP003', 'DH010', 1),
('SP003', 'DH011', 1),
('SP005', 'DH011', 1),
('SP003', 'DH012', 2),
('SP003', 'DH013', 1),
('SP002', 'DH014', 1),
('SP003', 'DH015', 1),
('SP004', 'DH016', 1),
('SP001', 'DH017', 1),
('SP002', 'DH018', 1),
('SP003', 'DH019', 1),
('SP005', 'DH020', 1)
GO
-- Chèn dữ liệu vào bảng KHUYENMAI
INSERT INTO KHUYENMAI (IDKhuyenMai, LoaiKM,DieuKienKM)
VALUES 
('KM001', 0.1, N'Trên đơn hàng có giá trị từ 100.000 đồng trở lên'),
('KM002', 0.2, N'Trên đơn hàng có giá trị từ 300.000 đồng trở lên'),
('KM003', 0.3, N'Trên đơn hàng có giá trị từ 500.000 đồng trở lên'),
('KM004', 0.4 , N'Trên đơn hàng có giá trị từ 1.000.000 đồng trở lên')
GO
-- Chèn dữ liệu vào bảng HOADON
INSERT INTO HOADON (IDHoaDon, DonGia, TongTien, Giam, ThanhTien, ThoiGianMua, IDSanPham, IDDonHang, IDKhuyenMai)
VALUES 
('HD001', 25000, 75000, 0, 75000, '2024-03-01', 'SP001', 'DH001', NULL),
('HD002', 30000, 60000, 0, 60000, '2024-03-01', 'SP002', 'DH002', NULL),
('HD003', 15000, 15000, 0, 15000, '2024-03-01', 'SP003', 'DH003', NULL),
('HD004', 10000, 50000, 0, 50000, '2024-03-01', 'SP004', 'DH004', NULL),
('HD005', 10000, 10000, 0, 10000, '2024-03-01', 'SP004', 'DH005', 'KM001'),

('HD006', 15000, 15000, 0, 15000, '2024-03-01', 'SP003', 'DH005', NULL),
('HD007', 25000, 25000, 0, 25000, '2024-03-01', 'SP001', 'DH005', NULL),
('HD008', 30000, 150000, 15000, 135000, '2024-03-01', 'SP002', 'DH006', 'KM001'),
('HD009', 30000, 30000, 0, 30000, '2024-03-01', 'SP002', 'DH007', NULL),
('HD010', 10000, 10000, 0, 10000, '2024-03-01', 'SP004', 'DH007', NULL),
('HD011', 15000, 15000, 0, 15000, '2024-03-01', 'SP003', 'DH007', NULL),
('HD012', 15000, 15000, 0, 15000, '2024-03-01', 'SP003', 'DH008', NULL),
('HD013', 25000, 50000, 0, 50000, '2024-03-01', 'SP001', 'DH009', NULL),
('HD014', 15000, 15000, 0, 15000, '2024-03-01', 'SP003', 'DH010', NULL),
('HD015', 15000, 15000, 0, 15000, '2024-03-01', 'SP003', 'DH011', NULL),
('HD016', 35000, 35000, 0, 35000, '2024-03-01', 'SP005', 'DH011', NULL),
('HD017', 15000, 30000, 0, 30000, '2024-03-01', 'SP003', 'DH012', NULL),
('HD018', 15000, 15000, 0, 15000, '2024-03-01', 'SP003', 'DH013', NULL),
('HD019', 30000, 30000, 0, 30000, '2024-03-01', 'SP002', 'DH014', NULL),
('HD020', 15000, 15000, 0, 15000, '2024-03-01', 'SP003', 'DH015', NULL),
('HD021', 10000, 10000, 0, 10000, '2024-03-01', 'SP004', 'DH016', NULL),
('HD022', 25000, 25000, 0, 25000, '2024-03-01', 'SP001', 'DH017', NULL),
('HD023', 30000, 30000, 0, 30000, '2024-03-01', 'SP002', 'DH018', NULL),
('HD024', 15000, 15000, 0, 15000, '2024-03-01', 'SP003', 'DH019', NULL),
('HD025', 35000, 35000, 0, 35000, '2024-03-01', 'SP005', 'DH020', NULL)
GO

INSERT INTO [QLCafe].[dbo].[HOADON] ([IDHoaDon], [DonGia], [SoLuong], [TongTien], [Giam], [ThanhTien], [ThoiGianMua], [IDSanPham], [IDDonHang], [IDKhuyenMai])
VALUES
  ('HD026', 25000, 2, 75000, 0, 75000, '2024-01-01', 'SP001', 'DH001', NULL),
  ('HD027', 30000, 2, 60000, 0, 60000, '2024-01-01', 'SP002', 'DH002', NULL),
  ('HD028', 15000, 2, 15000, 0, 15000, '2024-01-01', 'SP003', 'DH003', NULL),
  ('HD029', 10000, 2, 50000, 0, 50000, '2024-01-01', 'SP004', 'DH004', NULL),
  ('HD030', 10000, 1, 10000, 0, 10000, '2024-02-01', 'SP004', 'DH005', 'KM001'),
  ('HD031', 15000, 2, 15000, 0, 15000, '2024-02-01', 'SP003', 'DH005', NULL),
  ('HD032', 25000, 3, 25000, 0, 25000, '2024-02-01', 'SP001', 'DH005', NULL),
  ('HD033', 30000, 2, 150000, 15000, 135000, '2024-02-01', 'SP002', 'DH006', 'KM001'),
  ('HD034', 30000, 4, 30000, 0, 30000, '2024-02-01', 'SP002', 'DH007', NULL),
  ('HD035', 10000, 5, 10000, 0, 10000, '2024-02-01', 'SP004', 'DH007', NULL),
  ('HD036', 15000, 1, 15000, 0, 15000, '2024-02-01', 'SP003', 'DH007', NULL),
  ('HD037', 15000, 2, 15000, 0, 15000, '2024-02-01', 'SP003', 'DH008', NULL),
  ('HD038', 25000, 3, 50000, 0, 50000, '2024-02-01', 'SP001', 'DH009', NULL),
  ('HD039', 15000, 2, 15000, 0, 15000, '2024-02-01', 'SP003', 'DH010', NULL),
  ('HD040', 15000, 5, 15000, 0, 15000, '2024-02-01', 'SP003', 'DH011', NULL),
  ('HD041', 35000, 2, 35000, 0, 35000, '2024-02-01', 'SP005', 'DH011', NULL),
  ('HD042', 15000, 7, 30000, 0, 30000, '2024-02-01', 'SP003', 'DH012', NULL),
  ('HD043', 15000, 8, 15000, 0, 15000, '2024-02-01', 'SP003', 'DH013', NULL),
  ('HD044', 30000, 1, 30000, 0, 30000, '2024-02-01', 'SP002', 'DH014', NULL),
  ('HD045', 15000, 2, 15000, 0, 15000, '2024-02-01', 'SP003', 'DH015', NULL),
  ('HD046', 10000, 3, 10000, 0, 10000, '2024-02-01', 'SP004', 'DH016', NULL),
  ('HD047', 25000, 4, 25000, 0, 25000, '2024-02-01', 'SP001', 'DH017', NULL),
  ('HD048', 30000, 5, 30000, 0, 30000, '2024-02-01', 'SP002', 'DH018', NULL),
  ('HD049', 15000, 2, 15000, 0, 15000, '2024-02-01', 'SP003', 'DH019', NULL),
  ('HD050', 35000, 1, 35000, 0, 35000, '2024-02-01', 'SP005', 'DH020', NULL);
  INSERT INTO [QLCafe].[dbo].[HOADON] ([IDHoaDon], [DonGia], [SoLuong], [TongTien], [Giam], [ThanhTien], [ThoiGianMua], [IDSanPham], [IDDonHang], [IDKhuyenMai])
VALUES
  ('HD051', 25000, 2, 75000, 0, 75000, '2023-01-01', 'SP001', 'DH001', NULL),
  ('HD052', 30000, 2, 60000, 0, 60000, '2023-01-01', 'SP002', 'DH002', NULL),
  ('HD053', 15000, 2, 15000, 0, 15000, '2023-01-01', 'SP003', 'DH003', NULL),
  ('HD054', 10000, 2, 50000, 0, 50000, '2023-01-01', 'SP004', 'DH004', NULL);

  INSERT INTO [QLCafe].[dbo].[HOADON] ([IDHoaDon], [DonGia], [SoLuong], [TongTien], [Giam], [ThanhTien], [ThoiGianMua], [IDSanPham], [IDDonHang], [IDKhuyenMai])
VALUES
  ('HD055', 10000, 1, 10000, 0, 10000, '2023-02-01', 'SP004', 'DH005', NULL),
  ('HD056', 15000, 2, 15000, 0, 15000, '2023-02-01', 'SP003', 'DH005', NULL),
  ('HD057', 25000, 3, 25000, 0, 25000, '2023-02-01', 'SP001', 'DH005', NULL),
  ('HD058', 30000, 2, 150000, 15000, 135000, '2023-02-01', 'SP002', 'DH006', 'KM001'),
  ('HD059', 30000, 4, 30000, 0, 30000, '2023-02-01', 'SP002', 'DH007', NULL),
  ('HD060', 10000, 5, 10000, 0, 10000, '2023-02-01', 'SP004', 'DH007', NULL),
  ('HD061', 15000, 1, 15000, 0, 15000, '2023-02-01', 'SP003', 'DH007', NULL),
  ('HD062', 15000, 2, 15000, 0, 15000, '2023-02-01', 'SP003', 'DH008', NULL),
  ('HD063', 25000, 3, 50000, 0, 50000, '2023-02-01', 'SP001', 'DH009', NULL),
  ('HD064', 15000, 2, 15000, 0, 15000, '2023-02-01', 'SP003', 'DH010', NULL),
  ('HD065', 15000, 5, 15000, 0, 15000, '2023-02-01', 'SP003', 'DH011', NULL),
  ('HD066', 35000, 2, 35000, 0, 35000, '2023-02-01', 'SP005', 'DH011', NULL),
  ('HD067', 15000, 7, 30000, 0, 30000, '2023-02-01', 'SP003', 'DH012', NULL),
  ('HD068', 15000, 8, 15000, 0, 15000, '2023-02-01', 'SP003', 'DH013', NULL),
  ('HD069', 30000, 1, 30000, 0, 30000, '2023-02-01', 'SP002', 'DH014', NULL),
  ('HD070', 15000, 2, 15000, 0, 15000, '2023-02-01', 'SP003', 'DH015', NULL),
  ('HD071', 10000, 3, 10000, 0, 10000, '2023-02-01', 'SP004', 'DH016', NULL),
  ('HD072', 25000, 4, 25000, 0, 25000, '2023-02-01', 'SP001', 'DH017', NULL),
  ('HD073', 30000, 5, 30000, 0, 30000, '2023-02-01', 'SP002', 'DH018', NULL),
  ('HD074', 15000, 2, 15000, 0, 15000, '2023-02-01', 'SP003', 'DH019', NULL),
  ('HD075', 35000, 1, 35000, 0, 35000, '2023-02-01', 'SP005', 'DH020', NULL);

  INSERT INTO [QLCafe].[dbo].[HOADON] ([IDHoaDon], [DonGia], [SoLuong], [TongTien], [Giam], [ThanhTien], [ThoiGianMua], [IDSanPham], [IDDonHang], [IDKhuyenMai])
VALUES
  ('HD076', 15000, 2, 30000, 0, 30000, '2023-03-01', 'SP003', 'DH021', NULL),
  ('HD077', 25000, 3, 25000, 0, 25000, '2023-03-01', 'SP001', 'DH021', NULL),
  ('HD078', 30000, 2, 60000, 0, 60000, '2023-03-01', 'SP002', 'DH021', NULL),
  ('HD079', 15000, 1, 15000, 0, 15000, '2023-03-01', 'SP003', 'DH022', NULL),
  ('HD080', 35000, 2, 35000, 0, 35000, '2023-03-01', 'SP005', 'DH022', NULL),
  ('HD081', 30000, 4, 30000, 0, 30000, '2023-03-01', 'SP002', 'DH023', NULL),
  ('HD082', 15000, 2, 15000, 0, 15000, '2023-03-01', 'SP003', 'DH023', NULL),
  ('HD083', 15000, 3, 45000, 0, 45000, '2023-03-01', 'SP003', 'DH024', NULL),
  ('HD084', 25000, 2, 25000, 0, 25000, '2023-03-01', 'SP001', 'DH025', NULL),
  ('HD085', 10000, 5, 50000, 0, 50000, '2023-03-01', 'SP004', 'DH026', NULL),
  ('HD086', 15000, 2, 30000, 0, 30000, '2023-03-01', 'SP003', 'DH026', NULL),
  ('HD087', 30000, 1, 30000, 0, 30000, '2023-03-01', 'SP002', 'DH027', NULL),
  ('HD088', 15000, 4, 60000, 0, 60000, '2023-03-01', 'SP003', 'DH027', NULL),
  ('HD089', 35000, 2, 70000, 0, 70000, '2023-03-01', 'SP005', 'DH028', NULL),
  ('HD090', 25000, 1, 25000, 0, 25000, '2023-03-01', 'SP001', 'DH028', NULL),
  ('HD091', 30000, 3, 90000, 0, 90000, '2023-03-01', 'SP002', 'DH028', NULL),
  ('HD092', 15000, 2, 15000, 0, 15000, '2023-03-01', 'SP003', 'DH028', NULL),
  ('HD093', 15000, 5, 15000, 0, 15000, '2023-03-01', 'SP003', 'DH029', NULL),
  ('HD094', 10000, 2, 20000, 0, 20000, '2023-03-01', 'SP004', 'DH029', NULL),
  ('HD095', 15000, 2, 15000, 0, 15000, '2023-03-01', 'SP003', 'DH030', NULL),
  ('HD096', 25000, 3, 25000, 0, 25000, '2023-03-01', 'SP001', 'DH030', NULL);

-- Chèn dữ liệu vào bảng NHACUNGCAP
INSERT INTO NHACUNGCAP (IDNhaCC, TenNhaCC, DiaChi, SDT)
VALUES 
('NCC001', N'Nhà cung cấp 1', N'123 Đường ABC, Quận 1, TP.HCM', '0987654321'),
('NCC002', N'Nhà cung cấp 2', N'456 Đường XYZ, Quận 2, TP.HCM', '0123456789'),
('NCC003', N'Nhà cung cấp 3', N'789 Đường DEF, Quận 3, TP.HCM', '0999999999'),
('NCC004', N'Nhà cung cấp 4', N'1011 Đường GHI, Quận 4, TP.HCM', '0977777777'),
('NCC005', N'Nhà cung cấp 5', N'1213 Đường JKL, Quận 5, TP.HCM', '0966666666')
GO
-- Chèn dữ liệu vào bảng PHIEUGIAOHANG
INSERT INTO PHIEUGIAOHANG (IDPhieuGiao, NgayGiaoHang, TongTienGiaoHang, IDNhaCC)
VALUES 
('PGH001', '2024-03-01', 200000, 'NCC001'),
('PGH002', '2024-03-01', 50000, 'NCC002'),
('PGH003', '2024-03-01', 240000, 'NCC003'),
('PGH004', '2024-03-01', 750000, 'NCC004' ),
('PGH005', '2024-03-01', 400000, 'NCC005')
GO
-- Chèn dữ liệu vào bảng PHIEUGIAOHANGCHITIET
INSERT INTO PHIEUGIAOHANGCHITIET (IDNguyenLieu, IDPhieuGiao, SoLuongNLGiao, DonGiaNL)
VALUES 
('NL001', 'PGH001', 10, 20000),
('NL002', 'PGH002', 5, 10000),
('NL003', 'PGH003', 8, 30000),
('NL004', 'PGH004', 15, 50000),
('NL005', 'PGH005', 20, 20000)
GO
-- Chèn dữ liệu vào bảng PHIEUDATHANG
INSERT INTO PHIEUDATHANG (IDPhieuDatHang, NgayDatHang, IDNhaCC, IDNhanVien)
VALUES 
('PDH001', '2024-03-02', 'NCC001', 'NV001'),
('PDH002', '2024-03-03', 'NCC002', 'NV002'),
('PDH003', '2024-03-04', 'NCC003', 'NV003'),
('PDH004', '2024-03-05', 'NCC004', 'NV004'),
('PDH005', '2024-03-06', 'NCC005', 'NV005');
GO
-- Chèn dữ liệu vào bảng PHIEUDATHANGCHITIET
INSERT INTO PHIEUDATHANGCHITIET (IDPhieuDatHang, IDNguyenLieu, SoLuongDat)
VALUES 
('PDH001', 'NL001', 20),
('PDH001', 'NL002', 15),
('PDH002', 'NL003', 25),
('PDH003', 'NL004', 30),
('PDH004', 'NL005', 35),
('PDH005', 'NL001', 40);
GO

