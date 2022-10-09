package sunshop.com.dao;

import java.util.List;

import sunshop.com.model.nhanVien;

public interface nhanVienDao {
	public List<nhanVien> getAllNhanVien();
	public void updateNhanVien(nhanVien nv);
	public void deleteNhanVien(int msnv);
	public void saveNhanVien(nhanVien nv);
	public nhanVien getNhanVienByMsnv(int msnv);
	public nhanVien loadNhanVienByEmail(String email);
}
