package sunshop.com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sunshop.com.dao.nhanVienDao;
import sunshop.com.model.nhanVien;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private nhanVienDao nvd;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		nhanVien nv =	nvd.loadNhanVienByEmail(email);
		if (nv == null) {
			System.out.println("User not found! " + email);
		}

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(nv.getEmail(), nv.getMatKhau(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, nv.getAuthorities());

	}

}
