# test_startdoit
this is a test proyect to apply to a job.

## TEST BÁSICO DE CONOCIMIENTOS EN PROGRAMACIÓN ORIENTADA A OBJETOS 
### Preguntas de seleccion multiple
1. ¿Cuál es la descripción que crees que define mejor el concepto ‘clase’ en la
programación orientada a objetos?
  c) Es un modelo o plantilla a partir del cual creamos objetos.
2.  ¿Qué elementos cree que definen un objeto?
b) Sus atributos y métodos
3. ¿Cuál de las siguientes sentencias tiene que ver con la herencia?
a) Public class Component extends Producto
4. ¿Qué es el bytecode en Java?
b) El formato que obtenemos tras compilar un fuente .java
5. ¿Qué código asociarías a una Interfaz en Java?
c) public class Componente implements Printable
6. ¿Qué significa la sobrecarga (overload) de un método?
c) Crear un método con el mismo nombre pero diferentes argumentos
## TEST BÁSICO EN RESOLUCIÓN DE PROBLEMAS Y ALGORITMOS
7. En el espacio marcado con __ hace falta una pieza de código necesaria para indicarle al algoritmo cuando la variable int0 es divisible por 5. Marca la opción correcta.
boolean isDivisibleBy5 = __
d) int0 % 5 ==0
8. ¿Cuántas veces el código imprime “Hola Mundo!” ?
b) 5 veces
9. Ordenamiento de vectores:
a) Se debe crear un vector de 100 posiciones y cargarlo dinámicamente con valores
entre 1 y 100000:

```java
public static Vector CreateVector(){
        Vector toret = new Vector(100);
        Random ran_gen= new Random();
        for(int i=0;i<100;i++){
            toret.add(ran_gen.nextInt(1000)+1);
        }
        return toret;
    }
```
b) Se debe ordenar el vector de mayor a menor.
```java
class Comp implements Comparator<Integer>{
    
    public int compare(Integer obj1, Integer obj2){
        return(obj2.compareTo(obj1));
    }
}

public static Vector CreateVector(){
        Vector toret = new Vector(100);
        Random ran_gen= new Random();
        for(int i=0;i<100;i++){
           int next_rand = ran_gen.nextInt(1000)+1;
            toret.add(next_rand);
        }
        toret.sort(new Comp());
        return toret;
    }
```
c) Imprimir el resultado en pantalla.

```java
public static void PrintVector(Vector v){
        if(v.size() == 0){
           System.out.print("error: void vector"); 
        }else{
            for(int i=0;i<v.size();i++){
                if(i % 10 == 0 ){
                    System.out.print("\n");
                }
                System.out.print("  "+v.get(i));
            }
        }
    }
```
10. Operaciones Aritméticas: Se debe crear una función que permita elevar un número A, a
otro número B solo usando sumas.
```java
public static int pow(int a, int b){
        int acumulatorTotal=0;
        int acumulatorbySection=0;
        
        if(b>0){
            acumulatorTotal = a;
        }else{
            System.out.println("Error: power b it's zero or negative.");
            return 0;
        }
        for(int i=0;i<b-1;i++){
            acumulatorbySection = acumulatorTotal;
            for(int j=0;j<a-1;j++){
                acumulatorTotal+=acumulatorbySection;
            }
        }
        return acumulatorTotal;
    }
```
