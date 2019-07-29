public class NodoArbol {
    int dato;
    String nombre;
    NodoArbol hijoIzquierdo, hijoDerecho;
    public NodoArbol(int dato, String nombre){
        this.dato = dato;
        this.nombre = nombre;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }
    
    public String toString(){
        return "Nombre: ["+nombre+"] Número de nodo: ["+dato+"]";
    }
}
