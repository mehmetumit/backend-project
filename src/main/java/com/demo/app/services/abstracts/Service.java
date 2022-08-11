package com.demo.app.services.abstracts;

import java.util.List;

public interface Service<DTO, Entity> {
	public DTO getById(long id);

	public List<DTO> getAll();

	public int add(DTO dto);

	public int update(DTO dto);

	public int delete(long id);

	public Entity toEntity(DTO dto);

	public DTO toDTO(Entity entity);
}
