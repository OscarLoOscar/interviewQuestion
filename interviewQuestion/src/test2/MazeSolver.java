package test2;

import java.util.*;

public class MazeSolver {
  private Maze maze;
  private boolean[][] visited;
  private List<Maze.Action> exitPath;

  public MazeSolver(Maze maze) {
    this.maze = maze;
    this.visited = new boolean[maze.getSize()][maze.getSize()];
    this.exitPath = new ArrayList<>();
  }

  public List<Maze.Action> findExitPath(int startX, int startY) {
    if (dfs(startX, startY)) {
      Collections.reverse(exitPath); // Reverse the path to get the correct order
      return exitPath;
    }
    return null; // No exit path found
  }

  private boolean dfs(int x, int y) {
    if (x < 0 || x >= maze.getSize() || y < 0 || y >= maze.getSize() || visited[x][y]) {
      return false;
    }

    visited[x][y] = true;

    if (maze.isExit(x, y)) {
      return true;
    }

    List<Maze.Action> actions = maze.possibleActions(x, y);
    for (Maze.Action action : actions) {
      int newX = x, newY = y;
      switch (action) {
        case MoveNorth:
          newX = x - 1;
          break;
        case MoveEast:
          newY = y + 1;
          break;
        case MoveSouth:
          newX = x + 1;
          break;
        case MoveWest:
          newY = y - 1;
          break;
      }

      if (dfs(newX, newY)) {
        exitPath.add(action);
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    Maze maze = new Maze(20, 5, 7);
    MazeSolver solver = new MazeSolver(maze);
    List<Maze.Action> exitPath = solver.findExitPath(10, 17);
    List<Maze.Action> roadMap = new ArrayList<>();

    if (exitPath != null) {
      System.out.println("Exit path found:");
      for (Maze.Action action : exitPath) {
        roadMap.add(action);
      }
    } else {
      System.out.println("No exit path found.");
    }
    System.out.println(roadMap);
  }
}
