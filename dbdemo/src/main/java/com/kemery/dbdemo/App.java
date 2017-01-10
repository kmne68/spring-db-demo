package com.kemery.dbdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
    	
        System.out.println( "Hello DB World!" );
        
        Robot robot = (Robot)context.getBean("robot");
        robot.speak();

     //   Person person = new Person();
        Person person = (Person)context.getBean("person");
        person.speak();
        
        ((FileSystemXmlApplicationContext)context).close();
     //   robot.setId(id);
     //   robot.setSpeech();
    }
}
