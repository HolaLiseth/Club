package com.ClubFutbol.app.variable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="asociaciones")
public class Asociacion {
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
private Integer id;
private String nombre;
private String pais;
private String presidente;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getPais() {
	return pais;
}

public void setPais(String pais) {
	this.pais = pais;
}

public String getPresidente() {
	return presidente;
}

public void setPresidente(String presidente) {
	this.presidente = presidente;
}

}
