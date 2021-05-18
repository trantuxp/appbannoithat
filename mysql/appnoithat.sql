-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 18, 2021 lúc 09:08 AM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `appnoithat`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdh`
--

CREATE TABLE `chitietdh` (
  `iddh` int(11) NOT NULL,
  `idsp` int(11) NOT NULL,
  `tensanpham` varchar(500) DEFAULT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitietdh`
--

INSERT INTO `chitietdh` (`iddh`, `idsp`, `tensanpham`, `soluong`, `dongia`) VALUES
(1, 11, NULL, 1, 21000000),
(2, 7, NULL, 2, 60000000),
(2, 10, NULL, 1, 850000),
(3, 7, NULL, 3, 90000000),
(3, 10, NULL, 1, 850000),
(4, 2, NULL, 1, 6000000),
(4, 7, NULL, 1, 30000000),
(5, 10, NULL, 1, 850000),
(6, 10, NULL, 1, 850000),
(7, 12, NULL, 2, 20000000),
(8, 11, NULL, 1, 21000000),
(9, 10, NULL, 1, 850000),
(10, 11, NULL, 1, 21000000),
(12, 12, NULL, 1, 10000000),
(13, 7, NULL, 1, 30000000),
(13, 8, NULL, 1, 68000000),
(13, 9, NULL, 1, 22000000),
(13, 10, NULL, 1, 850000),
(13, 11, NULL, 3, 63000000),
(13, 12, NULL, 1, 10000000),
(14, 11, NULL, 1, 21000000),
(15, 11, NULL, 1, 21000000),
(16, 11, NULL, 1, 21000000),
(17, 10, NULL, 1, 850000),
(18, 26, NULL, 1, 17000000),
(18, 27, NULL, 1, 11000000),
(19, 26, NULL, 1, 17000000),
(5, 2, 'Ghe', 1, 6900000),
(5, 3, 'Ghe', 1, 6900000),
(37, 3, '', 5, 699000),
(37, 3, 'ghe', 5, 699000),
(37, 3, 'ghe', 5, 699000),
(37, 28, 'Ghế có tay Porto', 1, 8500000),
(37, 28, 'Ghế có tay Porto', 1, 8500000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cuahang`
--

CREATE TABLE `cuahang` (
  `tenshop` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `anh` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioithieu` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `giatri` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tamnhin` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `sumenh` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `cuahang`
--

INSERT INTO `cuahang` (`tenshop`, `anh`, `gioithieu`, `giatri`, `tamnhin`, `sumenh`) VALUES
('QTT Shop', 'about.jpg', '<p>QTT shop l&agrave; thương hiệu mới, chuy&ecirc;n kinh doanh c&aacute;c sản phẩm Nội thất nhập khẩu từ Ch&acirc;u &Acirc;u, Ch&acirc;u &Aacute; v&agrave; c&aacute;c sản phẩm do c&ocirc;ng ty QTT sản xuất. Với chặng đường d&agrave;i ph&iacute;a trước, ch&uacute;ng t&ocirc;i chỉ ph&acirc;n phối sản phẩm ch&iacute;nh h&atilde;ng c&oacute; nguồn gốc, xuất xứ r&otilde; r&agrave;ng. V&igrave; vậy, kh&aacute;ch h&agrave;ng c&oacute; thể ho&agrave;n to&agrave;n y&ecirc;n t&acirc;m khi lựa chọn sản phẩm tại website www.QTTshop.com.vn QTT shop li&ecirc;n tục cập nhật v&agrave; bổ sung những d&ograve;ng sản phẩm c&oacute; xu hướng mới, c&ocirc;ng năng ti&ecirc;n tiến, g&oacute;p phần khẳng định đẳng cấp v&agrave; gi&aacute; trị cho ng&ocirc;i nh&agrave; của bạn, đem đến sự tiện nghi ho&agrave;n hảo trong từng kh&ocirc;ng gian sống. K&iacute;nh mời qu&yacute; kh&aacute;ch h&agrave;ng tới tham quan, mua sắm sản phẩm tại Hệ thống Showroom Nội thất Ho&agrave;n Mỹ tr&ecirc;n phạm vi to&agrave;n quốc!</p>\r\n', '<p>Với mong muốn ph&aacute;t triển thương hiệu Việt bằng nội lực, QTT shop đ&atilde; ch&uacute; trọng v&agrave;o thiết kế v&agrave; sản xuất nội thất trong nước. Danh mục sản phẩm của Nh&agrave; Xinh thường xuy&ecirc;n được đổi mới v&agrave; cập nhật, li&ecirc;n tục cung cấp cho kh&aacute;ch h&agrave;ng c&aacute;c d&ograve;ng sản phẩm theo xu hướng mới nhất. Do ch&iacute;nh người Việt thiết kế v&agrave; sản xuất, nội thất thương hiệu Nh&agrave; Xinh lu&ocirc;n ph&ugrave; hợp với cuộc sống &Aacute; Đ&ocirc;ng, đem đến sự tiện nghi ho&agrave;n hảo trong mọi kh&ocirc;ng gian sống.</p>\r\n', '<p>QTT shop sẽ hiện thực h&oacute;a những &yacute; tưởng, ước mơ của kh&aacute;ch h&agrave;ng v&agrave; mang đến cho kh&aacute;ch h&agrave;ng một kh&ocirc;ng gian sống với phong c&aacute;ch nội thất hiện đại, sang trọng, tiện nghi.</p>\r\n', '<p>Bằng ch&iacute;nh t&igrave;nh y&ecirc;u v&agrave; sự tr&acirc;n trọng, QTT shop lu&ocirc;n nổ lực kh&ocirc;ng ngừng để mang đến cho kh&aacute;ch h&agrave;ng những sản phẩm tốt nhất, k&egrave;m dịch vụ tận t&igrave;nh, chu đ&aacute;o nhất. Sự h&agrave;i l&ograve;ng của kh&aacute;ch h&agrave;ng l&agrave; niềm tự h&agrave;o của ch&uacute;ng t&ocirc;i.</p>\r\n');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhmuc`
--

CREATE TABLE `danhmuc` (
  `id` int(11) NOT NULL,
  `tendanhmuc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `anh` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngay` datetime NOT NULL DEFAULT current_timestamp(),
  `mota` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `danhmuc`
--

INSERT INTO `danhmuc` (`id`, `tendanhmuc`, `anh`, `ngay`, `mota`) VALUES
(1, 'Ghế', 'https://png.pngtree.com/png-clipart/20190920/original/pngtree-wooden-backrest-chair-png-image_4611298.jpg', '2020-12-21 00:00:00', '<h2>Mẫu ghế đẹp, cao cấp</h2>\r\n\r\n<p>Mẫu ghế đẹp hiện đại nhập khẩu cao cấp ph&ograve;ng ngủ l&agrave; sản phẩm kh&ocirc;ng thể thiếu trong bất cứ kh&ocirc;ng gian gia đ&igrave;nh n&agrave;o. Nhiều mẫu ghế đẹp nhập khẩu&nbsp;từ nhiều thương hiệu nổi tiếng Ch&acirc;u &Aacute;, Ch&acirc;u &Acirc;u,&nbsp;Italia (&Yacute;)&nbsp;mang lại sự đa dạng trong lựa chọn bền, đẹp v&agrave; chất lượng.</p>\r\n'),
(2, 'Bàn ăn', 'https://www.mdfuni.com/wp-content/uploads/2018/07/617.1.png', '2020-12-21 00:00:00', '<h2>Mẫu b&agrave;n ăn nh&agrave; bếp cao cấp</h2>\r\n\r\n<p>Mẫu b&agrave;n ăn nh&agrave; bếp đẹp nhập khẩu cao cấp, b&agrave;n ăn hiện đại sang trọng&nbsp;đến&nbsp;từ nhiều thương hiệu nổi tiếng Ch&acirc;u &Aacute;, Ch&acirc;u &Acirc;u,&nbsp;Italia (&Yacute;). Mua b&aacute;n nhiều mẫu b&agrave;n ăn đẹp hiện đại&nbsp;từ b&agrave;n chữ nhật, b&agrave;n bầu dục...c&oacute; kiểu d&aacute;ng sang trọng v&agrave; qu&yacute; ph&aacute;i, sử dụng chất liệu cao cấp cho kh&ocirc;ng gian ẩm thực gia đ&igrave;nh bạn th&ecirc;m trọn vẹn.</p>\r\n'),
(3, 'Giường ngủ', 'http://noithatchangson.vn/public/upload/products/2014/08/18/upload/19203be42ab60d4e88833fcf190e98ded9d1675e-14083352080217.jpg', '2020-12-21 00:00:00', '<h2>Mẫu giường ngủ đẹp, cao cấp</h2>\r\n\r\n<p>Nhiều mẫu giường ngủ đẹp nhập khẩu cao cấp hiện đại mang lại sự thoải m&aacute;i &ecirc;m &aacute;i, thả hết những mệt mỏi, buồn phiền&nbsp;từ nhiều thương hiệu nổi tiếng Ch&acirc;u &Aacute;, Ch&acirc;u &Acirc;u,&nbsp;Italia (&Yacute;).&nbsp;Mẫu giường ngủ cao cấp&nbsp;đồng h&agrave;nh c&ugrave;ng giấc ngủ của bạn với chất lượng nguồn h&agrave;ng đa dạng c&aacute;c kiểu giường ngủ mới v&agrave; uy t&iacute;n nhất.&nbsp;</p>\r\n'),
(4, 'Sofa', 'https://www.goxanh.vn/image/cache/data/go-xanh/hinh-anh-ghe-sofa-don-bang-dai-600x600.jpg', '2020-12-21 00:00:00', '<h2>Mẫu ghế sofa bộ cao cấp</h2>\r\n\r\n<p>Mẫu ghế Sofa bộ đẹp hiện đại nhập khẩu cao cấp&nbsp;từ nhiều thương hiệu nổi tiếng Ch&acirc;u &Aacute;, Ch&acirc;u &Acirc;u,&nbsp;Italia (&Yacute;). Ghế Sofa bộ hiện đại v&agrave; sang trọng trong từng sản phẩm đ&aacute;p ứng được mọi nhu cầu của kh&aacute;ch h&agrave;ng. Mang đến sự h&agrave;i l&ograve;ng cho kh&aacute;ch h&agrave;ng.</p>\r\n');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `idkhachhang` int(11) NOT NULL,
  `ngay` date NOT NULL,
  `tenuser` varchar(500) NOT NULL,
  `diachi` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `sodt` int(11) NOT NULL,
  `email` varchar(5000) NOT NULL,
  `loinhan` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tongsanpham` int(11) NOT NULL,
  `tongtien` double NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `idkhachhang`, `ngay`, `tenuser`, `diachi`, `sodt`, `email`, `loinhan`, `tongsanpham`, `tongtien`, `trangthai`) VALUES
(1, 2, '2020-12-22', '', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 18900000, 4),
(2, 2, '2020-12-23', '', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 3, 57765000, 3),
(3, 2, '2020-10-31', '', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 4, 87765000, 2),
(4, 2, '2020-11-01', '', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 2, 32400000, 4),
(5, 2, '2020-12-10', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 765000, 2),
(6, 2, '2020-12-22', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 765000, 1),
(7, 2, '2020-12-31', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 2, 19000000, 1),
(8, 2, '2020-12-31', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 18900000, 1),
(9, 2, '2020-12-31', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 765000, 1),
(10, 2, '2021-01-08', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 18900000, 1),
(11, 2, '2021-01-08', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 0, 0, 1),
(12, 2, '2021-01-09', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 9000000, 1),
(13, 2, '2021-01-10', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 8, 178665000, 1),
(14, 2, '2021-01-10', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 18900000, 1),
(15, 2, '2021-01-10', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 18900000, 1),
(16, 2, '2021-01-10', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 18900000, 1),
(17, 2, '2021-01-10', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 765000, 1),
(18, 2, '2021-01-14', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 2, 25200000, 1),
(19, 2, '2021-01-14', 'Trần Quốc Tú', '26 Huỳnh Văn Nghệ', 1264607869, 'tranxp34878@gmail.com', '', 1, 15300000, 1),
(34, 0, '0000-00-00', 'tu12', '', 2345678, 'tu@gamil.com', '', 0, 0, 0),
(35, 0, '0000-00-00', 'tu12', '', 2345678, 'tu@gamil.com', '', 0, 0, 0),
(36, 0, '0000-00-00', 'tuvip', '', 123, 'tu@gmail.com', '', 0, 0, 0),
(37, 0, '0000-00-00', 'tu', '', 123, 't@gamil.com', '', 0, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hanghoa`
--

CREATE TABLE `hanghoa` (
  `id` int(11) NOT NULL,
  `tenhang` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `soluong` int(11) NOT NULL,
  `dongia` double NOT NULL,
  `anh` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngay` date NOT NULL,
  `mota` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `iddanhmuc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `hanghoa`
--

INSERT INTO `hanghoa` (`id`, `tenhang`, `soluong`, `dongia`, `anh`, `ngay`, `mota`, `iddanhmuc`) VALUES
(1, 'Sofa Lovely 3 chỗ hiện đại vải xám', 99, 22000000, 'Sofa Lovely 3 chỗ hiện đại vải xám.jpg', '2020-12-21', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 4),
(2, 'Bàn ăn kính - BA020.007A1', 6, 6000000, 'https://www.nhaxinh.com/photo/6349/ghe_an_co_tay_porto.jpg', '2020-12-21', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 1),
(3, 'Giường bọc nỉ - GBN020.002A', 123, 17000000, 'g020.002a.1.jpg', '2020-12-21', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 3),
(4, 'Ghế ăn HC', 68, 3300000, 'https://www.nhaxinh.com/photo/3500/1000-san-pham-nha-xinh(34-1).jpg', '2020-12-21', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 1),
(5, 'Bàn ăn gỗ - BA020.001B2', 15, 4800000, 'https://www.nhaxinh.com/photo/6349/ghe_an_co_tay_porto.jpg', '2020-12-17', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 1),
(6, ' Bàn ăn Ceramic - HT83001-120[KL-99]', 77, 18000000, 'https://www.nhaxinh.com/photo/6349/ghe_an_co_tay_porto.jpg', '2020-12-16', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 1),
(7, 'Giường ngủ - GBD019.005A', 61, 30000000, 'gb019.005a.1.jpg', '2020-12-21', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 3),
(8, 'Sofa bộ Hoàn Mỹ - LAZIO-HM2', 74, 68000000, 'lazio-hm2_g3_.1_1.jpg', '2020-12-21', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 4),
(9, 'Sofa vải - M11/705-23 ', 75, 22000000, 'm11_bo_.2_1_2.jpg', '2020-12-21', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 4),
(10, 'Ghế - DC323-3-101', 66, 850000, 'https://www.noithathoanmy.com.vn/pub/media/catalog/product/cache/10f519365b01716ddb90abc57de5a837/d/c/dc323-3.101.1.jpg', '2020-12-21', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 1),
(11, 'Ghế làm việc High Bossy', 113, 21000000, 'https://www.nhaxinh.com/photo/5233/1000-san-pham-nha-xinh-(12).jpg', '2020-12-21', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 1),
(12, 'Giường ngủ Melamine - 3112005090', 95, 10000000, 'giuong-ngu-melamine-31120050-noi-that-hoan-my_1_.jpg', '2020-12-21', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 3),
(16, 'Giường ngủ - Sora Gas', 99, 11000000, 'sora-gas-lift-queer-bed.3_2.jpg', '2020-12-24', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 3),
(17, 'Sofa Twoback 2,5 chỗ hiện đại vải Diego', 98, 36000000, 'veneto--213-bo.3.jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 4),
(18, 'Sofa Twoback 2,5 chỗ hiện đại vải Diego', 98, 36000000, 'veneto--213-bo.3.jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 4),
(19, 'Sofa 121 3 chỗ hiện đại da nâu', 77, 56000000, 'sofa-3-cho-boc-da-den-500.jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 4),
(20, 'Sofa Twoback 3 chỗ hiện đại vải Diego', 38, 33000000, 'sofa_twoback_077-3-_3cho_diego(2)_-_copy.jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 4),
(21, 'Bàn ăn gỗ Sen', 16, 13000000, 'ban_an_sen_-_copy.jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 2),
(22, 'Bàn ăn Dubai 1m8', 99, 9000000, 'ban-an-dubai-1m8_-_copy.jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 2),
(23, 'Bàn ăn Jazz 2m', 17000000, 17000000, '500-san-pham-nha-xinh(55).jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 2),
(24, 'Giường ngủ bọc vải Pio 1m8', 29, 28000000, 'https://www.nhaxinh.com/photo/5238/giuong_pio.jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 3),
(25, 'Giường ngủ gỗ Dixie 1m8', 38, 53000000, 'http://nhaxinh.com/photo/5797/giuong--dixie-1m8_-_copy.jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 3),
(26, 'Giường ngủ gỗ Bụi 1m6', 53, 17000000, 'https://www.nhaxinh.com/photo/5869/giuong_bui_1.6m_vai_foster_1.jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 3),
(27, 'Ghế làm việc Victoria', 55, 11000000, 'https://www.nhaxinh.com/photo/5220/1000-san-pham-nha-xinh_(4-1).jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 1),
(28, 'Ghế có tay Porto', 48, 8500000, 'https://www.nhaxinh.com/photo/6349/ghe_an_co_tay_porto.jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 1),
(29, 'Ghế Aida Plus màu burgundy', 66, 12000000, 'https://www.nhaxinh.com/photo/6241/ghe-aida-plus-1.jpg', '2021-01-11', '- Cạnh bàn được bo tròn, an toàn cho người sử dụng - kể cả với các gia đình có trẻ nhỏ.\r\n\r\n- Mặt bàn có vân gỗ đẹp tự nhiên.\r\n\r\n- Dễ vệ sinh sau khi dùng bữa.\r\n\r\n- Kiểu dáng đơn giản mà hiện đại, thanh lịch. ', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL,
  `tendn` varchar(500) NOT NULL,
  `matkhau` varchar(500) NOT NULL,
  `tendaydu` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngay` date NOT NULL DEFAULT current_timestamp(),
  `email` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `sodt` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachi` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioitinh` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaysinh` date NOT NULL,
  `anh` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'adn.jpg',
  `vaitro` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `trangthai` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `tendn`, `matkhau`, `tendaydu`, `ngay`, `email`, `sodt`, `diachi`, `gioitinh`, `ngaysinh`, `anh`, `vaitro`, `trangthai`) VALUES
(1, 'admin', '202cb962ac59075b964b07152d234b70', 'admin', '2020-12-22', 'tranxp34878@gmail.com', '1264607869', '26 Huỳnh Văn Nghệ', 'nam', '0000-00-00', 'adn.jpg', 'admin', ''),
(2, 'tu', 'c4ca4238a0b923820dcc509a6f75849b', 'Trần Quốc Tú', '2020-12-22', 'tranxp34878@gmail.com', '1264607869', '26 Huỳnh Văn Nghệ', 'nam', '2020-12-22', 'adn.jpg', 'khach', ''),
(3, 'anh', 'c4ca4238a0b923820dcc509a6f75849b', '', '0000-00-00', 'dangleloi102@gmail.com', '1264607869', '100 Huỳnh Văn Nghệ', '', '0000-00-00', 'adn.jpg', 'khach', ''),
(4, 'tu1', 'c4ca4238a0b923820dcc509a6f75849b', '', '0000-00-00', 'tranxp34878@gmail.com', '1264607869', '100 Huỳnh Văn Nghệ', '', '0000-00-00', 'adn.jpg', 'khach', ''),
(5, 'tu102', 'c4ca4238a0b923820dcc509a6f75849b', '', '0000-00-00', 'trantuxp34878@gmail.com', '1264607869', '26 Huỳnh Văn Nghệ', '', '0000-00-00', 'adn.jpg', 'khach', ''),
(6, 'tqtu', 'c4ca4238a0b923820dcc509a6f75849b', '', '0000-00-00', 'tqtu.19it2@vku.udn.vn', '1264607869', '26 Huỳnh Văn Nghệ', '', '0000-00-00', 'adn.jpg', 'khach', ''),
(7, 'admin1', '202cb962ac59075b964b07152d234b70', '', '0000-00-00', 'trantuxp34878@gmail.com', '1264607869', '26Huỳnh Văn Nghệ', '', '0000-00-00', 'adn.jpg', 'admin', ''),
(8, 'tuananh', 'c4ca4238a0b923820dcc509a6f75849b', '', '2020-12-23', 'dangleloi102@gmail.com', '1264607869', '26 Huỳnh Văn Nghệ', '', '0000-00-00', 'adn.jpg', 'admin', ''),
(9, 'p', 'c4ca4238a0b923820dcc509a6f75849b', '', '2020-12-23', 'dangleloi102@gmail.com', '1264607869', '26Huỳnh Văn Nghệ', '', '0000-00-00', 'adn.jpg', 'khach', ''),
(10, '', '202cb962ac59075b964b07152d234b70', '', '2021-01-10', 'tranxp34878@gmail.com', '1264607869', '26Huỳnh Văn Nghệ', '', '0000-00-00', 'adn.jpg', 'khach', '');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdh`
--
ALTER TABLE `chitietdh`
  ADD KEY `iddh` (`iddh`),
  ADD KEY `idsp` (`idsp`);

--
-- Chỉ mục cho bảng `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idkhachhang` (`idkhachhang`);

--
-- Chỉ mục cho bảng `hanghoa`
--
ALTER TABLE `hanghoa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `iddanhmuc` (`iddanhmuc`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `danhmuc`
--
ALTER TABLE `danhmuc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT cho bảng `hanghoa`
--
ALTER TABLE `hanghoa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `hanghoa`
--
ALTER TABLE `hanghoa`
  ADD CONSTRAINT `hanghoa_ibfk_1` FOREIGN KEY (`iddanhmuc`) REFERENCES `danhmuc` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
