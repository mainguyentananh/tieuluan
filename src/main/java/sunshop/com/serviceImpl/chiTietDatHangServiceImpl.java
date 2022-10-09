package sunshop.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sunshop.com.dao.chiTietDatHangDao;
import sunshop.com.model.chiTietDatHang;
import sunshop.com.service.chiTietDatHangService;

@Service
@Transactional
public class chiTietDatHangServiceImpl implements chiTietDatHangService{

	@Autowired
	private chiTietDatHangDao ctdhd;
	
	@Override
	public void saveChiTietDatHang(chiTietDatHang ctdh) {
		ctdhd.saveChiTietDatHang(ctdh);
	}

	@Override
	public List<chiTietDatHang> getAllChiTietDatHang(Integer iddh) {
		return ctdhd.getAllChiTietDatHang(iddh);
	}

	

	
}
