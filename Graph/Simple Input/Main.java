import java.util.*;
public class Edges{
    int u;
    int v;
    Edges(int u, int v){
        this.u=u;
        this.v=v;
    }
}
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int vertices=sc.nextInt();
    int edges=sc.nextInt();
    ArrayList<Edges>[]graph=new ArrayList[vertices]; //initialise an array of vertices 
    for(int i=0;i<vertices;i++){
        graph[i]=new ArrayList<>(); // initialised arraylist attached to each vertices
    }
    for(int i=0;i<edges;i++){
        int u=sc.nextInt();
        int v=sc.nextInt();
        int w=sc.nextInt();
        graph[u].add(new Edges(v,w)); //make a link u vertex to v having w weight
        graph[v].add(new Edges(u,w)); //make a link v vertex to u having w weight
        // so we construct undirected graph
    }
}