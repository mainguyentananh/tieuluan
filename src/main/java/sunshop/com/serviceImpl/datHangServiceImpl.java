package sunshop.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sunshop.com.dao.datHangDao;
import sunshop.com.model.datHang;
import sunshop.com.service.datHangService;

@Service
@Transactional
public class datHangServiceImpl implements datHangService{
	
	@Autowired
	private datHangDao dhd;
	
	@Override
	public List<datHang> getAllDatHang() {
		return dhd.getAllDatHang();
	}

	@Override
	public void updateDatHang(datHang dh) {
		dhd.updateDatHang(dh);
	}

	@Override
	public void deleteDatHang(int msdh) {
		dhd.deleteDatHang(msdh);
	}

	@Override
	public void saveDatHang(datHang dh) {
		dhd.saveDatHang(dh);
	}

	@Override
	public datHang getDatHangByMsdh(int msdh) {
		return dhd.getDatHangByMsdh(msdh);
	}

	@Override
	public datHang getDatHangByMskh(int mskh) {
		return dhd.getDatHangByMskh(mskh);
	}

	
	
}
