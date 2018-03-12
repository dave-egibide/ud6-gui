package com.dave;

import java.util.Objects;

public class Contacto implements Comparable<Contacto> {
    private String nombre, telefono, email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return Objects.equals(telefono, contacto.telefono);
    }

    @Override
    public int hashCode() {

        return Objects.hash(telefono);
    }


    @Override
    public int compareTo(Contacto o) {
        return this.getTelefono().compareToIgnoreCase(o.getTelefono());
    }
}
