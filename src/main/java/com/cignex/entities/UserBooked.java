package com.cignex.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_booked")
public class UserBooked {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String[] bookedSeats;
	private Date date;
	private Time time;
	private int total;
	@ManyToOne
	private Movie movie;
	@ManyToOne
	private Screen screen;
	@ManyToOne
	@JoinColumn(name="uid")
	private User user;
	@ManyToOne
	private Show show;
	

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the show
	 */
	public Show getShow() {
		return show;
	}

	/**
	 * @param show the show to set
	 */
	public void setShow(Show show) {
		this.show = show;
	}

	public UserBooked(int id, String[] bookedSeats, Date date, Time time, Movie movie, Screen screen, User user) {
		super();
		this.id = id;
		this.bookedSeats = bookedSeats;
		this.date = date;
		this.time = time;
		this.movie = movie;
		this.screen = screen;
		this.user = user;
	}

	public UserBooked() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the bookedSeats
	 */
	public String[] getBookedSeats() {
		return bookedSeats;
	}

	/**
	 * @param bookedSeats the bookedSeats to set
	 */
	public void setBookedSeats(String[] bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Time time) {
		this.time = time;
	}

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * @param screen the screen to set
	 */
	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	/**
	 * @return the screen
	 */
	public Screen getScreen() {
		return screen;
	}
}
