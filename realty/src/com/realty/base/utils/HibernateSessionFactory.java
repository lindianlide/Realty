package com.realty.base.utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	//private static Configuration conf;
	private static SessionFactory sf;
	//private static final String HIBERENATE_CONFIG_FILE="hibernate.cfg.xml";
	static {
		sf=new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession(){
		return sf.openSession();
		
	}
	public static SessionFactory getSessionFactory(){
		return sf;
	}
}
