package sunshop.com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sunshop.com.dao.chiTietDatHangDao;
import sunshop.com.model.chiTietDatHang;

@Repository
public class chiTietDatHangDaoImpl implements chiTietDatHangDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void saveChiTietDatHang(chiTietDatHang ctdh) {
		Session session = sessionfactory.getCurrentSession();
		session.save(ctdh);	
	}

	@Override
	public List<chiTietDatHang> getAllChiTietDatHang(Integer msdh) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From chiTietDatHang where maSoDatHang.id =:msdh";
		List<chiTietDatHang> list = session.createQuery(hql,chiTietDatHang.class).setParameter("msdh", msdh).list();
		return list;
	}

	

	
}
