public class Arbol {
    NodoArbol raiz;
    
    public Arbol(){
        raiz = null;
    }
    
    public NodoArbol buscarNodoArbol(int dato){
        NodoArbol aux = raiz;
        while(aux.dato != dato){
            if(dato < aux.dato){
                aux = aux.hijoIzquierdo;
            }else{
                aux = aux.hijoDerecho;
            }
            if(aux == null){
                return null;
            }
        }
        return aux;
    }
    
    public void inOrder(NodoArbol raiz){
        if (raiz != null){
            inOrder(raiz.hijoIzquierdo);
            System.out.println(raiz.dato);
            inOrder(raiz.hijoDerecho);
        }
    }
    
    public void preOrder(NodoArbol raiz){
        if (raiz != null){
            System.out.println(raiz.dato);
            preOrder(raiz.hijoIzquierdo);
            preOrder(raiz.hijoDerecho);
        }
    }
    
    public void postOrder(NodoArbol raiz){
        if (raiz != null){
            postOrder(raiz.hijoIzquierdo);
            postOrder(raiz.hijoDerecho);
            System.out.println(raiz.dato);
        }
    }
    
    public void agregarNodoArbol(int dato, String name){
        NodoArbol newNodoArbol = new NodoArbol(dato, name);
        if(raiz == null){
            raiz = newNodoArbol;
        }else{
            NodoArbol aux= raiz;
            NodoArbol padre;
            while(true){
                padre = aux;
                if(dato < aux.dato){
                    aux = aux.hijoIzquierdo;
                    if(aux == null){
                        padre.hijoIzquierdo = newNodoArbol;
                        return;
                    }
                }else{
                    aux = aux.hijoDerecho;
                    if(aux == null){
                        padre.hijoDerecho = newNodoArbol;
                        return;
                    }
                }
            }
        }
    }
    
    public boolean estaVacio(){
        return raiz == null;
    }
    
    public boolean eliminar(int dato){
        NodoArbol aux = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzquierdo = true;
        while(aux.dato != dato){
            padre = aux;
            if(dato < aux.dato){
                esHijoIzquierdo = true;
                aux = aux.hijoIzquierdo;
            }else{
                esHijoIzquierdo = false;
                aux = aux.hijoDerecho;
            }
            if(aux == null){
                return false;
            }
        }
        if(aux.hijoIzquierdo == null && aux.hijoDerecho == null){
            if(aux == raiz){
                raiz = null;
            }else if(esHijoIzquierdo){
                    padre.hijoIzquierdo = null;
            }else{
                padre.hijoDerecho = null;
            }
        }else if(aux.hijoDerecho == null){
                if(aux == raiz){
                raiz = aux.hijoIzquierdo;
            }else if(esHijoIzquierdo){
                    padre.hijoIzquierdo = aux.hijoIzquierdo;
            }else{
                padre.hijoDerecho = aux.hijoIzquierdo;
            }
        }
        else if(aux.hijoIzquierdo == null){
            if(aux == raiz){
                raiz = aux.hijoDerecho;
            }else if(esHijoIzquierdo){
                    padre.hijoIzquierdo = aux.hijoDerecho;
            }else{
                padre.hijoDerecho = aux.hijoDerecho;
            }        
            
        }else{
            NodoArbol reemplazo = Reemplazo(aux);
            if(aux == raiz){
                raiz = reemplazo;
            }else if(esHijoIzquierdo){
                padre.hijoIzquierdo = reemplazo;
            }else{
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = aux.hijoIzquierdo;
        }
        return true;
    }
    
    public NodoArbol Reemplazo(NodoArbol reemplazar){
        NodoArbol reemplazoParent = reemplazar;
        NodoArbol reemplazo = reemplazar;
        NodoArbol aux = reemplazar.hijoDerecho;
        while(aux != null){
            reemplazoParent = reemplazo;
            reemplazo = aux;
            aux = aux.hijoIzquierdo;
        }
        if(reemplazo != reemplazar.hijoDerecho){
            reemplazoParent.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = reemplazar.hijoDerecho;
        }
        System.out.println(reemplazo);
        return reemplazo;
    }
    
}
