package tic_tac_toe.game_parts;

public class UpperCenterBlock extends Block {
    public UpperCenterBlock() {
        this.block = new StringBuilder(super.segmentOne.toString() + "\n"
                + super.segmentOne.toString() + "\n"
                + super.segmentTwo.toString() + "\n");
    }
}
