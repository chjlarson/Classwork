// Christopher Larson
// CSCI 337 Homework #11 Problem #11
// WeightedGraph.java
// 11/12/14
//
// Tests the WeightedGraph program

class TestWeightedGraph
{
    private static WeightedGraph graph = new WeightedGraph(6);

    public static void main(String[] args)
    {
       graph.addEdge(0, 1, 2);
       graph.addEdge(0, 5, 4);
       graph.addEdge(1, 2, 5);
       graph.addEdge(1, 5, 1);
       graph.addEdge(1, 0, 2);
       graph.addEdge(2, 4, 2);
       graph.addEdge(2, 5, 8);
       graph.addEdge(2, 1, 5);
       graph.addEdge(2, 3, 6);
       graph.addEdge(3, 2, 6);
       graph.addEdge(3, 4, 3);
       graph.addEdge(4, 3, 3);
       graph.addEdge(4, 5, 10);
       graph.addEdge(4, 2, 2);
       graph.addEdge(5, 0, 4);
       graph.addEdge(5, 1, 1);
       graph.addEdge(5, 2, 8);
       graph.addEdge(5, 4, 10);
       
       
       int[] shortPath0 = graph.shortestPaths(0); 
       int[] shortPath2 = graph.shortestPaths(2); 

       System.out.println("This program computes the shortest distance,");

       for (int i = 0; i < shortPath0.length; i++)
       {
           System.out.println("From 0 to " + i + " is " + shortPath0[i]);
       }
       
       System.out.println();
       System.out.println("and");
       System.out.println();
       
       for (int i = 0; i < shortPath2.length; i++)
       {
           System.out.println("From 2 to " + i + " is " + shortPath2[i]);
       }
       
       System.out.println();
    }
}
