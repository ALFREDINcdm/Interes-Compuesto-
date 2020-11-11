public class InteresCompuesto
{

    /** Interes compuesto de una cantidad con cierto interes y cierto plazo o tiempo en años*/

    static float InvesionCompuesta(float capital,float interes,int plazo){
        if(interes>1)  interes = interes/100;
        if(plazo==0) return capital;
        return (1 + interes) * InvesionCompuesta(capital,interes, plazo - 1);
    }

    /** Inversion inicial y final  */

    static void Proyeccion(float capital,float interes, int plazo){
        System.out.printf("Inversion Inicial                 :$%,5.2f%n", capital);
        System.out.printf("Años a proyectar la inversion     :%6d%n",       plazo);
        System.out.printf("Utilidad final de la Inversion    :$%,5.2f%n",
                                          InvesionCompuesta(capital, interes, plazo));
    }

    /** Tabla proyecta en cierto año*/
    static void TablaInversion(float capital,float interes, int plazo){
        System.out.println("# Años| Utilidad $");
        System.out.println("------------------");

        for(int i = 0; i <= plazo; i++){
            System.out.printf("%5d   %,5.2f%n",i, InvesionCompuesta(capital, interes, i));
        }

    }

    /** {"capital","interes","plazo"}   */
    public static void main(String [] args){
        float capital = 100000;
        float interes = 7;
        int plazo = 5;

        if(args.length == 3){
            capital = Float.parseFloat(args[0]);
            interes = Float.parseFloat(args[1]);
            plazo = Integer.parseInt(args[2]);
        }

        Proyeccion(capital, interes, plazo);

        System.out.println();

        System.out.println("Tabla Proyectada en un plazo propuesto");
        TablaInversion(capital, interes, plazo);

    }
}
