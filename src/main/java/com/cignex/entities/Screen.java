package com.cignex.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "screen_master")
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "screen_name")
	private String screenName;

	@Column(name = "platinium_seats")
	private String[] platiniumSeats;

	@Column(name = "silver_seats")
	private String[] silverSeats;

	@Column(name = "gold_seats")
	private String[] goldSeats;
	@OneToMany(mappedBy = "screen")
	private List<Show> show;
	@OneToMany(mappedBy = "screen")
	private List<UserBooked> booked;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String[] getPlatiniumSeats() {
		return platiniumSeats;
	}

	public void setPlatiniumSeats(String[] platiniumSeats) {
		this.platiniumSeats = platiniumSeats;
	}

	public String[] getSilverSeats() {
		return silverSeats;
	}

	public void setSilverSeats(String[] silverSeats) {
		this.silverSeats = silverSeats;
	}

	public String[] getGoldSeats() {
		return goldSeats;
	}

	public void setGoldSeats(String[] goldSeats) {
		this.goldSeats = goldSeats;
	}

	public List<Show> getShow() {
		return show;
	}

	public void setShow(List<Show> show) {
		this.show = show;
	}

	public Screen() {
		super();
	}

}
