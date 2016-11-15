package com.sample.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-05T20:42:18.261+0530")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, Date> expirationDate;
	public static volatile SingularAttribute<User, Byte> isLoggedIn;
	public static volatile SingularAttribute<User, Date> lastLoginTime;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> securityToken;
	public static volatile SingularAttribute<User, UserAccountType> userAccountType;
	public static volatile SingularAttribute<User, UserStatus> userStatus;
}
