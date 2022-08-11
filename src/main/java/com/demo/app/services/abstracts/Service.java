package com.demo.app.services.abstracts;

import java.util.List;

public interface Service<DTO, Entity> {
	DTO getById(long id);

	List<DTO> getAll();

	int add(DTO dto);

	int update(DTO dto);

	int delete(long id);

	Entity toEntity(DTO dto);

	DTO toDTO(Entity entity);
}
