package com.giri.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamTESTER {
	static Connection connection;
	public static void main(String[] args) {
		String username = "root";
		String password = "tej@18";
		String url = "jdbc:mysql://localhost:3306/javasql_db";
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			System.out.println(connection);
			String query = "insert into scam_table values (121,'Saradha Group financial Scam','chit fund',2013,'Saradha Group','4-6billion','west bengal','collapseofPonziInvestment')";
			String query1 = "insert into scam_table values (122,' Indian Coal Allocation Scam','coal',2012,'IndianGovt','186000cr','india','wrongfulAallocationOfcoaldeposit ')";
			String query2 = "insert into scam_table values (123,'Commonwealth Games Scam','money',2010,'GamesAuthority','70000cr','NewDelhi','halfwasactuallyspentforevent')";
			String query3 = "insert into scam_table values (124,'Satyam Scam','money',2009,'the Founder & Chairman of Satyam','14000cr','noidea','booksfudged&profitfigures')";
			String query4 = "insert into scam_table values (125,'2G Spectrum Scam','money',2008,'telecom minister','176000cr','India','Communbandwidthauctionedforlowerthanmarketvalue')";
			String query5 = "insert into scam_table values (126,'Stamp paper Scam','money',2002,'someone','20000cr','India','print&sellofduplicatestamppapersbanks')";
			String query6 = "insert into scam_table values (127,'Bihar fodder scam','money',1996,'Lalu Prasad Yadav','950cr','bihar','fabricationofvastherdsfictitiouslivestock')";
			String query7 = "insert into scam_table values (128,'The Hawala Scandal','money',1996,'noidea','180Million','kashmir','heftybribesfromtheHawalaBrokers')";
			String query8 = "insert into scam_table values (129,'Harshad Mehta & Ketan Parekh Stock Market Scam','money',1992,'HarshadMehta','5000cr','kashmir','militaryScam')";
			String query9 = "insert into scam_table values (130,'arms deals scandal','money',1997,'Abishek VArma','4-5billion','india','arms dealer&primesuspect in Scorpene submarinescase')";
			String query10 = "insert into scam_table values (131,'Wakf Board land scam','money',1992,'someOne','2,000 billion','land','possiblyBiggest land scam incountry till date')";
			String query11 = "insert into scam_table values (132,'Telgi scam','money',1992,'someOne','2,000 billion','land','possiblyBiggest land scam incountry till date')";
			String query12 = "insert into scam_table values (133,'Wakf Board land scam','stampPaper',2002,'Abdul Karim Telgi','200 billion','india','counterfeiting stamp paper in India')";
			String query13 = "insert into scam_table values (134,'The ‘Coalgate’ scam','coal',2012 ,'someOne','1.86 lakhcr','india','counterfeiting stamp paper in India')";
			String query14 = "insert into scam_table values (135,'Adarsh Housing Society scam','Building',2011,'Ashok Chavan','200 billion','colaba','politicians,bureaucrats &military officers concerning land ownership')";
			String query15 = "insert into scam_table values (136,'Broken Taxi Meter','meter',2003,'autoDrivers','2000','india','the tariff so high that the meter price goes up very quickly')";
			String query16 = "insert into scam_table values (137,'Fake SIM Card','sim',2006,'sellers','1cr','india','best to taketime to purchase an official SIM card')";
			String query17 = "insert into scam_table values (138,' The Non-Existent Hotel','hotel',2006,'sellers','1cr','india','taxiscam occurs when driver claims hotel doesn’t exist')";
			String query18= "insert into scam_table values (139,'The Costly Blessing','temple',2006,'temple-associate','1cr','india','ticket rate will be high for direct Darshan')";
			String query19 = "insert into scam_table values (140,' The Baby Milk Begging Scam','baby',2006,'beggers','1cr','india','children — will be working for a criminal gang')";
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
