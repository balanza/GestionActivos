package persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;



public class UtilityHibernate {
	////////////////////////////////////////
	/**
	 * Startup Hibernate and provide access to the singleton SessionFactory
	 */
	  private static SessionFactory sessionFactory;

	  /*static {
	    try {
	    	
	    	Configuration configuration = new Configuration();
	        configuration.configure();       
	        sessionFactory = configuration.buildSessionFactory(new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
	     
	    } catch (Throwable ex) {
	       System.out.println(ex.getMessage());
	       throw new ExceptionInInitializerError(ex);
	    }
	  }*/

	  public static SessionFactory getSessionFactory() {
	      // Alternatively, we could look up in JNDI here
		    try {
		    	
		    	if(sessionFactory == null){
		    		Configuration configuration = new Configuration();
		    		configuration.configure();       
		    		sessionFactory = configuration.buildSessionFactory(new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
		    	}
		     
		    } catch (Throwable ex) {
		       System.out.println(ex.getMessage());
		       throw new ExceptionInInitializerError(ex);
		    }
		    
	      return sessionFactory;
	  }

	  public static void shutdown() {
	      // Close caches and connection pools
	      getSessionFactory().close();
	  }
		
	
	/////////////////////////////////////////

}

