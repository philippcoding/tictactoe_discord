package tic_tac_toe.game_parts;

public class BottomRow extends Block {

    public BottomRow() {
        this.block = new StringBuilder(super.segmentOne.toString() + "\n"
                + super.segmentOne.toString() + "\n"
                + super.segmentOne.toString());
    }

}
