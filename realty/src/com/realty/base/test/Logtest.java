package com.realty.base.test;

import org.apache.log4j.Logger;

public class Logtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Logger logger = Logger.getLogger("DAO");
		logger.debug("debuging..");
		logger.info("info...");
		logger.error("error..");
	}

}
