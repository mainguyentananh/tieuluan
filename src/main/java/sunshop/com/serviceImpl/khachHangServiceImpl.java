package sunshop.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sunshop.com.dao.khachHangDao;
import sunshop.com.model.khachHang;
import sunshop.com.service.khachHangService;

@Service
@Transactional
public class khachHangServiceImpl implements khachHangService{

	@Autowired
	private khachHangDao khd;
	
	@Override
	public List<khachHang> getAllKhachHang() {
		return khd.getAllKhachHang();
	}

	@Override
	public void updateKhachHang(khachHang kh) {
		khd.updateKhachHang(kh);
	}

	@Override
	public void deleteKhachHang(int mskh) {
		khd.deleteKhachHang(mskh);
	}

	@Override
	public void saveKhachHang(khachHang kh) {
		khd.saveKhachHang(kh);
	}

	@Override
	public khachHang getKhachHangByMskh(int mskh) {
		return khd.getKhachHangByMskh(mskh);
	}

	@Override
	public khachHang getKhachHangByPhone(String sdt) {
		return khd.getKhachHangByPhone(sdt);
	}

	
}
