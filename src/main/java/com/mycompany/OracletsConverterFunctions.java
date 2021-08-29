package com.mycompany;

import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
public class OracletsConverterFunctions {
	
		private static final Logger logger = getLogger(OracletsConverterFunctions.class);
		
		public static Timestamp getJavaSQLTimestamp(Object oracleTimestamp) {
			
			try {
				Method timestampValue = oracleTimestamp.getClass().getMethod("timestampValue");
				return (Timestamp) timestampValue.invoke(oracleTimestamp);		
				
			} catch (NoSuchMethodException e) {
				logger.error("Object does not have timestampValue() method");
				throw new RuntimeException("Object does not have timestampValue() method");
			} catch (IllegalAccessException e) {
				logger.error("Object does not have a public timestampValue() method");
				throw new RuntimeException("Object does not have a public timestampValue() method");
			} catch (ClassCastException e) {
				logger.error("Converted timestamp cannot be cast to java.sql.Timestamp");
				throw new RuntimeException("Converted timestamp cannot be cast to java.sql.Timestamp");
			} catch (InvocationTargetException e) {
				logger.error(e.getCause().toString() +" "+e.getMessage());
				throw new RuntimeException(e.getCause());
			}
			
		}		

}