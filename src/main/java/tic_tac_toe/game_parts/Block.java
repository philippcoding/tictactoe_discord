package tic_tac_toe.game_parts;

public abstract class Block {

    StringBuilder segmentOne, segmentTwo, block;
    {
        this.segmentOne = new StringBuilder("     |     |      ");
        this.segmentTwo = new StringBuilder("_____|_____|_____ ");
        this.block = new StringBuilder();
    }
    public void setCrossOrNought(char xOrO, int column) {
        switch(column) {
            case 1:{
                this.block.setCharAt(21, xOrO);
                break;
            }
            case 2:{
                this.block.setCharAt(27,  xOrO);
                break;
            }
            case 3:{
                this.block.setCharAt(34, xOrO);
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return this.block.toString();
    }

}
