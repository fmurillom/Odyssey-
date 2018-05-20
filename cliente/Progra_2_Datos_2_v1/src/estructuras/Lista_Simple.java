package estructuras;

import auxiliar.Nodo;

/**
 * Clase utilizada como representacion de una lista simple
 * @param <T> Parametro generico
 */
public class Lista_Simple<T>
{
    private int cantidad_de_nodos;
    private Nodo<T> primero, ultimo;


    public Lista_Simple(){}


    /**
     * Obtiene la cantidad de los nodos de la lista
     * @return
     */
    public int getCantidad_de_nodos(){return cantidad_de_nodos;}

    /**
     * metodo para setiar la cantidad de nodos en la lista
     * @param cantidad_de_nodos
     */
    public void setCantidad_de_nodos(int cantidad_de_nodos){this.cantidad_de_nodos = cantidad_de_nodos;}


    /**
     * retorna el primer elemento de la lista
     * @return
     */
    public Nodo<T> getPrimero(){return primero;}

    /**
     * Asigna el primer elemento de la lista
     * @param primero
     */
    public void setPrimero(Nodo<T> primero){this.primero = primero;}

    /**
     * retorna el ultimo elemento de la lista
     * @return
     */
    public Nodo<T> getUltimo(){return ultimo;}

    /**
     * asiggna el ultimo elemento de la lista
     * @param ultimo
     */
    public void setUltimo(Nodo<T> ultimo){this.ultimo = ultimo;}


    /**
     * retorna booleano que indica si la lista esta vacia
     * @return
     */
    public boolean esta_vacia() {return primero == null;}

    /**
     * Inserta un elemento en una lista vacia
     * @param dato
     */
    private void insertar_en_vacia(T dato)
    {
        primero = ultimo = new Nodo<T>(dato);
        cantidad_de_nodos++;
    }

    /**
     * inserta un elemento al inicio de la lista
     * @param dato dato para insertar en la lista
     */
    public void insertar_al_inicio(T dato)
    {
        if(esta_vacia())
        {
            insertar_en_vacia(dato);
        }
        else
        {
            Nodo<T> nodo_nuevo = new Nodo<>(dato);
            nodo_nuevo.setSiguiente(primero);
            primero = nodo_nuevo;
            cantidad_de_nodos++;
        }
    }
    /**
     * metodo para insertar al final de la lista
     * @param o elemnto a insertar
     */
    public void insertar_al_final(T o)
    {
        //System.out.println("insertar_al_final de: " + o);
        if(esta_vacia())
        {
            insertar_en_vacia(o);
        }
        else
        {
            //System.out.println("Lo q tiene el ultimo nodo ANTES de insertar: " + ultimo.getO());
            Nodo<T> nodo_nuevo = new Nodo<>(o);
            ultimo.setSiguiente(nodo_nuevo);
            ultimo = nodo_nuevo;
            cantidad_de_nodos++;
            //System.out.println("Lo q tiene el ultimo nodo DESPUES de insertar: " + ultimo.getO());
        }
        //System.out.println("Ahora hay: " + cantidad_de_nodos);
    }
    /**
     * Metodo utilizado para insertar un elemento en posicion especifica
     * @param dato dato a insertar
     * @param posicion posicion en la que se desea insertar
     * @return
     */
    public boolean insertar_al_medio(T dato, int posicion)
    {
        if(esta_vacia())
        {
            insertar_en_vacia(dato);
        }
        else if(posicion < 1 || posicion >= cantidad_de_nodos)
        {
            return false;
        }
        else
        {
            Nodo<T> pivote = primero;
            for(int i=0; i < posicion-1; i++)
            {
                pivote = pivote.getSiguiente();
            }
            Nodo<T> nodo_nuevo = new Nodo<>(dato);
            nodo_nuevo.setSiguiente(pivote.getSiguiente());
            pivote.setSiguiente(nodo_nuevo);
            cantidad_de_nodos++;
        }
        return true;
    }

    /**
     * metodo para editar un elemento en la lista
     * @param posicion posicion a editar
     * @param dato dato nuevo a insertar
     * @return
     */
    public boolean sobreescribir(int posicion, T dato)
    {
        if(!esta_vacia())
        {
            if(posicion >= 0 && posicion < cantidad_de_nodos)
            {
                Nodo<T> pivote = primero;
                for(int i=0; i < posicion; i++)
                {
                    pivote = pivote.getSiguiente();
                }
                pivote.setDato(dato);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para coopiar todos los elementos de la lista
     * @return
     */
    public Lista_Simple<T> clonar()
    {
        Lista_Simple<T> clon = new Lista_Simple<>();
        Nodo<T> pivote = this.primero;
        for(int i=0; i < cantidad_de_nodos; i++)
        {
            clon.insertar_al_final(pivote.getDato());
            pivote = pivote.getSiguiente();
        }
        return clon;
    }
    /**
     * elimina el primer elemento de la lista
     * @return
     */
    public boolean eliminar_al_inicio()
    {
        if(cantidad_de_nodos > 0)
        {
            if(cantidad_de_nodos == 1)
            {
                primero = ultimo = null;
            }
            else
            {
                primero = primero.getSiguiente();
            }
            cantidad_de_nodos--;
            return true;
        }
        return false;
    }

    /**
     * elimina el ultimo elemento de la lista
     * @return
     */
    public boolean eliminar_al_final()
    {
        if(cantidad_de_nodos > 0)
        {
            if(cantidad_de_nodos == 1)
            {
                primero = ultimo = null;
            }
            else
            {
                Nodo<T> pivote = primero;
                while(pivote.getSiguiente() != ultimo)
                {
                    pivote = pivote.getSiguiente();
                }
                pivote.setSiguiente(null);
                ultimo = pivote;
            }
            cantidad_de_nodos--;
            return true;
        }
        return false;
    }

    /**
     * elimina la posicoin deseada
     * @param posicion posicion a eliminar
     * @return
     */
    public boolean eliminar_al_medio(int posicion)
    {
        if(cantidad_de_nodos > 0)
        {
            if(posicion >= cantidad_de_nodos)
            {
                return eliminar_al_final();
            }
            else if(posicion <= 0)
            {
                return eliminar_al_inicio();
            }
            else
            {
                Nodo<T> pivote = primero;
                for(int i=0; i < posicion-1; i++)
                {
                    pivote = pivote.getSiguiente();
                }
                pivote.setSiguiente(pivote.getSiguiente().getSiguiente());
                cantidad_de_nodos--;
                return true;
            }
        }
        return false;
    }

    /**
     * elimina la posicoin deseada
     * @param posicion posicion a eliminar
     */
    private void eliminar_al_medio_sin_return(int posicion)
    {
        if(cantidad_de_nodos > 0)
        {
            if(posicion >= cantidad_de_nodos)
            {
                eliminar_al_final();
            }
            else if(posicion <= 0)
            {
                eliminar_al_inicio();
            }
            else
            {
                Nodo<T> pivote = primero;
                for(int i=0; i < posicion-1; i++)
                {
                    pivote = pivote.getSiguiente();
                }
                pivote.setSiguiente(pivote.getSiguiente().getSiguiente());
                cantidad_de_nodos--;
            }
        }
    }

    /**
     * Elimina todos los elementos repetidos de la lista
     * @param dato dato a buscar si se repite
     */
    public void eliminar_repetidos(T dato)
    {
        if(!esta_vacia())
        {
            Nodo<T> pivote = primero;
            for(int i=0; i < cantidad_de_nodos; i++)
            {
                if(pivote.getDato().equals(dato))
                {
                    eliminar_al_medio_sin_return(i);
                    i--;
                }
                pivote = pivote.getSiguiente();
            }
        }
    }

    /**
     * Metodo que hace el llamado a los metodos auxiliares
     * @param dato
     * @return
     */
    public boolean eliminar(T dato)
    {
        if(!esta_vacia())
        {
            Nodo<T> pivote = primero;
            for(int i=0; i < cantidad_de_nodos; i++)
            {
                if(pivote.getDato().equals(dato))
                {
                    if(i == 0)
                    {
                        primero = primero.getSiguiente();
                        cantidad_de_nodos--;
                    }
                    else if(i == cantidad_de_nodos-1)
                    {
                        eliminar_al_final();
                    }
                    else
                    {
                        eliminar_al_medio_sin_return(i);
                    }
                    return true;
                }
                pivote = pivote.getSiguiente();
            }
        }
        return false;
    }

    /**
     * Elimina todos los elementos de la lista
     */
    public void borrarTodo()
    {
        this.primero = null;
        this.ultimo = null;
        this.cantidad_de_nodos = 0;
    }

    /**
     * Retorna el elelemento en el indice deseado
     * @param posicion posicion a retornar
     * @return
     */

    public T get_dato_por_indice(int posicion)
    {
        if(posicion > -1 && posicion < cantidad_de_nodos)
        {
            Nodo<T> pivote = primero;
            for(int i=0; i < posicion; i++)
            {
                //System.out.println("pivote es este: " + pivote.getO());
                pivote = pivote.getSiguiente();
            }
            if(pivote == null)
            {
                Nodo<T> antes_del_pivote = primero;
                for(int i=0; i < posicion-1; i++)
                {
                    antes_del_pivote = antes_del_pivote.getSiguiente();
                }
                System.out.println("antes del pivote: " + antes_del_pivote.getDato());
            }
            return pivote.getDato();
        }
        return null;
    }

    public Nodo<T> get_nodo_por_indice(int posicion)
    {
        if(posicion > -1 && posicion < cantidad_de_nodos)
        {
            Nodo<T> pivote = primero;
            for(int i=0; i < posicion; i++)
            {
                //System.out.println("pivote es este: " + pivote.getO());
                pivote = pivote.getSiguiente();
            }
            if(pivote == null)
            {
                Nodo<T> antes_del_pivote = primero;
                for(int i=0; i < posicion-1; i++)
                {
                    antes_del_pivote = antes_del_pivote.getSiguiente();
                }
                System.out.println("antes del pivote: " + antes_del_pivote.getDato());
            }
            return pivote;
        }
        return null;
    }

    /**
     * busca un elemento en la lista
     * @param dato datoo a buscar
     * @return dato encontrado
     */
    public T get_dato(T dato)
    {
        if(cantidad_de_nodos != 0)
        {
            Nodo<T> pivote = primero;

            while(pivote != null)
            {
                if(pivote.getDato() == dato)
                {
                    return pivote.getDato();
                }
                else
                {
                    pivote = pivote.getSiguiente();
                }
            }
        }
        return null;
    }

    /**
     * BUsca si un elemento existe en la lista
     * @param dato
     * @return
     */
    public boolean existe(T dato){return get_dato(dato) != null;}

    public void mostrar()
    {
        if(esta_vacia())
        {
            System.out.print("[->]");
        }
        else
        {
            Nodo<T> pivote = this.primero;
            System.out.print("[");
            for(int i=0; i < cantidad_de_nodos; i++)
            {
                if(i==0)
                {
                    System.out.print(pivote.getDato().toString());
                }
                else
                {
                    System.out.print("," + pivote.getDato().toString());
                }
                pivote = pivote.getSiguiente();
            }
            System.out.println("]");
        }
    }

    /**
     * muestra toda la lista
     */
    public void mostrarln()
    {
        if(esta_vacia())
        {
            System.out.print("[->]");
        }
        else
        {
            Nodo<T> pivote = this.primero;
            System.out.println("[");
            for(int i=0; i < cantidad_de_nodos; i++)
            {
                System.out.println(pivote.getDato().toString());
                pivote = pivote.getSiguiente();
            }
            System.out.println("]");
        }
    }

    @Override
    /**
     * Convierte toda la lista en un string
     * @return
     */
    public String toString()
    {
        String str = "";
        if(esta_vacia())
        {
            str = "[->]";
        }
        else
        {
            Nodo<T> pivote = this.primero;
            str += "[";
            for(int i=0; i < cantidad_de_nodos; i++)
            {
                str += pivote.getDato().toString();
                pivote = pivote.getSiguiente();
            }
            str += "]";
        }
        return str;
    }
    

}
