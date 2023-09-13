package test2;

import java.util.*;

public class Maze {
    private int size;
    private int startX;
    private int startY;

    public Maze(int size, int startX, int startY) {
        this.size = size;
        this.startX = startX;
        this.startY = startY;
    }

    public enum Action {
        Exit,
        MoveNorth,
        MoveEast,
        MoveSouth,
        MoveWest
    }

    public int getSize() {
        return size;
    }

    public boolean isExit(int x, int y) {
        return x == startX && y == startY;
    }

    public List<Action> possibleActions(int x, int y) {
        List<Action> actions = new ArrayList<>();

        if (x > 0)
            actions.add(Action.MoveNorth);
        if (x < size - 1)
            actions.add(Action.MoveSouth);
        if (y > 0)
            actions.add(Action.MoveWest);
        if (y < size - 1)
            actions.add(Action.MoveEast);

        return actions;
    }
}
