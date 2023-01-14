package com.example.app_areas.Modelo;

public class Triangulo extends FiguraG {

    public Triangulo() {
    }

    public Triangulo(double alto, double ancho) {
        super(alto, ancho);
    }

    public double calcularArea() {
        return (ancho > 0 && alto > 0) ? (alto * ancho) / 2 : -1;
    }

}
