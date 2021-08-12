package com.ss.flight_service.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {
	
    @Id
    @Column(name = "id")
	private Integer flightId;
    
    @Column(name = "route_id")
	private Integer routeId;
    
    @Column(name = "airplane_id")
	private Integer airplaneId;
	
	@Column(name = "departure_time")
	private Timestamp departureTime;
	
	@Column(name = "reserved_seats")
	private Integer reservedSeats;
	
	@Column(name = "seat_price")
	private Float seatPrice;

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Integer getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(Integer airplaneId) {
		this.airplaneId = airplaneId;
	}

	public Timestamp getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	public Integer getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public Float getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(Float seatPrice) {
		this.seatPrice = seatPrice;
	}
	
}

   