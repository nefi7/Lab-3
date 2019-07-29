import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
    public static void principal(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion = 0, dato;
        String nombre;
        Arbol arbolPrincipal = new Arbol();
        do{
            System.out.println("Presione 1 para agregar nodo");
            System.out.println("Presone 2 para imprimir preorden");
            System.out.println("Presione 3 para imprimir postorden");
            System.out.println("Presione 4 para imprimir inorden");
            System.out.println("Presione 5 para eliminar nodo");
            System.out.println("Presione 6 para buscar nodo");
            System.out.println("Presione 7 para finalizar");
            opcion = Integer.parseInt(lector.readLine());
            if(opcion == 1){
                System.out.println("Ingrese número del nodo a insertar");
                dato = Integer.parseInt(lector.readLine());
                System.out.println("Ingrese nombre del nodo a insertar");
                nombre = lector.readLine();
                arbolPrincipal.agregarNodoArbol(dato, nombre);
            }else{
                if(opcion == 2){
                    if(!arbolPrincipal.estaVacio()){
                    System.out.println("Imprimiendo PreOrden...");
                    arbolPrincipal.preOrder(arbolPrincipal.raiz);
                    }else{
                    System.out.println("Árbol vacio");
                    }
                }else{
                    if(opcion == 3){
                        if(!arbolPrincipal.estaVacio()){
                            System.out.println("Imprimiendo PostOrden...");
                            arbolPrincipal.postOrder(arbolPrincipal.raiz);
                        }else{
                            System.out.println("Árbol vacio");
                        }
                    }else{
                        if(opcion == 4){
                            if(!arbolPrincipal.estaVacio()){
                                System.out.println("Imprimiendo inOrden...");
                                arbolPrincipal.inOrder(arbolPrincipal.raiz);
                            }else{
                                System.out.println("Árbol vacio");
                            }
                        }
                        else{
                            if(opcion == 5){
                                if(!arbolPrincipal.estaVacio()){
                                System.out.println("Ingrese número del nodo a eliminar");
                                dato = Integer.parseInt(lector.readLine());
                                arbolPrincipal.eliminar(dato);
                                if(arbolPrincipal.eliminar(dato) == false){
                                    System.out.println("Nodo no encontrado");
                                }else{
                                    System.out.println("Nodo eliminado");
                                }
                                }else{
                                    System.out.println("Árbol vacio");
                                }
                            }else{
                                if(opcion == 6){
                                    if(!arbolPrincipal.estaVacio()){
                                    System.out.println("Ingrese número del nodo a buscar");
                                    dato = Integer.parseInt(lector.readLine());
                                    arbolPrincipal.buscarNodoArbol(dato);
                                    if(arbolPrincipal.buscarNodoArbol(dato) == null){
                                        System.out.println("Nodo no encontrado");
                                    }else{
                                        System.out.println("Nodo "+arbolPrincipal.buscarNodoArbol(dato)+" encontrado");
                                    }
                                }else{
                                    System.out.println("Árbol vacio");
                                }
                                }else
                                    System.out.println("Numero no valido");
                            }
                        }
                    }
                }
            }              
        }while(opcion != 7);
    }   
}
