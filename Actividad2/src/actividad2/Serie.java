package actividad2;

/**
 *
 * @author Alejandro Emmanuel Rangel Mendez y Luis Diego Jiménez Delgado
 *grupo: 5IM6

 */
public class Serie {
    //Clase de una serie con el que se regresa que la serie de fibonaccci
    public String series(int numero)
    {
        String valor="";
        long posicion [] = new long [numero];
        posicion[0]=0;
        posicion[1]=1;
        for(int i=0; i<numero; ++i)
        {
            if(i>1)
            {
                posicion[i]=posicion[i-1]+posicion[i-2];
                System.out.println(posicion[i]);
            }
            valor = valor + posicion[i]+",";
        }
        
        return valor;
    }
}
