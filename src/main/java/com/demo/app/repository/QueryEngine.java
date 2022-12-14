package com.demo.app.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * QueryEngine
 * Simple Query builder class as string
 *
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
		// Put "and" between queries
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
		query += " from " + entityClass.getName();
		return this;
	}

	public QueryEngine<T> join(String joinObject) {
		query += " join " + joinObject;
		return this;
	}

	public QueryEngine<T> joinAs(String joinObjectName, String nameAs) {
		query += " join " + joinObjectName + " " + nameAs;
		return this;
	}

	public String build() {
		return query;
	}
}
