package com.kemery.dbdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import model.Offer;
import model.OffersDAO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args )
    {   
    	
    //	ApplicationContext context = new ClassPathXmlApplicationContext("/dbdemo/src/main/java/com/kemery/dbdemo/dbbean.xml");
    	ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
    	
   //     System.out.println( "Hello DB World!" );
        
        OffersDAO offersDao = (OffersDAO)context.getBean("OffersDAO");
        
        try {
        	
        	offersDao.delete(1);
        	List<Offer> offers = offersDao.getOffers();
        
        	for(Offer offer: offers) {
        		System.out.println(offer);
        	}
        	
        	Offer offer = offersDao.getOffer(3);
        	System.out.println("Should be?" + offer);
        }
        
        catch (CannotGetJdbcConnectionException e) {
        	System.out.println("Cannot get database connection. Is your password correct?");
        }
        catch (DataAccessException e) {
        	System.out.println(e.getMessage());
        	System.out.println(e.getClass());
        }

        ((FileSystemXmlApplicationContext)context).close();

    }
}
