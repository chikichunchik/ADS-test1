package array_variant;

public class MyList {
    private Node[] content;
    private double loadFactor = 0.75;
    private int current = 0;
    private int currentSize = 16;

    public MyList(){
        this.content = new Node[this.currentSize];
    }

    public MyList(Integer startSize){
        this.content = new Node[startSize];
        this.currentSize = startSize;
    }

    public MyList(Integer startSize, Double loadFactor){
        this.content = new Node[startSize];
        this.loadFactor = loadFactor;
        this.currentSize = startSize;
    }

    private void changeSize(int size) {
        this.currentSize=size;
        Node[] temparr = new Node[size];
        System.arraycopy(this.content, 0, temparr, 0, this.current);
        this.content = temparr;
    }

    public void set(Integer object, Integer xCoordinate, Integer yCoordinate, Integer zCoordinate){
        if(this.current + 1 >= this.currentSize * this.loadFactor) {
            changeSize(this.currentSize*2);
        }
        this.content[this.current] = new Node(object, xCoordinate, yCoordinate, zCoordinate);
        this.current++;
    }

    public Integer get(Integer xCoordinate, Integer yCoordinate, Integer zCoordinate){
        for(Node currentNode: this.content) {
            if (currentNode.getX() == xCoordinate &&
                    currentNode.getY() == yCoordinate &&
                    currentNode.getZ() == zCoordinate) {
                return currentNode.getObject();
            }
        }
        return 0;
    }

    public void sortNonempty(){
        for(int i = 0; i < this.current - 1; i++){
            for(int j = 0; j < this.current - 1 - i; j++){
                if(content[j].getObject() > content[j + 1].getObject()){
                    this.swap(j);
                } else if(content[j].getObject() == content[j + 1].getObject()){
                    if(content[j].getZ() > content[j + 1].getZ()){
                        this.swap(j);
                    } else if(content[j].getZ() == content[j + 1].getZ()) {
                        if(content[j].getY() > content[j + 1].getY()){
                            this.swap(j);
                        } else if(content[j].getY() == content[j + 1].getY()
                                && content[j].getX() == content[j + 1].getX()){
                            this.swap(j);
                        }
                    }
                }
            }
        }
    }

    private void swap(int j){
        Node temp = content[j];
        content[j] = content[j+1];
        content[j + 1] = temp;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Node currentNode:this.content){
            if(currentNode == null){
                break;
            }
            result.append("Value: ").append(currentNode.getObject()).append(" X: ").append(currentNode.getX())
                    .append(" Y: ").append(currentNode.getY()).append(" Z: ")
                    .append(currentNode.getZ()).append("\n");
        }
        return result.toString().toString();
    }
}

