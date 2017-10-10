public class TestDigraph
{
    public static void main(String[] args)
    {
        int i;
        Digraph graph = new Digraph(6);

        System.out.println("This program performs basic testing");
        System.out.println("of the Digraph class.\n");

        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("Adjacency matrix for the graph:\n");
        System.out.println(graph);

        System.out.println("There are " + graph.getNumVertices() 
            + " nodes in the graph.");
        System.out.println("There are " + graph.getNumEdges() 
            + " edges in the graph.\n");

        if (graph.isSource(3))
            System.out.println("Correct: Node 3 is a source");
        else
            System.err.println("ERROR: Node 3 should be a source");
        if (!graph.isSource(0))
            System.out.println("Correct: Node 0 is not a source");
        else
            System.err.println("ERROR: Node 0 should not be a source");
        if (!graph.isSource(5))
            System.out.println("Correct: Node 5 is not a source");
        else
            System.err.println("ERROR: Node 5 should not be a source");

        if (graph.isSink(5))
            System.out.println("\nCorrect: Node 5 is a sink");
        else
            System.err.println("\nERROR: Node 5 should be a sink");
        if (!graph.isSink(0))
            System.out.println("Correct: Node 0 is not a sink");
        else
            System.err.println("ERROR: Node 0 should not be a sink");
        if (!graph.isSink(3))
            System.out.println("Correct: Node 3 is not a sink");
        else
            System.err.println("ERROR: Node 3 should not be a sink");

        if (graph.getInDegree(1) == 2)
            System.out.println("\nCorrect: The indegree of node 1 is 2.");
        else
            System.err.println("\nERROR: The indegree of node 1 should be 2 "
                + "but is " + graph.getInDegree(1));
        if (graph.getOutDegree(1) == 3)
            System.out.println("Correct: The outdegree of node 1 is 3.");
        else
            System.err.println("ERROR: The outdegree of node 1 should be 3 "
                + "but is " + graph.getOutDegree(1));
        if (graph.getInDegree(3) == 0)
            System.out.println("\nCorrect: The indegree of node 3 is 0.");
        else
            System.err.println("\nERROR: The indegree of node 3 should be 0 "
                + "but is " + graph.getInDegree(3));
        if (graph.getOutDegree(3) == 4)
            System.out.println("Correct: The outdegree of node 3 is 4.");
        else
            System.err.println("ERROR: The outdegree of node 3 should be 0 "
                + "but is " + graph.getOutDegree(3));
    }
}
