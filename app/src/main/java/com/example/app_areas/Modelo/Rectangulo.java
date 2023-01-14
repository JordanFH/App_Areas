package com.example.app_areas.Modelo;

public class Rectangulo extends FiguraG {

    public Rectangulo() {
    }

    public Rectangulo(double alto, double ancho) {
        super(alto, ancho);
    }

    public double calcularArea() {
        return (alto > 0 && ancho > 0) ? alto * ancho : -1;
    }

}
