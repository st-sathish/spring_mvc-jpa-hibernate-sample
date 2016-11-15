package com.sample.login;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import com.sample.core.configuration.EntityManagerFactoryConfiguration;
import com.sample.model.User;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService {

	//protected static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(ProjectUtil.PERSISTENCE_UNIT);
	protected static final EntityManagerFactory factory = EntityManagerFactoryConfiguration.getEntityManagerFactory();
	
	@Override
	public User authenticateUser(String email, String password) throws Exception {
		User user = null;
		EntityManager em = null;
		try{
			em = factory.createEntityManager();
			Query userByEmailByPassword = em.createNamedQuery("User.findByEmailAndPassword");
			userByEmailByPassword.setParameter("email", email.trim().toLowerCase());
			userByEmailByPassword.setParameter("password", password.trim());
			List<User> userList = (List<User>) userByEmailByPassword.getResultList();
			if (null != userList && userList.size() > 0) {
				user  = userList.get(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			if (null != em && em.isOpen()) {
				em.close();
			}
		}
		return user;
	}
}
