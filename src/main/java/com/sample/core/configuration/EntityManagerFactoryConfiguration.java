package com.sample.core.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityManagerFactoryConfiguration {

		protected static final Logger logger = LoggerFactory.getLogger(EntityManagerFactoryConfiguration.class);
	
		private static EntityManagerFactory factory;

		 static {
			 try{
				 logger.info("Creating EntityManagerFactory connection");
				 if(null == factory) {
					 factory = Persistence.createEntityManagerFactory("sample"); 
				 }
		    	logger.info("EntityManagerFactory connection created");
		    }catch(Exception e){
		    	e.printStackTrace();
		    	logger.error("Exception in EntityManagerFactory creation : {}",e.getLocalizedMessage());
		    }
		 }
	    
	    public static EntityManagerFactory getEntityManagerFactory() {
	    	logger.info("Returning EntityManagerFactory connection");
	    	return factory;
	    }
	    
	    public static void closeEntityManagerFactory() {
	    	try{
	    		logger.info("Closing EntityManagerFactory");
				if (null != factory && factory.isOpen()) {
					factory.close();
					factory = null;
				}
				logger.info("EntityManagerFactory closed.");
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		logger.error("Exception in EntityManagerFactory close : {}",e.getLocalizedMessage());
	    	}
		}
}
