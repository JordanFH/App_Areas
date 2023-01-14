package com.example.app_areas.Modelo;

public class Cuadrado extends FiguraG {

    public Cuadrado() {
    }

    public Cuadrado(double alto, double ancho) {
        super(alto, ancho);
    }

    public double calcularArea() {
        return (alto == ancho && alto > 0) ? alto * ancho : -1;
    }

}
