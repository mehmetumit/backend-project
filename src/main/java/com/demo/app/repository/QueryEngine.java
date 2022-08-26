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

	// public HashMap<String, Object> generateEntityDataMap(Class<T> entityClass) {
	// ArrayList<String> columnNames = new ArrayList<>();
	// HashMap<String, Object> dataMap = new HashMap<String, Object>();

	// for (Method method : entityClass.getMethods()) {
	// Column col = method.getAnnotation(Column.class);
	// if (col != null)
	// columnNames.add(col.name());
	// }
	//// Generates hash map with entity column names
	// columnNames.forEach(cn -> {
	// dataMap.put(cn, null);
	// });

	// return dataMap;
	// }

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
