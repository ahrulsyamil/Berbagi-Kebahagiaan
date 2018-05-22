-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 09, 2018 at 08:38 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perpus`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `laporan`
-- (See below for the actual view)
--
CREATE TABLE `laporan` (
`nama` varchar(25)
,`judul` varchar(50)
,`tgl_pinjam` date
,`tgl_kembali` date
,`keterangan` enum('Telat','Tidak telat','Hilang','')
,`denda` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `lihat_transaksi`
-- (See below for the actual view)
--
CREATE TABLE `lihat_transaksi` (
`id_anggota` varchar(20)
,`nama` varchar(25)
,`kode_pinjam` varchar(20)
,`judul` varchar(50)
,`tgl_pinjam` date
,`tgl_hrskembali` date
,`kode_kembali` varchar(20)
,`tgl_kembali` date
,`keterangan` enum('Telat','Tidak telat','Hilang','')
,`denda` int(11)
,`kt` enum('Sudah kembali','Belum kembali','','')
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `recomendasi`
-- (See below for the actual view)
--
CREATE TABLE `recomendasi` (
`kode_buku` varchar(20)
,`judul` varchar(50)
,`penerbit` varchar(30)
,`tahun_terbit` int(4)
,`kategori` varchar(20)
,`keterangan` enum('Sudah kembali','Belum kembali','','')
);

-- --------------------------------------------------------

--
-- Table structure for table `tb_admin`
--

CREATE TABLE `tb_admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_admin`
--

INSERT INTO `tb_admin` (`username`, `password`) VALUES
('admin', '61646D696E6E7961');

-- --------------------------------------------------------

--
-- Table structure for table `tb_anggota`
--

CREATE TABLE `tb_anggota` (
  `id_anggota` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `telp` varchar(25) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `status` enum('Pinjam','Tidak pinjam','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_anggota`
--

INSERT INTO `tb_anggota` (`id_anggota`, `nama`, `password`, `jk`, `telp`, `alamat`, `status`) VALUES
('USR001', 'ahrul', 'ahrul123', 'Laki-laki', '0284975820492', 'Cisarua', 'Pinjam'),
('USR002', 'ulum', '12345678', 'Laki-laki', '0942758929402', 'cibedug', 'Pinjam'),
('USR003', 'dian', '87654321', 'Perempuan', '042402850', 'bandung', 'Pinjam'),
('USR004', 'kumallllll', 'kumal123', 'Laki-laki', '4248972359273', 'puncak', 'Tidak pinjam'),
('USR005', 'ayu', 'ayu12345', 'Laki-laki', '4247927948402', 'gadog', 'Pinjam'),
('USR006', 'fajar', 'fajar123', 'Laki-laki', '8479279842748', 'tajur', 'Pinjam'),
('USR007', 'riski', 'riski123', 'Laki-laki', '42402834098', 'bogor', 'Tidak pinjam'),
('USR008', 'jflkdsj', '12345678', 'Perempuan', '57349857349', 'cisarua', 'Pinjam'),
('USR009', 'Alif', '12345678', 'Laki-laki', '1123', 'ppp', 'Pinjam'),
('USR010', 'baba', 'babababa', 'Laki-laki', '12345678', 'baba', 'Pinjam'),
('USR011', 'abil', 'abilganteng', 'Laki-laki', '0898976808094', 'batu layang, puncak', 'Pinjam'),
('USR012', 'fauzi', 'fauzifadilah', 'Laki-laki', '083818317005', 'jl.ciapus.bogor selatan', 'Pinjam'),
('USR013', 'dimas', 'dimas123', 'Laki-laki', '0980980428042', 'bogor', 'Tidak pinjam'),
('USR014', 'pai', 'pai12345', 'Laki-laki', '0432022384098', 'papua', 'Tidak pinjam'),
('USR015', 'lisa', 'lisa1234', 'Perempuan', '0234872975924', 'bandung', 'Pinjam'),
('USR016', 'Milea', 'milea123', 'Perempuan', '0251998877', 'Cisarua', 'Tidak pinjam'),
('USR017', 'wilona', 'wilona123', 'Perempuan', '0899325258294', 'jakarta pusat', 'Tidak pinjam');

-- --------------------------------------------------------

--
-- Table structure for table `tb_buku`
--

CREATE TABLE `tb_buku` (
  `kode_buku` varchar(20) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `penerbit` varchar(30) NOT NULL,
  `tahun_terbit` int(4) NOT NULL,
  `kategori` varchar(20) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_buku`
--

INSERT INTO `tb_buku` (`kode_buku`, `judul`, `penerbit`, `tahun_terbit`, `kategori`, `jumlah`) VALUES
('BK001', 'Dragon', 'Mobel', 2010, 'Perang', 94),
('BK002', 'saku', 'saya', 8900, '123', 130),
('BK003', 'Dia', 'Gramedia', 2011, 'Remaja', 73),
('BK004', 'mengenal huruf', 'hurf', 2005, 'Pendidikan', 18),
('BK005', 'merdeka', 'indonesiamerdeka', 2000, 'pendidikan', 10),
('BK006', 'lupus', 'gram', 2010, 'komedi', 25),
('BK007', 'dilan', 'pidi baiq', 2015, 'remaja', 120),
('BK008', 'Dialah mentari', 'gaya', 2014, 'islami', 27),
('BK009', 'marmut merah jambu', 'bukune', 2012, 'komik', 38),
('BK010', 'suara dari dilan', 'wahh', 2011, 'remaja', 49),
('BK011', 'Bkp', 'wikrama', 2017, 'Pendidikan', 1600),
('BK012', 'Ipa vs ips', 'aku', 2009, 'Pendidikan', 52),
('BK013', 'Boole', 'IT', 2005, 'Koding', 12),
('BK014', 'Suara hujan', 'mentari', 2018, 'novel', 35),
('BK015', 'sekolahku', 'gramedia', 2015, 'pendidikan', 11);

-- --------------------------------------------------------

--
-- Table structure for table `tb_kembali`
--

CREATE TABLE `tb_kembali` (
  `kode_kembali` varchar(20) NOT NULL,
  `kode_pinjam` varchar(20) NOT NULL,
  `id_anggota` varchar(20) NOT NULL,
  `kode_buku` varchar(20) NOT NULL,
  `tgl_kembali` date NOT NULL,
  `denda` int(11) NOT NULL,
  `keterangan` enum('Telat','Tidak telat','Hilang','') NOT NULL,
  `jumlah` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kembali`
--

INSERT INTO `tb_kembali` (`kode_kembali`, `kode_pinjam`, `id_anggota`, `kode_buku`, `tgl_kembali`, `denda`, `keterangan`, `jumlah`) VALUES
('339088', '972993', 'USR004', 'BK001', '2018-02-21', 0, 'Tidak telat', 1),
('432050', '235209', 'USR004', 'BK001', '2018-02-16', 200000, 'Hilang', 0),
('56592', '245143', 'USR007', 'BK004', '2018-02-22', 200000, 'Hilang', 0),
('619131', '23408', 'USR004', 'BK003', '2018-02-22', 200000, 'Hilang', 0),
('644880', '820264', 'USR005', 'BK005', '2018-02-22', 0, 'Tidak telat', 1),
('65575', '552698', 'USR005', 'BK003', '2018-02-16', 2000, 'Telat', 1),
('695104', '623597', 'USR007', 'BK003', '2018-02-21', 0, 'Tidak telat', 1),
('697354', '126159', 'USR001', 'BK004', '2018-02-15', 0, 'Tidak telat', 1),
('724514', '961646', 'USR005', 'BK001', '2018-02-18', 0, 'Tidak telat', 1),
('747007', '250524', 'USR008', 'BK001', '2018-02-17', 200000, 'Hilang', 0),
('781009', '495969', 'USR006', 'BK003', '2018-02-17', 0, 'Tidak telat', 1),
('920611', '367751', 'USR006', 'BK004', '2018-02-16', 0, 'Tidak telat', 1),
('931697', '919025', 'USR002', 'BK004', '2018-02-16', 200000, 'Hilang', 0),
('932284', '250795', 'USR013', 'BK012', '2018-02-22', 0, 'Tidak telat', 1),
('944899', '118446', 'USR006', 'BK001', '2018-02-15', 200000, 'Hilang', 0);

--
-- Triggers `tb_kembali`
--
DELIMITER $$
CREATE TRIGGER `kembali_buku` AFTER INSERT ON `tb_kembali` FOR EACH ROW BEGIN
UPDATE tb_buku SET jumlah = jumlah + new.jumlah
WHERE kode_buku = new.kode_buku;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_petugas`
--

CREATE TABLE `tb_petugas` (
  `id_operator` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `telp` varchar(25) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_petugas`
--

INSERT INTO `tb_petugas` (`id_operator`, `nama`, `password`, `jk`, `telp`, `alamat`) VALUES
('OPR01', 'Ulum', 'ahrulsyamil', 'Laki-laki', '083814342234', 'Cisarua, Bogor Jawa Barat'),
('OPR02', 'Dilah', 'dilah123', 'Perempuan', '0251398023288', 'cipayung'),
('OPR03', 'sri', 'sriii123', 'Perempuan', '9088097127092', 'papua');

-- --------------------------------------------------------

--
-- Table structure for table `tb_pinjam`
--

CREATE TABLE `tb_pinjam` (
  `kode_pinjam` varchar(20) NOT NULL,
  `id_anggota` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `kode_buku` varchar(20) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_hrskembali` date NOT NULL,
  `jumlah` int(1) NOT NULL,
  `kt` enum('Sudah kembali','Belum kembali','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pinjam`
--

INSERT INTO `tb_pinjam` (`kode_pinjam`, `id_anggota`, `nama`, `kode_buku`, `judul`, `tgl_pinjam`, `tgl_hrskembali`, `jumlah`, `kt`) VALUES
('115552', 'USR006', 'fajar', 'BK001', 'Dragon', '2018-02-23', '2018-03-02', 1, 'Belum kembali'),
('118446', 'USR006', 'fajar', 'BK001', 'Dragon', '2018-02-15', '2018-02-22', 1, 'Sudah kembali'),
('126159', 'USR001', 'udin', 'BK004', 'mengenal huruf', '2018-02-08', '2018-02-15', 1, 'Sudah kembali'),
('140718', 'USR005', 'ayu', 'BK015', 'sekolahku', '2018-02-23', '2018-03-02', 1, 'Belum kembali'),
('164267', 'USR009', 'Alif', 'BK003', 'Dia', '2018-02-23', '2018-03-02', 1, 'Belum kembali'),
('233808', 'USR003', 'dian', 'BK003', 'Dia', '2018-02-22', '2018-03-01', 1, 'Belum kembali'),
('23408', 'USR004', 'kumallllll', 'BK003', 'Dia', '2018-02-22', '2018-03-01', 1, 'Sudah kembali'),
('235209', 'USR004', 'kumal', 'BK001', 'Dragon', '2018-02-15', '2018-02-22', 1, 'Sudah kembali'),
('245143', 'USR007', 'riski', 'BK004', 'mengenal huruf', '2018-02-22', '2018-03-01', 1, 'Sudah kembali'),
('250524', 'USR008', 'jflkdsj', 'BK001', 'Dragon', '2018-02-17', '2018-02-24', 1, 'Sudah kembali'),
('250795', 'USR013', 'dimas', 'BK012', 'Ipa vs ips', '2018-02-22', '2018-03-01', 1, 'Sudah kembali'),
('264120', 'USR008', 'jflkdsj', 'BK010', 'suara dari dilan', '2018-02-22', '2018-03-01', 1, 'Belum kembali'),
('289841', 'USR002', 'ulum', 'BK001', 'Dragon', '2018-02-22', '2018-03-01', 1, 'Belum kembali'),
('367751', 'USR006', 'fajar', 'BK004', 'mengenal huruf', '2018-02-16', '2018-02-23', 1, 'Sudah kembali'),
('495969', 'USR006', 'fajar', 'BK003', 'Dia', '2018-02-17', '2018-02-24', 1, 'Sudah kembali'),
('502832', 'USR001', 'ahrul', 'BK001', 'Dragon', '2018-02-22', '2018-03-01', 1, 'Belum kembali'),
('523047', 'USR010', 'baba', 'BK004', 'mengenal huruf', '2018-02-22', '2018-03-01', 1, 'Belum kembali'),
('552698', 'USR005', 'ayu', 'BK003', 'Dia', '2018-02-05', '2018-02-15', 1, 'Sudah kembali'),
('621840', 'USR011', 'abil', 'BK001', 'Dragon', '2018-02-22', '2018-03-01', 1, 'Belum kembali'),
('623597', 'USR007', 'riski', 'BK003', 'Dia', '2018-02-21', '2018-02-28', 1, 'Sudah kembali'),
('626961', 'USR012', 'fauzi', 'BK008', 'Dialah mentari', '2018-02-22', '2018-03-01', 1, 'Belum kembali'),
('678576', 'USR015', 'lisa', 'BK001', 'Dragon', '2018-02-22', '2018-03-01', 1, 'Belum kembali'),
('820264', 'USR005', 'ayu', 'BK005', 'merdeka', '2018-02-22', '2018-03-01', 1, 'Sudah kembali'),
('919025', 'USR002', 'ulum', 'BK004', 'mengenal huruf', '2018-02-16', '2018-02-23', 1, 'Sudah kembali'),
('961646', 'USR005', 'ayu', 'BK001', 'Dragon', '2018-02-17', '2018-02-24', 1, 'Sudah kembali'),
('972993', 'USR004', 'kumallllll', 'BK001', 'Dragon', '2018-02-21', '2018-02-28', 1, 'Sudah kembali');

--
-- Triggers `tb_pinjam`
--
DELIMITER $$
CREATE TRIGGER `pinjam_buku` AFTER INSERT ON `tb_pinjam` FOR EACH ROW BEGIN
update tb_buku SET jumlah = jumlah - new.jumlah
WHERE kode_buku = new.kode_buku;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure for view `laporan`
--
DROP TABLE IF EXISTS `laporan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laporan`  AS  select `tb_pinjam`.`nama` AS `nama`,`tb_pinjam`.`judul` AS `judul`,`tb_pinjam`.`tgl_pinjam` AS `tgl_pinjam`,`tb_kembali`.`tgl_kembali` AS `tgl_kembali`,`tb_kembali`.`keterangan` AS `keterangan`,`tb_kembali`.`denda` AS `denda` from (`tb_pinjam` join `tb_kembali` on((`tb_pinjam`.`kode_pinjam` = `tb_kembali`.`kode_pinjam`))) ;

-- --------------------------------------------------------

--
-- Structure for view `lihat_transaksi`
--
DROP TABLE IF EXISTS `lihat_transaksi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `lihat_transaksi`  AS  select `tb_pinjam`.`id_anggota` AS `id_anggota`,`tb_pinjam`.`nama` AS `nama`,`tb_pinjam`.`kode_pinjam` AS `kode_pinjam`,`tb_pinjam`.`judul` AS `judul`,`tb_pinjam`.`tgl_pinjam` AS `tgl_pinjam`,`tb_pinjam`.`tgl_hrskembali` AS `tgl_hrskembali`,`tb_kembali`.`kode_kembali` AS `kode_kembali`,`tb_kembali`.`tgl_kembali` AS `tgl_kembali`,`tb_kembali`.`keterangan` AS `keterangan`,`tb_kembali`.`denda` AS `denda`,`tb_pinjam`.`kt` AS `kt` from (`tb_pinjam` left join `tb_kembali` on((`tb_pinjam`.`kode_pinjam` = `tb_kembali`.`kode_pinjam`))) ;

-- --------------------------------------------------------

--
-- Structure for view `recomendasi`
--
DROP TABLE IF EXISTS `recomendasi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `recomendasi`  AS  select `tb_pinjam`.`kode_buku` AS `kode_buku`,`tb_pinjam`.`judul` AS `judul`,`tb_buku`.`penerbit` AS `penerbit`,`tb_buku`.`tahun_terbit` AS `tahun_terbit`,`tb_buku`.`kategori` AS `kategori`,`tb_pinjam`.`kt` AS `keterangan` from (`tb_pinjam` join `tb_buku` on((`tb_pinjam`.`kode_buku` = `tb_buku`.`kode_buku`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tb_anggota`
--
ALTER TABLE `tb_anggota`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indexes for table `tb_buku`
--
ALTER TABLE `tb_buku`
  ADD PRIMARY KEY (`kode_buku`);

--
-- Indexes for table `tb_kembali`
--
ALTER TABLE `tb_kembali`
  ADD PRIMARY KEY (`kode_kembali`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `id_anggota` (`id_anggota`),
  ADD KEY `id_anggota_2` (`id_anggota`),
  ADD KEY `kode_buku_2` (`kode_buku`),
  ADD KEY `kode_pinjam` (`kode_pinjam`);

--
-- Indexes for table `tb_petugas`
--
ALTER TABLE `tb_petugas`
  ADD PRIMARY KEY (`id_operator`);

--
-- Indexes for table `tb_pinjam`
--
ALTER TABLE `tb_pinjam`
  ADD PRIMARY KEY (`kode_pinjam`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `id_anggota` (`id_anggota`),
  ADD KEY `kode_buku_2` (`kode_buku`),
  ADD KEY `id_anggota_2` (`id_anggota`),
  ADD KEY `kode_buku_3` (`kode_buku`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_kembali`
--
ALTER TABLE `tb_kembali`
  ADD CONSTRAINT `tb_kembali_ibfk_2` FOREIGN KEY (`kode_buku`) REFERENCES `tb_buku` (`kode_buku`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_kembali_ibfk_3` FOREIGN KEY (`kode_pinjam`) REFERENCES `tb_pinjam` (`kode_pinjam`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_kembali_ibfk_4` FOREIGN KEY (`id_anggota`) REFERENCES `tb_anggota` (`id_anggota`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_pinjam`
--
ALTER TABLE `tb_pinjam`
  ADD CONSTRAINT `tb_pinjam_ibfk_1` FOREIGN KEY (`kode_buku`) REFERENCES `tb_buku` (`kode_buku`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_pinjam_ibfk_2` FOREIGN KEY (`id_anggota`) REFERENCES `tb_anggota` (`id_anggota`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
