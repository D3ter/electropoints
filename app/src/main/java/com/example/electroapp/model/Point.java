package com.example.electroapp.model;

public class Point {
    String name, email, latitud, longitud;
    public Point(){}

    public Point(String name, String email, String latitud, String longitud) {
        this.name = name;
        this.email = email;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
