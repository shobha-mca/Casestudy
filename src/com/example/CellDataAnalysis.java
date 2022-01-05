package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class CellDataAnalysis {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		ResultSet rs = JDBCFactory.getResultset("select * from call");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"  "+rs.getLong(2)+"  "+rs.getDate(3)+" "+rs.getTime(3)+"  "+rs.getDate(4)+" "+rs.getTime(4)+" "+rs.getInt(5));
		}
		
		callVolumeHighest();
		callsLongest();
	}
	
	public static void callVolumeHighest() throws ClassNotFoundException, SQLException{
		ResultSet rs = JDBCFactory.getResultset("select * from call");
        
        int timeOfDay[]=new int[24]; 
        
        while(rs.next()) {
        	int startTimeHour = rs.getTime(3).getHours();
        	int endTimeHour = rs.getTime(4).getHours();
        	int difference = endTimeHour - startTimeHour;
        	
        	 for(int i=0; i<=difference; i++){
        	        timeOfDay[startTimeHour++]++;
        	 }
        }

        int max = timeOfDay[0];
        int hourHighest = 0;
        for(int i=0; i<24; i++){
        	if(timeOfDay[i]>max) {
        		max=timeOfDay[i];
        		hourHighest = i;
        	}
        }
        
        System.out.println("Hour of the day when the call volume is highest is " + hourHighest + " to " + (hourHighest+1));
	}
	
	public static void callsLongest() throws ClassNotFoundException, SQLException {
		ResultSet rs = JDBCFactory.getResultset("select * from call");
		
		int max = 0;
		int hourLongest = 0;
		while(rs.next()) {
			if(rs.getInt(5)>max) {
				max = rs.getInt(5);
				hourLongest = rs.getTime(3).getHours();
			}
		}
		System.out.println("Hour of the day when the calls are longest is " + hourLongest + " to " + (hourLongest+1));
	}
}
