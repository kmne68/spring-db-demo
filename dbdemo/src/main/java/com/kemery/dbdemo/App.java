package com.kemery.dbdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import model.Offer;
import model.OffersDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   
    	
    //	ApplicationContext context = new ClassPathXmlApplicationContext("/dbdemo/src/main/java/com/kemery/dbdemo/dbbean.xml");
    	ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
    	
   //     System.out.println( "Hello DB World!" );
        
        OffersDAO offersDao = (OffersDAO)context.getBean("OffersDAO");
        
        List<Offer> offers = offersDao.getOffers();
        
        for(Offer offer: offers) {
        	System.out.println(offer);
        }
        
 /*       robot.speak();
        robot.setId("0");
        robot.setSpeech("Danger Will Robinson!");
        robot.speak(); */
        
     //   Person person = new Person();
        Person person = (Person)context.getBean("person");
        person.speak();
        
        ((FileSystemXmlApplicationContext)context).close();

    }
}
