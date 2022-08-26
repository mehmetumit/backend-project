package com.demo.app.repository;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import jakarta.persistence.Column;

/**
 * QueryEngine
 */
public class QueryEngine<T> {

	public String entityDataMapToQuery(HashMap<String, Object> data, Class<T> entityClass) {

		String query = "from " + entityClass.getSimpleName();
		List<String> queries = new LinkedList<String>();
		data.forEach((k, v) -> {
			if (v != null)
				queries.add(k + " = " + v);
		});

		if (!queries.isEmpty()) {
			query += " where ";
		}

		ListIterator<String> iterator = queries.listIterator();
		while (iterator.hasNext()) {
			query += iterator.next();
			if (iterator.hasNext())
				query += " and ";
		}
		return query;
	}
}
