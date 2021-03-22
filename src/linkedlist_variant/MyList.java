package linkedlist_variant;

import java.util.LinkedList;

public class MyList {
    private LinkedList<Node> content;

    public MyList (){
        this.content = new LinkedList<>();
    }

    public void set(Integer object, Integer xCoordinate, Integer yCoordinate, Integer zCoordinate){
        this.content.add(new Node(object, xCoordinate, yCoordinate, zCoordinate));
    }

    public Integer get(Integer xCoordinate, Integer yCoordinate, Integer zCoordinate){
        for(Node currentNode:content) {
            if (currentNode.getX() == xCoordinate &&
                    currentNode.getY() == yCoordinate &&
                    currentNode.getZ() == zCoordinate) {
                return currentNode.getObject();
            }
        }
        return 0;
    }

    private void swap(int j){
        Node temp = content.get(j);
        content.set(j, content.get(j+1));
        content.set(j + 1, temp);
    }

    public void sortNonempty(){
        for(int i = 0; i < content.size() - 1; i++){
            for(int j = 0; j < content.size() - 1 - i; j++){
                if(content.get(j).getObject() > content.get(j + 1).getObject()){
                    this.swap(j);
                } else if(content.get(j).getObject() == content.get(j+1).getObject()){
                    if(content.get(j).getZ() > content.get(j + 1).getZ()){
                        this.swap(j);
                    } else if(content.get(j).getZ() == content.get(j + 1).getZ()) {
                        if(content.get(j).getY() > content.get(j + 1).getY()){
                            this.swap(j);
                        } else if(content.get(j).getY() == content.get(j + 1).getY()
                                && content.get(j).getX() == content.get(j + 1).getX()){
                            this.swap(j);
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Node currentNode:this.content){
            result.append("Value: ").append(currentNode.getObject()).append(" X: ")
                    .append(currentNode.getX()).append(" Y: ").append(currentNode.getY()).append(" Z: ")
                    .append(currentNode.getZ()).append("\n");
        }
        return result.toString();
    }
}
