package GRUPO6.dao;

import org.hibernate.Session;

import GRUPO6.entity.Genero;

public class daoGenero extends DaoBase {
	public static Genero ReadOne(int id) {
		return (Genero)GetById(Genero.class, id);
	}
}
