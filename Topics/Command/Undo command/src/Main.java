interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command{
    Movable entity;
    int xMovement;
    int yMovement;


    public void execute(){
        entity.setX(entity.getX() + xMovement);
        entity.setY(entity.getY() + yMovement);
    }

    public void undo(){
        entity.setX(entity.getX() - xMovement);
        entity.setY(entity.getY() - yMovement);
    }
}

class CommandPutItem implements Command{
    Storable entity;
    String item;
    int firstEmptyFiledIndex;
    int i = 0;

    public void execute(){
//        for (int i = 0; i < entity.getInventoryLength(); i++){
//            if (entity.getInventoryItem(i) == null) {
//                firstEmptyFiledIndex = i;
//                entity.setInventoryItem(firstEmptyFiledIndex, item);
//                break;
//            }
//        }
        boolean b= false;
        while(true) {
            if(entity.getInventoryLength() <= i){
                break;
            }
            if (entity.getInventoryItem(i) == null) {
                b = true;
                firstEmptyFiledIndex = i;
                break;
            }
            i++;
        }
        if(b){
            entity.setInventoryItem(firstEmptyFiledIndex, item);
        }


    }

    public void undo(){
        entity.setInventoryItem(firstEmptyFiledIndex, null);
    }
}