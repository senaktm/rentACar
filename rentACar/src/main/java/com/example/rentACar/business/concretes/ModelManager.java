package com.example.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentACar.business.abstracts.ModelService;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.responses.GetAllBrandsResponse;
import com.example.rentACar.business.responses.GetAllModelsResponse;
import com.example.rentACar.core.utilities.mapper.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.ModelRepository;
import com.example.rentACar.entities.concretes.Brand;
import com.example.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{

	private ModelRepository _modelRepository;
	private ModelMapperService _modelMapperService;
	@Override
	public List<GetAllModelsResponse> getAll() {
		
		List<Model> models = _modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model -> this._modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());

		return modelsResponse;
	}
	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this._modelMapperService.forRequest().map(createModelRequest, Model.class);
		this._modelRepository.save(model);
		
	}

}
