package com.cignex.entities;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cignex.constant.Constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = Constant.MOVIE_TABLE)
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "duration_time")
	private String durationTime;
	@Column(name = "total_show_per_day")
	private Integer totalShowPerDay;
	@Column(name = "movie_path")
	private String moviePath;
	@Column(name = "rate")
	private Integer rate;
	@Column(name = "cast")
	private String cast;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}

	public Integer getTotalShowPerDay() {
		return totalShowPerDay;
	}

	public void setTotalShowPerDay(Integer totalShowPerDay) {
		this.totalShowPerDay = totalShowPerDay;
	}

	public String getMoviePath() {
		return moviePath;
	}

	public void setMoviePath(String moviePath) {
		this.moviePath = moviePath;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public Movie() {
		super();
	}

}
