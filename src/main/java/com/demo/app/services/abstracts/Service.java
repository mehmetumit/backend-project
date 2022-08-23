package com.demo.app.services.abstracts;

import java.util.List;

public interface Service<DTO, Entity> {
	public DTO getById(int id);

	public List<DTO> getAll();

	public int add(DTO dto);

	public int update(int id, DTO dto);

	public int delete(int id);

	public Entity toEntity(DTO dto);

	public DTO toDTO(Entity entity);
}
