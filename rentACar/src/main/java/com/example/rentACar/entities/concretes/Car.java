package com.example.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="cars")
@Data
@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="plate")
	private String plate;
	
	@Column(name="dailyPrice")
	private double dailyPrice;
	
	@Column(name="modelYear")
	private int modelYear;
	
	@Column(name="state")
	private int state;    //1: available 2: rented 3:maintenance
	
	@ManyToOne       //Birden fazla arabanın modeli aynı olabilir
	@JoinColumn(name="model_id")	//model tablosundaki model_id kolonuyla ilişki kurar
	private Model carModel;
}
