/**
 * 
 */
package com.soen6471.ticketbooking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soen6471.ticketbooking.components.BookingInfoComponent;
import com.soen6471.ticketbooking.components.MovieComponent;
import com.soen6471.ticketbooking.components.UserComponent;

/**
 * @author fly
 *
 */
public class TicketDao {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement preparedStmt = null;
	ResultSet rs = null;
	
	String sql = null;

	/*
	 * public int updateBookingTable(BookingInfoComponent bookInfo) { int row=0; try
	 * { sql="INSERT INTO booking_info ()"; dbConnection =new DBConnection(); conn =
	 * dbConnection.getDataSource().getConnection();
	 * 
	 * preparedStmt = conn.
	 * prepareStatement("select userName,pass from student where userName=? and pass=?"
	 * ); preparedStmt.setString(1, un); preparedStmt.setString(2, pw);
	 * //preparedStmt.setString(2, );
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); } return row; }
	 * 
	 */

	public String checkLogin(UserComponent user) {
		boolean row = false;
		String fname = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_table", "root", "root");

			if (con != null) {
				System.out.println("Connected");
				preparedStmt = con
						.prepareStatement("SELECT * FROM movie_table.User_Info where email_id=? and mpassword=?");
				preparedStmt.setString(1, user.getEmail());
				preparedStmt.setString(2, user.getPassword());

				ResultSet rs = preparedStmt.executeQuery();

				while (rs.next()) {
					row = true;
					fname = rs.getString(2);

				}

			}
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fname;
	}

	
	
	public String bookTicket(BookingInfoComponent bookingInfo)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_table", "root", "root");

			if (con != null) {
				System.out.println("Connected");
				preparedStmt = con
						.prepareStatement("INSERT into movie_table.Booking_Info1 (movie_id, Seat_id, Showtime_id, user_Id) values(?, ?, ?, ?)");
				preparedStmt.setInt(1, bookingInfo.getMovie().getMovieId());
				preparedStmt.setInt(2, bookingInfo.getSeatnumber());
				preparedStmt.setString(3, bookingInfo.getShowTime());
				preparedStmt.setString(4, bookingInfo.getUser().getFirstName());
				int row = preparedStmt.executeUpdate();

				while (row>0) {
					return "success";

				}

			}
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";

	}
	
	
	
	public String getMovieName(int movieId)
	{
		String movieName=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_table", "root", "root");

			if (con != null) {
				System.out.println("Connected");
				preparedStmt = con.prepareStatement(" SELECT name_of_movie from movie_table.movie_info WHERE movie_id=?");
				preparedStmt.setInt(1, movieId);
				
				ResultSet rs= preparedStmt.executeQuery();

				while (rs.next()) {
					movieName=rs.getString(1);

				}

			}
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieName;

	}
	
	public List<MovieComponent> getAllMovieDetails()
	{
		ArrayList<MovieComponent> movieDetails=new ArrayList();
		MovieComponent movie;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_table", "root", "root");

			if (con != null) {
				preparedStmt = con.prepareStatement(" SELECT movie_id, name_of_movie FROM movie_table.movie_info ");
				ResultSet rs= preparedStmt.executeQuery();
				
				while(rs.next())
				{
					movie=new MovieComponent();
					movie.setMovieId(rs.getInt(1));
					movie.setMovieName(rs.getString(2));
					movieDetails.add(movie);
				}
				
			}
		}
		
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return movieDetails;
	}
	
	public String addMovie(MovieComponent movie)
	{
		int row=0;
		String result=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_table", "root", "root");

			if (con != null) {
				preparedStmt = con.prepareStatement("  INSERT INTO movie_table.Movie_Info (Name_of_movie, Movie_length,mDescription)\r\n" + 
						"   VALUES (?,?,?)");
				preparedStmt.setString(1, movie.getMovieName());
				preparedStmt.setInt(2, movie.getMovieLength());
				preparedStmt.setString(3, movie.getDescription());
				row = preparedStmt.executeUpdate();

				while (row>0) {
					return "success";
				}
			}
		}
				catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return result;
	}
}
