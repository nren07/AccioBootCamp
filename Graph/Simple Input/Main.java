import java.util.*;

public class Main {
	
public static class Edges{
    int v;
    int w;
    Edges(int v, int w){
        this.v=v;
        this.w=w;
    }
}
public static void display(ArrayList<Edges>[]graph){
    int n=graph.length;
    for(int i=0;i<n;i++){
        System.out.print(i+"->");
        for(Edges e : graph[i]){
            System.out.print("("+e.v+","+e.w+")");
        }
        System.out.println();
    }
}
    
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
    // adjecncy matrix
    // int[][] graphMatrix=new int[vertex][vertex];
    // for(int i=0;i<edges;i++){
    //     int u=sc.nextInt();
    //     int v=sc.nextInt();
    //     int w=sc.nextInt();
    //     graphMatrix[u][v]=w;  //make a link u vertex to v having w weight
    //     graphMatrix[v][u]=w;  //make a link v vertex to u having w weight
    //     // so we construct undirected graph
    // }
    display(graph);
}
}