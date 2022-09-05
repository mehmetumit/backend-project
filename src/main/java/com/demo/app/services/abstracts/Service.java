package com.demo.app.services.abstracts;

import java.util.HashMap;
import java.util.List;

public interface Service<DTO, Entity> {
	public DTO getById(int id);

	public List<DTO> getAll();

	public DTO add(DTO dto);

	public DTO update(int id, DTO dto);

	public int delete(int id);

	public Entity toEntity(DTO dto);

	public DTO toDTO(Entity entity);

	public List<DTO> findAll(HashMap<String, Object> dataMap);
}
