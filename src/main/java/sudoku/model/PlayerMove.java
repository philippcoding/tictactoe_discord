package sudoku.model;

import java.util.HashMap;

public class PlayerMove {
    private String move;
    private HashMap<String, Integer> moveMap;

    public PlayerMove(String move){
        this.move = move;
        this.moveMap = createMoveMap(this.move);
    }

    private HashMap<String, Integer> createMoveMap(String move){
        return new HashMap<String, Integer>(){{
         put("X", Integer.parseInt((move.charAt(0) + "")));
         put("Y", Integer.parseInt((move.charAt(1) + "")));
         put("Value", Integer.parseInt((move.charAt(2) + "")));
        }};
    }

    public HashMap<String, Integer> getMoveMap(){
        return this.moveMap;
    }
}
