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

@Table(name="models")
@Data
@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Model {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	
	@ManyToOne   //Farklı modellerin markası aynı olabilir
	@JoinColumn(name="brand_id") 		//brand tablosundaki brand_id kolonuyla ilişki kurar
	private Brand brand;
	
	@OneToMany(mappedBy="carModel")   	//Bir arabanın birçok modeli olabilir
	private List<Car> cars;   //car tablosundaki carModel kolonuyla ilişki kurar.
}
