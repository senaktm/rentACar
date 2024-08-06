package com.example.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentACar.entities.concretes.Brand;
import com.example.rentACar.entities.concretes.Model;

@Repository
public interface ModelRepository  extends JpaRepository<Model,Integer> {

}
