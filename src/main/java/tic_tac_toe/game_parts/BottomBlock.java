package tic_tac_toe.game_parts;

public class BottomBlock extends Block {

    public BottomBlock() {
        this.block = new StringBuilder(super.segmentOne.toString() + "\n"
                + super.segmentOne.toString() + "\n"
                + super.segmentOne.toString());
    }

}
