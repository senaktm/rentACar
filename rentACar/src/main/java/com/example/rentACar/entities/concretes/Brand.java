package com.example.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="brands")
@Data
@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Brand {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="brand")   //Model tablosundaki brand kolonuyla ilişki kurar 
	private List<Model> models;		// Mantık: Bir markanın birden çok modeli olabilir
	
}
