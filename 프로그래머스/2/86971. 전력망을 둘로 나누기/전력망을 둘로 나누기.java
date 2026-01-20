import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        
        for (int[] wire : wires) {
            nodes[wire[0] - 1].addNode(nodes[wire[1] - 1]);
            nodes[wire[1] - 1].addNode(nodes[wire[0] - 1]);
        }
        
        for (int[] wire : wires) {
            int node1 = wire[0] - 1;
            int node2 = wire[1] - 1;
            
            nodes[node1].deleteNode(nodes[node2]);
            nodes[node2].deleteNode(nodes[node1]);
            
            boolean[] visited = new boolean[n];
            int count1 = countAllNode(nodes[node1], visited);
            int count2 = n - count1; 
            
            answer = Math.min(answer, Math.abs(count1 - count2));
            
            nodes[node1].addNode(nodes[node2]);
            nodes[node2].addNode(nodes[node1]);
        }
        
        return answer;
    }
    
    public int countAllNode(Node node, boolean[] visited) {
        visited[node.nodeNum] = true;
        int count = 1;
        for (Node neighbor : node.nodeList) {
            if (!visited[neighbor.nodeNum]) {
                count += countAllNode(neighbor, visited);
            }
        }
        return count;
    }
    
    public class Node {
        int nodeNum;
        ArrayList<Node> nodeList = new ArrayList<>();
        
        public Node(int nodeNum) {
            this.nodeNum = nodeNum;
        }
        
        public void addNode(Node node) {
            this.nodeList.add(node);
        }
        
        public void deleteNode(Node node) {
            this.nodeList.remove(node);
        }
    }
}
