package com.cignex.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie_show")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Movie movie;
	@ManyToOne
	private Screen screen;
	private String[] bookedSeats;
	private String paymentType;
	@Column(name = "show_date")
	private Date date;
	private int platiniumPrice;
	private int silverPrice;
	private int goldPrice;
	private Time time;
	@OneToMany(mappedBy="show")
	private List<UserBooked> booked;

	public int getPlatiniumPrice() {
		return platiniumPrice;
	}

	public void setPlatiniumPrice(int platiniumPrice) {
		this.platiniumPrice = platiniumPrice;
	}

	public int getSilverPrice() {
		return silverPrice;
	}

	public void setSilverPrice(int silverPrice) {
		this.silverPrice = silverPrice;
	}

	public int getGoldPrice() {
		return goldPrice;
	}

	public void setGoldPrice(int goldPrice) {
		this.goldPrice = goldPrice;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(String[] bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
