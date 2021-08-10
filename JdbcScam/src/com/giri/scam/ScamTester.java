package com.giri.scam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.giri.scam.constants.JdbcConstants;


public class ScamTester {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(JdbcConstants.URL, JdbcConstants.USERNAME, JdbcConstants.PASSWORD)) {
			System.out.println(connection);
			System.out.println(connection.getAutoCommit());
			connection.setAutoCommit(false);
			String query = "insert into scam values (31,'Saradha Group financial Scam','2013/7/8','Saradha Group','west bengal','collapse of Ponzi Investment',60000000)";
			String query1 = "insert into scam values (32,'Indian Coal Allocation Scam','2012-8-9','IndianGovt','india','wrong full Allocation Of coal deposit',160000000)";
			String query2 = "insert into scam values (33,'Commonwealth Games Scam','2010/9/8','GamesAuthority','NewDelhi','half was actually spent for event',700000000)";
			String query3 = "insert into scam values (34,'Satyam Scam','2009/4/5','the Founder & Chairman of Satyam','noidea','books fudged & profit figures',134000000)";
			String query4 = "insert into scam values (35,'2G Spectrum Scam','2008-4-5','telecom minister','India','Commun bandwidth auctioned for lower than marketvalue',1760000000)";
			String query5 = "insert into scam values (36,'Stamp paper Scam','2002/9/7','someone','India','print & sell of duplicate stamp papers banks',200000000)";
			String query6 = "insert into scam values (37,'Bihar fodder scam','1996/9/18','Lalu Prasad Yadav','bihar','fabricationofvastherdsfictitiouslivestock',95000000)";
			String query7 = "insert into scam values (38,'The Hawala Scandal','1996/4/6','noidea','kashmir','hefty bribes from the Hawala Brokers',18000000000)";
			String query8 = "insert into scam values (39,'Harshad Mehta & Ketan Parekh Stock Market Scam','1992/3/5','HarshadMehta','mumbai','bank scam,showing wrong records to hide all real',500000000)";
			String query9 = "insert into scam values (40,'arms deals scandal','1997/6/7','Abishek VArma','india','arms dealer&primesuspect in Scorpene submarinescase',500000000)";
			String query10 = "insert into scam values (21,'Wakf Board land scam','1992/4/5','someOne','land','possiblyBiggest land scam incountry till date',2000000000)";
			String query11 = "insert into scam values (22,'Telgi scam','1992/5/6','someOne','land','possiblyBiggest land scam incountry till date',567800000)";
			String query12 = "insert into scam values (23,'Wakf Board land scam','2002/9/7','Abdul Karim Telgi','india','counterfeiting stamp paper in India',20000000000)";
			String query13 = "insert into scam values (24,'The ‘Coalgate’ scam','2012/4/5' ,'someOne','india','counterfeiting stamp paper in India',1860000000)";
			String query14 = "insert into scam values (25,'Adarsh Housing Society scam','2011/5/6','Ashok Chavan','colaba','politicians,bureaucrats &military officers concerning land ownership',2345600000)";
			String query15 = "insert into scam values (26,'Broken Taxi Meter','2003,/6/7','autoDrivers','india','the tariff so high that the meter price goes up very quickly',2000000)";
			String query16 = "insert into scam values (27,'Fake SIM Card','2006/2/3','sellers','india','best to taketime to purchase an official SIM card',1230000)";
			String query17 = "insert into scam values (28,'The Non-Existent Hotel','2006/6/7','sellers','india','taxiscam occurs when driver claims hotel doesn’t exist',100000000)";
			String query18= "insert into scam values (29,'The Costly Blessing','2006/3/2','temple-associate','india','ticket rate will be high for direct Darshan',45600000)";
			String query19 = "insert into scam values (30,'The Baby Milk Begging Scam','2006/9/8','beggers','india','children — will be working for a criminal gang',1230000)";
			Statement statement = connection.createStatement();
			statement.execute(query);
			statement.execute(query1);
			statement.execute(query2);
			statement.execute(query3);
			statement.execute(query4);
			statement.execute(query5);
			statement.execute(query6);
			statement.execute(query7);
			statement.execute(query8);
			statement.execute(query9);
			statement.execute(query10);
			statement.execute(query11);
			statement.execute(query12);
			statement.execute(query13);
			statement.execute(query14);
			statement.execute(query15);
			statement.execute(query16);
			statement.execute(query17);
			statement.execute(query18);
			statement.execute(query19);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	}


