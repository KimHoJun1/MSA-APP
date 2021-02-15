package com.unico.user;

import java.util.List;

public interface EntityMapper<E,D> {
	D toDTO(E e);
	List<D> toDTOList(List<E> list);

//	E toEntity(D d);
//	List<E> toEntityList(List<D> list);
}
