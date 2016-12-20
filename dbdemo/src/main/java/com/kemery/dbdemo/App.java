package com.kemery.dbdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/kemery/dbdemo/beans/beans.xml");
    	
        System.out.println( "Hello DB World!" );
        
        Robot robot = (Robot)context.getBean("robot");
        
        robot.speak();
        
        ((ClassPathXmlApplicationContext)context).close();
    //    robot.setId(id);
     //   robot.setSpeech();
    }
}
