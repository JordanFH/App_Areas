package com.example.app_areas.Modelo;

public class Circulo extends FiguraG {

    public Circulo() {
    }

    public Circulo(double alto, double ancho) {
        super(alto, ancho);
    }

    public double calcularArea() {
        return (alto == ancho && alto > 0) ? Math.PI * Math.pow((ancho / 2), 2) : -1;
    }

}
