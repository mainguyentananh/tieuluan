package sunshop.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sunshop.com.dao.nhanVienDao;
import sunshop.com.model.nhanVien;
import sunshop.com.service.nhanVienService;

@Service
@Transactional
public class nhanVienServiceImpl implements nhanVienService{

	@Autowired
	private nhanVienDao nvd;
	
	@Override
	public List<nhanVien> getAllNhanVien() {
		return nvd.getAllNhanVien();
	}

	@Override
	public void updateNhanVien(nhanVien nv) {
		nvd.updateNhanVien(nv);
		
	}

	@Override
	public void deleteNhanVien(int msnv) {
		nvd.deleteNhanVien(msnv);
	}

	@Override
	public void saveNhanVien(nhanVien nv) {
		nvd.saveNhanVien(nv);
	}

	@Override
	public nhanVien getNhanVienByMsnv(int msnv) {
		return	nvd.getNhanVienByMsnv(msnv);
	}

	@Override
	public nhanVien loadNhanVienByEmail(String email) {
		return nvd.loadNhanVienByEmail(email);
	}

}
