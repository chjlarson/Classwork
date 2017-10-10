// Christopher Larson
// CSCI 337 Homework #10 Problem #13
// Digraph.java
// 11/5/14
//
// Simple class to represent a directed graph.

public class Digraph
{
    private boolean[][] edge;

    public Digraph(int numNodes)
    {
        edge = new boolean[numNodes][numNodes];

        // By default, all boolean array values are false,
        // so there are no edges in the graph.
    }

    public int getNumVertices()
    {
        int count = 0;

        for (int i = 0; i < edge.length; i++)
            count++;

        return count;
    }

    public int getNumEdges()
    {
        int count = 0;
        for (int i = 0; i < edge.length; i++)
            for (int j = 0; j < edge[i].length; j++)
                if (edge[i][j])
                    count++;

        return count;
    }

    public void addEdge(int i, int j)
    {
        if (0 <= i && i < edge.length
            && 0 <= j && j < edge.length)
            edge[i][j] = true;
    }

    public void removeEdge(int i, int j)
    {
        if (0 <= i && i < edge.length
            && 0 <= j && j < edge.length)
            edge[i][j] = false;
    }

    public boolean hasEdge(int i, int j)
    {
        boolean result;
        if (0 <= i && i < edge.length
            && 0 <= j && j < edge.length)
            result = edge[i][j];
        else
            result = false;
        return result;
    }

    public int getInDegree(int vertex)
    {
        int count = 0;

        for (int i = 0; i < edge.length; i++)
            if (edge[i][vertex])
                count++;

        return count;
    }

    public int getOutDegree(int vertex)
    {
        int count = 0;

        for (int i = 0; i < edge.length; i++)
            if (edge[vertex][i])
                count++;

        return count;
    }

    public boolean isSource(int vertex)
    {
        boolean source = true;

        for (int i = 0; i < edge.length; i++)
            if (edge[i][vertex])
                source = false;

        return source;
    }

    public boolean isSink(int vertex)
    {
        boolean sink = true;

        for (int i = 0; i < edge.length; i++)
            if (edge[vertex][i])
                sink = false;

        return sink;
    }

    public String toString()
    {
        String result = "";
        for (int i = 0; i < edge.length; i++)
        {
            for (int j = 0; j < edge[i].length; j++)
                if (edge[i][j])
                    result += "T ";
                else
                    result += "  ";
            result += "\n";
        }

        return result;
    }
}
