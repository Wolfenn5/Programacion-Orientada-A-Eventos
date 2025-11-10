package uam.pvoe.practica.modelo;

public class ConversorTemperatura {
    public static double[] convertir(double valor, String origen){
        double centigrados = 0, fahrenheit = 0, kelvin = 0;
        switch(origen){
            case "Centigrados":
                centigrados = valor;
                fahrenheit = centigrados * 9 / 5 + 32;
                kelvin = centigrados + 273.15;
                break;
            case "Fahrenheit":
                fahrenheit = valor;
                centigrados = (fahrenheit - 32) * 5 / 9;
                kelvin = centigrados + 273.15;
                break;
            case "Kelvin":
                kelvin = valor;
                centigrados = kelvin - 273.15;
                fahrenheit = centigrados * 9 / 5 + 32;
                break;
        }
        return new double[]{centigrados, fahrenheit, kelvin};
    }
}
