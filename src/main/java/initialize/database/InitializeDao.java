package initialize.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeDao {
	
	private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String dbAddress = "jdbc:mysql://localhost:6000/";
    private String dbName = "ppsdb";
    private String userName = "GolamT313";
    private String password = "Gmaster123!";

    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet result;
    private Connection con;

    public boolean initialize() throws ClassNotFoundException {
        boolean status = false;
        
        String[][] userList = {
        			{"root", "pass1234", "root", "root", "0", "0", "0", "0", "0", "0", "1000000000", "0"},
        			{"johnsmith@gmail.com", "johnsmith", "John", "Smith", "10-14-1997", "7641", "Oak Lane", "Detroit", "MI", "48202", "0", "1000.0"},
        			{"angieschnell@gmail.com", "angieschnell", "Angie", "Schnell", "11-18-1964", "1013", "Hornor Avenue", "Tulsa", "OK", "74134", "0", "1000.0"},
        			{"lindapogue@gmail.com", "lindapogue", "Linda", "Pogue", "2-3-1987", "136", "Sycamore Fork Road", "Hopkins", "MN", "55343", "0", "1000.0"},
        			{"gradyearles@gmail.com", "gradyearles", "Grady", "Earles", "3-22-1961", "3577", "Ingram Street", "Dayton", "OH", "45402", "0", "1000.0"},
        			{"crystalhenson@gmail.com", "crystalhenson", "Crystal", "Henson", "6-22-1969", "2119", "Spring Street", "Bowen", "IL", "62316", "0", "1000.0"},
        			{"tracymcfadden@gmail.com", "tracymcfadden", "Tracy", "McFadden", "4-27-1997", "4511", "Pine Street", "Indiana", "PA", "15701", "0", "1000.0"},
        			{"richardnolan@gmail.com", "richardnolan", "Richard", "Nolan", "11-21-1981", "4417", "Wescam Court", "Reno", "NV", "89501", "0", "1000.0"},
        			{"anthonyneil@gmail.com", "anthonyneil", "Anthony", "Neil", "10-22-1997", "1627", "Ocello Street", "San Diego", "CA", "92111", "0", "1000.0"},
        			{"timrodriguez@gmail.com", "timrodriguez", "Tim", "Rodriguez", "4-1-1958", "4959", "Rodney Street", "Fairview Heights", "MO", "62208", "0", "1000.0"},
        			{"robertmoncrief@gmail.com", "robertmoncrief", "Robert", "Moncrief", "1-7-1950", "98", "James Martin Circle", "Columbus", "OH", "43201", "0", "1000.0"}
        		};
        
        String[][] transactionList = { 
        		{"johnsmith@gmail.com", "angieschnell@gmail.com", "138", "0", "2022-03-11 14:22:10", "tip", "0.01"},
    			{"angieschnell@gmail.com", "lindapogue@gmail.com", "145", "0", "2022-03-10 08:12:11", "tip", "0.01"},
    			{"lindapogue@gmail.com", "gradyearles@gmail.com", "87", "0", "2022-02-17 06:11:11", "tip", "0.01"},
    			{"gradyearles@gmail.com", "crystalhenson@gmail.com", "73", "0", "2022-05-18 18:05:45", "tip", "0.01"},
    			{"root", "lindapogue@gmail.com", "1875", "0", "2022-07-14 08:06:44", "buy", "0.01"},
    			{"crystalhenson@gmail.com", "tracymcfadden@gmail.com", "450", "0", "2022-01-12 13:04:22", "tip", "0.01"},
    			{"richardnolan@gmail.com", "robertmoncrief@gmail.com", "1517", "0", "2021-12-13 14:07:49", "tip", "0.01"},
    			{"robertmoncrief@gmail.com", "root", "181", "0", "2022-06-15 09:01:11", "sell", "0.01"},
    			{"timrodriguez@gmail.com", "anthonyneil@gmail.com", "18987", "0", "2022-02-13 14:07:17", "tip", "0.01"},
    			{"richardnolan@gmail.com", "lindapogue@gmail.com", "1785", "0", "2022-04-01 04:02:18", "tip", "0.01"}
    		};
        
        String[][] followList = {
        		{"robertmoncrief@gmail.com", "timrodriguez@gmail.com"},
        		{"timrodriguez@gmail.com", "richardnolan@gmail.com"},
        		{"gradyearles@gmail.com", "angieschnell@gmail.com"},
        		{"angieschnell@gmail.com", "lindapogue@gmail.com"},
        		{"lindapogue@gmail.com", "gradyearles@gmail.com"},
        		{"gradyearles@gmail.com", "timrodriguez@gmail.com"},
        		{"crystalhenson@gmail.com", "lindapogue@gmail.com"},
        		{"richardnolan@gmail.com", "johnsmith@gmail.com"},
        		{"crystalhenson@gmail.com", "tracymcfadden@gmail.com"},
        		{"angieschnell@gmail.com", "johnsmith@gmail.com"}
        };
        
        String[][] tweetsList = {
        		{"The rain was coming. Everyone thought this would be a good thing. It hadn't rained in months and the earth was dry as a bone.", "johnsmith@gmail.com", "2022-12-23 02:36:41"},
        		{"“Ingredients for life,” said the backside of the truck. They mean food, but really food is only 1 ingredient of life.", "angieschnell@gmail.com", "2022-04-23 12:38:44"},
        		{"He had disappointed himself more than anyone else. That wasn't to say that he hadn't disappointed others.", "lindapogue@gmail.com", "2022-11-22 12:38:44"},
        		{"It really doesn't matter what she thinks as it isn't her problem to solve. That's what he kept trying to convince himself.", "gradyearles@gmail.com", "2022-01-03 12:38:44"},
        		{"There was nothing else to do. The deed had already been done and there was no going back.", "crystalhenson@gmail.com", "2022-11-23 12:38:44"},
        		{"There had been no mistakes throughout the entire process. It had been perfection and he knew it without a doubt.", "tracymcfadden@gmail.com", "2022-11-23 12:38:44"},
        		{"One can cook on and with an open fire. These are some of the ways to cook with fire outside. Cooking meat using a spit is a great way to evenly cook meat.", "richardnolan@gmail.com", "2022-11-23 12:38:44"},
        		{"All he wanted was a candy bar. It didn't seem like a difficult request to comprehend, but the clerk remained frozen.", "anthonyneil@gmail.com", "2022-11-23 12:38:44"},
        		{"The thing that's great about this job is the time sourcing the items involves no traveling.", "timrodriguez@gmail.com", "2022-11-23 12:38:44"},
        		{"There were a variety of ways to win the game. James had played it long enough to know most of them.", "robertmoncrief@gmail.com", "2022-11-23 12:38:44"}
        };
        
        String[][] commentsList = {
        		{"Morbi blandit cursus risus at ultrices mi tempus imperdiet nulla.", "2022-11-09 18:07:01", "1", "johnsmith@gmail.com"},
        		{"At risus viverra adipiscing at in tellus integer.", "2022-12-22 09:06:45", "2", "angieschnell@gmail.com"},
        		{"Nibh mauris cursus mattis molestie a iaculis at.", "2022-02-11 07:11:32", "3", "lindapogue@gmail.com"},
        		{"At volutpat diam ut venenatis tellus in metus vulputate.", "2022-04-18 17:05:55", "4", "gradyearles@gmail.com"},
        		{"Fames ac turpis egestas sed.", "2022-09-13 11:06:31", "5", "crystalhenson@gmail.com"},
        		{"Faucibus ornare suspendisse sed nisi. Faucibus scelerisque eleifend donec pretium vulputate.", "2022-07-19 06:01:13", "6", "tracymcfadden@gmail.com"},
        		{"Aliquam faucibus purus in massa tempor.", "2022-11-17 16:02:24", "7", "richardnolan@gmail.com"},
        		{"Netus et malesuada fames ac turpis egestas.", "2022-03-11 03:01:36", "8", "anthonyneil@gmail.com"},
        		{"Id nibh tortor id aliquet.", "2022-01-15 05:09:37", "9", "timrodriguez@gmail.com"},
        		{"Ipsum a arcu cursus vitae congue mauris rhoncus aenean.", "2022-08-13 01:04:15", "10", "robertmoncrief@gmail.com"}
        };
        
        String[][] likesList = {
        	{"1", "johnsmith@gmail.com"},
        	{"2", "angieschnell@gmail.com"},
        	{"2", "lindapogue@gmail.com"},
        	{"4", "gradyearles@gmail.com"},
        	{"1", "crystalhenson@gmail.com"},
        	{"6", "tracymcfadden@gmail.com"},
        	{"2", "richardnolan@gmail.com"},
        	{"6", "anthonyneil@gmail.com"},
        	{"3", "timrodriguez@gmail.com"},
        	{"9", "robertmoncrief@gmail.com"},
        };
        
        String usersTable = "CREATE TABLE Users ("
                + "username VARCHAR(50) NOT NULL UNIQUE,"
                + "password VARCHAR(50) NOT NULL,"
                + "firstname VARCHAR(50),"
                + "lastname VARCHAR(50),"
                + "birthday VARCHAR(50),"
                + "streetnumber INTEGER,"
                + "street VARCHAR(50),"
                + "city VARCHAR(50),"
                + "state VARCHAR(50),"
                + "zipcode INTEGER,"
                + "ppsbalance INTEGER,"
                + "bankbalance DOUBLE,"
                + "PRIMARY KEY(username))";
        
        String transactionsTable = "CREATE TABLE Transactions (" 
                + "transid INTEGER NOT NULL AUTO_INCREMENT,"
                + "fromuser VARCHAR(50),"
                + "touser VARCHAR(50),"
                + "ppsamt INTEGER,"
                + "dollaramt DOUBLE,"
                + "`when` DATETIME,"
                + "transtype VARCHAR(50),"
                + "price DOUBLE,"
                + "check(transtype IN ('buy', 'sell', 'tip')),"
                + "PRIMARY KEY (transid),"
        		+ "FOREIGN KEY (fromuser) REFERENCES Users(username),"
        		+ "FOREIGN KEY (touser) REFERENCES Users(username))";
        
        String followTable = "CREATE TABLE Follow (" 
                + "followerid VARCHAR(50),"
                + "followeeid VARCHAR(50),"
                + "PRIMARY KEY (followerid, followeeid),"
                + "FOREIGN KEY (followerid) REFERENCES Users(username),"
                + "FOREIGN KEY (followeeid) REFERENCES Users(username))";
                
        String tweetsTable = "CREATE TABLE Tweets (" 
                + "tweetid INTEGER NOT NULL AUTO_INCREMENT,"
        		+ "content VARCHAR(200),"
                + "author VARCHAR(100) NOT NULL,"
        		+ "`when` DATETIME,"
                + "PRIMARY KEY (tweetid),"
        		+ "FOREIGN KEY (author) REFERENCES Users(username))";
        
        String commentTable = "CREATE TABLE Comments (" 
                + "id INTEGER NOT NULL AUTO_INCREMENT,"
        		+ "`desc` VARCHAR(200),"
        		+ "`when` DATETIME,"
        		+ "tweetid INTEGER NOT NULL,"
        		+ "commentor VARCHAR(100),"
                + "PRIMARY KEY (id),"
        		+ "FOREIGN KEY (tweetid) REFERENCES Tweets(tweetid),"
        		+ "FOREIGN KEY (commentor) REFERENCES Users(username))";
        
        String likesTable = "CREATE TABLE Likes (" 
                + "tweetid INTEGER NOT NULL,"
        		+ "userid VARCHAR(100),"
                + "PRIMARY KEY (tweetid, userid),"
        		+ "FOREIGN KEY (tweetid) REFERENCES Tweets(tweetid),"
        		+ "FOREIGN KEY (userid) REFERENCES Users(username))";
                
        Class.forName("com.mysql.jdbc.Driver");

        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            System.out.println();
            try {
            statement.executeUpdate("DROP TABLE IF EXISTS Comments");
            statement.executeUpdate("DROP TABLE IF EXISTS Likes");
            statement.executeUpdate("DROP TABLE IF EXISTS Tweets");
            statement.executeUpdate("DROP TABLE IF EXISTS Transactions");
            statement.executeUpdate("DROP TABLE IF EXISTS Follow");
            statement.executeUpdate("DROP TABLE IF EXISTS Users");
            } catch (SQLException e) {
            	e.printStackTrace();
            }
            
            
            statement.executeUpdate(usersTable);
            statement.executeUpdate(transactionsTable);
            statement.executeUpdate(followTable);
            statement.executeUpdate(tweetsTable);
            statement.executeUpdate(commentTable);
            statement.executeUpdate(likesTable);
            System.out.println("Tables Created");
            for(int i = 0; i < userList.length; i++) {
            	statement.executeUpdate("INSERT INTO users VALUES ('" + userList[i][0] +"', '" + userList[i][1] + "', '" + userList[i][2] + "', '" + userList[i][3] + "', '" + userList[i][4] + "', " + userList[i][5] + ", '" + userList[i][6] + "', '" + userList[i][7] + "', '" + userList[i][8] + "', " + userList[i][9] + ", " + userList[i][10] + ", " + userList[i][11] + ")");
            }
            for(int i = 0; i < transactionList.length; i++) {
            	statement.executeUpdate("INSERT INTO transactions (fromuser, touser, ppsamt, dollaramt, `when`, transtype, price) VALUES ('" + transactionList[i][0] + "', '" + transactionList[i][1] + "', " + transactionList[i][2] + ", " + transactionList[i][3] + ", '" + transactionList[i][4] + "', '" + transactionList[i][5] + "', " + transactionList[i][6] + ")");
            }
            for(int i = 0; i < followList.length; i++) {
            	statement.executeUpdate("INSERT INTO follow (followerid, followeeid) VALUES (" + "\"" + followList[i][0] + "\"" + ", "  + "\"" + followList[i][1]  + "\"" + ")");
            }
            for(int i = 0; i < tweetsList.length; i++) {
            	statement.executeUpdate("INSERT INTO tweets (content, author, `when`) VALUES (" + "\"" + tweetsList[i][0] + "\"" + ", " + "\"" + tweetsList[i][1] + "\"" + ", " + "\"" + tweetsList[i][2] + "\"" + ")");
            }
            for(int i = 0; i < commentsList.length; i++) {
            	statement.executeUpdate("INSERT INTO `comments` (`desc`, `when`, tweetid, commentor) VALUES (" + "\"" + commentsList[i][0] + "\"" + ", " + "\"" + commentsList[i][1] + "\"" + ", " + "\"" + commentsList[i][2] + "\"" + ", " + "\"" + commentsList[i][3] + "\"" + ")");
            }
            for(int i = 0; i < likesList.length; i++) {
            	statement.executeUpdate("INSERT INTO likes VALUES (" + "\"" + likesList[i][0] + "\"" + ", " + "\"" + likesList[i][1] + "\"" + ")");
            }
            status = true;
        }
        catch (SQLException e ) {
            System.out.println("An error has occured on Table Creation");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("An Mysql drivers were not found");
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}