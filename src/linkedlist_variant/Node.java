package linkedlist_variant;

 class Node {
    private Integer object;
    private int x;
    private int y;
    private int z;
    public Node(Integer object, Integer xCoordinate, Integer yCoordinate, Integer zCoordinate){
        this.x = xCoordinate;
        this.y = yCoordinate;
        this.z = zCoordinate;
        this.object = object;
    }

    public Integer getObject() {
        return object;
    }

    public void setObject(Integer object) {
        this.object = object;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }@Override
    public String toString(){
        return String.valueOf(this.getObject());
    }
}
