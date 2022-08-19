package ConnectionDB;

import java.util.*;
public class ConvertDate {
	 public static java.sql.Date convertDate(Date date) {
	        if (date != null) {
	            return new java.sql.Date(date.getTime());
	        } else {
	            return null;
	        }
	    }
}