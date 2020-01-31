package tic_tac_toe.game_parts;

public class UpperCenterRow extends Block {
    public UpperCenterRow() {
        this.block = new StringBuilder(super.segmentOne.toString() + "\n"
                + super.segmentOne.toString() + "\n"
                + super.segmentTwo.toString() + "\n");
    }
}
