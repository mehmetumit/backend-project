package com.demo.app.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * QueryEngine
 */
public class QueryEngine<T> {
	private String query = "";

	public QueryEngine<T> whereEqualEntityDataMap(HashMap<String, Object> data) {
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
		return this;
	}

	public QueryEngine<T> where() {
		query += " where ";
		return this;
	}

	public QueryEngine<T> equal(String columnName, Object val) {
		query += columnName + " = " + val.toString();
		return this;
	}

	public QueryEngine<T> from(Class<T> entityClass) {
		query += " from " + entityClass.getSimpleName();
		return this;
	}

	public QueryEngine<T> join(String joinObject) {
		query += " join " + joinObject;
		return this;
	}

	public QueryEngine<T> joinAs(String joinObject, String name) {
		query += " join " + joinObject + " " + name;
		return this;
	}

	public String build() {
		return query;
	}
}
