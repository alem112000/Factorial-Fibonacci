package actividad2;

/**
 *
 * @author Alejandro Emmanuel Rangel Mendez y Luis Diego Jiménez Delgado
 *grupo: 5IM6

 */
public class Factorial {
    //Clase de una serie con el que se regresa el nuemro enviado en factorail
    public int convertir (int numero){
        int resultado = 0;
        for(int i =  0 ; i <= numero; ++i ){
            if (i == 0){
                resultado = 1;
            }
            else {
                resultado = resultado * i;
            }
        }
        return resultado;
    }
}
