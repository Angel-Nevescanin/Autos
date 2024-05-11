/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.autos.entities;

/**
 *
 * @author angel
 */
public class CifradoUsuarios {
    // Otros métodos de la clase

    // Método para cifrar una cadena de texto utilizando el cifrado César
public static String encriptar(String textoPlano, int desplazamiento) {
    StringBuilder textoCifrado = new StringBuilder();
    for (int i = 0; i < textoPlano.length(); i++) {
        char caracter = textoPlano.charAt(i);
        if (Character.isLetter(caracter)) {
            char inicio = Character.isUpperCase(caracter) ? 'A' : 'a';
            caracter = (char) (((caracter - inicio + desplazamiento) % 26) + inicio);
        }
        textoCifrado.append(caracter);
    }
    return textoCifrado.toString();
}

// Método para descifrar una cadena de texto cifrada utilizando el cifrado César
public static String desencriptar(String textoCifrado, int desplazamiento) {
    // Para descifrar, simplemente cambiamos el desplazamiento a negativo
    // Ajustamos el desplazamiento para que sea un valor positivo dentro del rango del alfabeto (0 a 25)
    int desplazamientoNegativo = (26 - desplazamiento) % 26;
    return encriptar(textoCifrado, desplazamientoNegativo);
}


}
