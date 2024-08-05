package com.example.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandsResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.core.utilities.mapper.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import com.example.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service // Bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository _brandRepository;
	private ModelMapperService _modelMapperService;

	@Override
	public List<GetAllBrandsResponse> getAll() {

		List<Brand> brands = _brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this._modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());

		return brandsResponse;

	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		Brand brand = this._modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this._brandRepository.save(brand);

	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this._modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this._brandRepository.save(brand);

	}

	@Override
	public void delete(int id) {
		this._brandRepository.deleteById(id);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this._brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response = this._modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}

}
