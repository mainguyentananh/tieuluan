package sunshop.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sunshop.com.dao.sachDao;
import sunshop.com.model.sach;
import sunshop.com.service.sachService;

@Service
@Transactional
public class sachServiceImpl implements sachService{
	
	@Autowired
	private sachDao hhd;

	@Override
	public List<sach> getAllHangHoa(String page) {
		return hhd.getAllHangHoa(page);
	}

	@Override
	public void updateHangHoa(sach hh) {
		hhd.updateHangHoa(hh);
	}

	@Override
	public void deleteHangHoa(int mshh) {
		hhd.deleteHangHoa(mshh);
	}

	@Override
	public void saveHangHoa(sach hh) {
		hhd.saveHangHoa(hh);
	}

	@Override
	public sach getHangHoaByMshh(int mshh) {
		return hhd.getHangHoaByMshh(mshh);
	}

	@Override
	public List<sach> search(String sach) {
		return hhd.search(sach);
	}

	@Override
	public long getCountHh() {
		return hhd.getCountHh();
	}


	
	
}
