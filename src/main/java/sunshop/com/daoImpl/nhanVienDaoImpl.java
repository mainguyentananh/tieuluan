package sunshop.com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sunshop.com.dao.nhanVienDao;
import sunshop.com.model.nhanVien;

@Repository
public class nhanVienDaoImpl implements nhanVienDao{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<nhanVien> getAllNhanVien() {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From nhanVien";
		List<nhanVien> l_nhanVien = session.createQuery(hql,nhanVien.class).list();
		return l_nhanVien;
	}

	@Override
	public void updateNhanVien(nhanVien nv) {
		Session session = sessionfactory.getCurrentSession();
		session.update(nv);
	}

	@Override
	public void deleteNhanVien(int msnv) {
		Session session = sessionfactory.getCurrentSession();
		session.delete(getNhanVienByMsnv(msnv));
	}

	@Override
	public void saveNhanVien(nhanVien nv) {
		Session session = sessionfactory.getCurrentSession();
		session.save(nv);
	}

	@Override
	public nhanVien getNhanVienByMsnv(int msnv) {
		Session session = sessionfactory.getCurrentSession();
		nhanVien nv = session.get(nhanVien.class, msnv);
		return nv;
	}

	@Override
	public nhanVien loadNhanVienByEmail(String email) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "from nhanVien where email like :email";
		nhanVien nv = session.createQuery(hql,nhanVien.class).setParameter("email", email).list().get(0);
		return nv;
	}

	
	
}
