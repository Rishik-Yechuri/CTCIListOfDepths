import java.util.ArrayList;
import java.util.LinkedList;

public class CTCIListOfDepths {
    public static void main(String[] args) {
        try{
            CTCIListOfDepths obj = new CTCIListOfDepths();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        Node node = new Node(14);
        node.leftNode = new Node(6);
        node.leftNode.leftNode = new Node(3);
        node.leftNode.leftNode.leftNode = new Node(1);
        node.leftNode.leftNode.rightNode = new Node(5);
        node.leftNode.rightNode = new Node(8);
        node.leftNode.rightNode.leftNode = new Node(7);
        node.leftNode.rightNode.rightNode = new Node(11);
        node.rightNode = new Node(21);
        node.rightNode.leftNode = new Node(18);
        node.rightNode.rightNode = new Node(25);
        node.rightNode.leftNode.leftNode = new Node(15);
        node.rightNode.leftNode.rightNode = new Node(19);
        node.rightNode.rightNode.leftNode = new Node(24);
        node.rightNode.rightNode.rightNode = new Node(27);
        ArrayList<LinkedList<Node>> nodesByLayer = listDepths(node,0,new ArrayList());

        //Print out the Nodes in the LinkedLists
        System.out.println(nodesByLayer.get(0).get(0).num);

        System.out.println(nodesByLayer.get(1).get(0).num);
        System.out.println(nodesByLayer.get(1).get(1).num);

        System.out.println(nodesByLayer.get(2).get(0).num);
        System.out.println(nodesByLayer.get(2).get(1).num);
        System.out.println(nodesByLayer.get(2).get(2).num);
        System.out.println(nodesByLayer.get(2).get(3).num);

        System.out.println(nodesByLayer.get(3).get(0).num);
        System.out.println(nodesByLayer.get(3).get(1).num);
        System.out.println(nodesByLayer.get(3).get(2).num);
        System.out.println(nodesByLayer.get(3).get(3).num);
        System.out.println(nodesByLayer.get(3).get(4).num);
        System.out.println(nodesByLayer.get(3).get(5).num);
        System.out.println(nodesByLayer.get(3).get(6).num);
        System.out.println(nodesByLayer.get(3).get(7).num);
    }
    public ArrayList<LinkedList<Node>> listDepths(Node curr,int depth,ArrayList<LinkedList<Node>> holdNodes){
        if((holdNodes.size() - 1 < depth)){
            holdNodes.add(new LinkedList<Node>());
        }
        holdNodes.get(depth).add(curr);
        if(curr.leftNode != null){
            listDepths(curr.leftNode,depth+1,holdNodes);
        }
        if(curr.rightNode != null){
            listDepths(curr.rightNode,depth+1,holdNodes);
        }
        return holdNodes;
    }
}
class Node {
    public int num;
    public Node leftNode;
    public Node rightNode;
    public Node(){}
    public Node(int num){
        this.num = num;
    }
    public Node(int num,Node leftNode,Node rightNode){
        this.num = num;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}