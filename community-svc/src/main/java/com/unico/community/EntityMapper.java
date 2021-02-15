package com.unico.community;

import java.util.List;

public interface EntityMapper<E,D> {
	D toDTO(E e);
	List<D> toDTOList(List<E> list);
}
