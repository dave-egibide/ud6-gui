package com.dave;

import java.util.Comparator;

class ComparadorNombre implements Comparator<Contacto> {
    @Override
    public int compare(Contacto a, Contacto b) {
        return a.getNombre().compareToIgnoreCase(b.getNombre());
    }
}
