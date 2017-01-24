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
        
        Offer updateOffer = new Offer(6, "Claire", "claire@mycom.com", "Prepositions dangled while you wait");
        
        if(offersDao.update(updateOffer))
        	System.out.println("Offer updated.");
        else
        	System.out.println("Offer cannot be updated.");
        
        try {
      
    /*    	Offer offer1 = new Offer("Dave", "dave@mycom.com", "Coding fool.");      
        	Offer offer2 = new Offer("Karen", "karen@mycom.com", "Let's do lunch.");      
        	Offer offer3 = new Offer("Bilbo", "bilbo@mycom.com", "I need a hanky.");      
        	Offer offer4 = new Offer("Frodo", "frodo@mycom.com", "I wish it had never come to me.");      
        	Offer offer5 = new Offer("Merry", "merry@mycom.com", "Coding tool");
        	
        	if(offersDao.create(offer1))
        		System.out.println("Created object offer");
        	if(offersDao.create(offer2))
        		System.out.println("Created object offer");
        	if(offersDao.create(offer3))
        			System.out.println("Created object offer");
        	if(offersDao.create(offer4))
        			System.out.println("Created object offer");
        	if(offersDao.create(offer5))
        		System.out.println("Created object offer");			*/
        	
    //    	offersDao.delete();
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
