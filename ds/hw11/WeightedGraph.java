// Christopher Larson
// CSCI 337 Homeowkr #11 Problem #11
// WeightedGraph.java
// 11/12/14
//
// Simple class to represent a weighted graph

import java.text.DecimalFormat;

public class WeightedGraph
{
    private static DecimalFormat fmt = new DecimalFormat("00");

    private int[][] edge;

    public WeightedGraph(int numNodes)
    {
        edge = new int[numNodes][numNodes];

        // Start every edge with a huge cost
        // to represent no edge
        for (int i = 0; i < numNodes; i++)
            for (int j = 0; j < numNodes; j++)
                edge[i][j] = Integer.MAX_VALUE;
    }

    public void addEdge(int i, int j, int weight)
    {
        if (0 <= i && i < edge.length
            && 0 <= j && j < edge.length)
            edge[i][j] = weight;
    }

    public void removeEdge(int i, int j)
    {
        if (0 <= i && i < edge.length
            && 0 <= j && j < edge.length)
            edge[i][j] = Integer.MAX_VALUE;
    }

    public boolean hasEdge(int i, int j)
    {
        boolean result;
        if (0 <= i && i < edge.length
            && 0 <= j && j < edge.length)
            result = edge[i][j] != Integer.MAX_VALUE;
        else
            result = false;
        return result;
    }

    // Return the cost array computed using
    // Dijkstra's algorithm
    public int[] shortestPaths(int sourceNode)
    {
        int i;
        int[] cost = new int[edge.length];
        boolean[] setS = new boolean[edge.length]; // all false by default

        // Initially, all of the costs are infinity
        for (i = 0; i < edge.length; i++)
            cost[i] = Integer.MAX_VALUE;

        // Compute the cost of the shortest path from
        // the source node to each node in the graph

        cost[sourceNode] = 0;
        setS[sourceNode] = true;

        for (i = sourceNode; i < edge.length; i++)
            for (int j = 0; j < edge[i].length; j++)
                if (edge[i][j] != Integer.MAX_VALUE && !setS[j])
                    if (cost[i] + edge[i][j] < cost[j])
                        cost[j] = cost[i] + edge[i][j];
                    else 
                        setS[j] = true;

        return cost;
    }

    public String toString()
    {
        String result = "";
        for (int i = 0; i < edge.length; i++)
        {
            for (int j = 0; j < edge[i].length; j++)
                if (edge[i][j] != Integer.MAX_VALUE)
                    result += fmt.format(edge[i][j]) + "   ";
                else
                    result += "--   ";
            result += "\n";
        }

        return result;
    }
}
