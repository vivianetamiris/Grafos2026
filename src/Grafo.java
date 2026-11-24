import java.util.*;
public class Grafo<T> {

    public HashMap<T, LinkedList<Aresta>> meuGrafo;
    ArrayList<T> visitados;

    public Grafo() {
        this.meuGrafo = new HashMap<>();
    }

    public boolean adicionarVertice(T vertice) {
        if (!meuGrafo.containsKey(vertice)) {
            meuGrafo.put(vertice, new LinkedList<>());
            return true;
        }
        return false;
    }

    public boolean adicionarAresta(T origem, T destino, int peso, boolean direcionado) {
        if (meuGrafo.containsKey(origem) && meuGrafo.containsKey(destino)) {
            meuGrafo.get(origem).add(new Aresta(destino, peso));
            if (!direcionado) {
                meuGrafo.get(destino).add(new Aresta(origem, peso));
            }
            return true;
        }
        return false;
    }

    public void mostrarGrafo() {
        for (Map.Entry<T, LinkedList<Aresta>> registro : meuGrafo.entrySet()) {
            T vertice = registro.getKey();
            LinkedList<Aresta> arestas = registro.getValue();
            System.out.print("Vértice " + vertice + ": ");
            for (Aresta aresta : arestas) {
                System.out.print("-> (Destino: " + aresta.vertice + ", Peso: " + aresta.peso + ") ");
            }
            System.out.println("\n");
        }
    }

   public boolean alcance(T origem, T destino) {
        visitados = new ArrayList<>();
        return existeCaminho(origem, destino, visitados);
    }

    private boolean existeCaminho(T verticeAtual, T destino, ArrayList visitados) {
        if (verticeAtual.equals(destino)) 
            return true;
        visitados.add(verticeAtual);
        LinkedList<Aresta> adjacencias = meuGrafo.get(verticeAtual);
        if (adjacencias != null) 
            for (Aresta<T> aresta : adjacencias)
                if (!visitados.contains(aresta.getDestino()) && existeCaminho(aresta.getDestino, destino, visitados))
                    return true;
        return false;
    }
    /* 
    public List<T> buscaEmProfundidade(T verticeInicial) {
        visitados = new ArrayList<>();
        explorarDFS(_______, visitados);
        return ________;
    }
    
    private void explorarDFS(T verticeAtual, ArrayList<T> visitados) {
        visitados.add(______);
        LinkedList<Aresta> adjacencias = meuGrafo.get(______);
        if (adjacencias != null) 
            for (Aresta<T> aresta : adjacencias) 
                if (!visitados._______(aresta.vertice)) 
                    explorarDFS(aresta.vertice, ________);
    }

    public List<T> exploracaoEmLargura(T verticeInicial) {
        Queue<T> fila = new LinkedList<>();
        HashMap<T, T> predecessores = new HashMap<>();
        visitados = new ArrayList();
        fila.add(______);
        while (!fila._____()) {
            T verticeAtual = fila.______(); // 2. Remove o primeiro vértice da fila
            visitados.add(______);
            LinkedList<Aresta> adjacencias = meuGrafo.get(verticeAtual);
            if (adjacencias != null) 
                for (Aresta<T> aresta : adjacencias) 
                    if (!visitados.contains(aresta.vertice)  && !fila._______(aresta.vertice)){
                        fila.add(aresta._____);
                        predecessores.put(aresta.vertice, _____);
                    }
        }// fim while
        System.out.println(predecessores);
        System.out.println("Rotas até o vértice inicial:");
        for (Map.Entry<T, T> entry : predecessores.entrySet()) {
            System.out.println("Vértice: " + entry.getKey() + " <- Predecessor: " + entry.getValue());
        }
        return visitados;
    }// fim funcao BFS

    */
    

}
