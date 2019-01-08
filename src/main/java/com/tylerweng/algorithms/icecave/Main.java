package com.tylerweng.algorithms.icecave;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static MyPosition down(int x, int y, int numMoves, Square[][] maze) {
        while (++x <= maze.length - 1) {
            if (!maze[x][y].isIce) return new MyPosition(x-1, y, numMoves + 1);
            else if (x == maze.length - 1) return new MyPosition(x, y, numMoves + 1);
        }
        return null;
    }

    static MyPosition up(int x, int y, int numMoves, Square[][] maze) {
        while (--x >= 0) {
            if (!maze[x][y].isIce) return new MyPosition(x+1, y, numMoves + 1);
            else if (x == 0) return new MyPosition(x, y, numMoves + 1);
        }
        return null;
    }

    static MyPosition right(int x, int y, int numMoves, Square[][] maze) {
        while (++y <= maze[0].length - 1) {
            if (!maze[x][y].isIce) return new MyPosition(x, y-1, numMoves + 1);
            else if (y == maze[0].length - 1) return new MyPosition(x, y, numMoves + 1);
        }
        return null;
    }

    static MyPosition left(int x, int y, int numMoves, Square[][] maze) {
        while (--y >= 0) {
            if (!maze[x][y].isIce) return new MyPosition(x, y+1, numMoves + 1);
            else if (y == 0) return new MyPosition(x, y, numMoves + 1);
        }
        return null;
    }

    static List<MyPosition> nextPositions(int x, int y, int numMoves, Square[][] maze) {
        return Stream.of(
                down(x, y, numMoves, maze),
                up(x, y, numMoves, maze),
                right(x, y, numMoves, maze),
                left(x, y, numMoves, maze)
        ).filter(Objects::nonNull)
         .collect(Collectors.toList());
    }

    // assume you are given valid starts and ends (that is, that both positions coordinates are
    // contained in the maze and that both corresponding squares are ice
    // return the least number of moves to get from start to end or -1 if impossible
    public static int leastMovesToExit(Position start, Position end, Square[][] maze) {
        PriorityQueue<MyPosition> queue = new PriorityQueue<>((x, y) -> x.numMoves - y.numMoves);
        queue.add(new MyPosition(start));
        Set<Position> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            MyPosition curr = queue.poll();
            seen.add(new Position(curr.x, curr.y));
            if (curr.samePosition(end)) return curr.numMoves;
            for (MyPosition pos : nextPositions(curr.x, curr.y, curr.numMoves, maze)) {
                if (!seen.contains(Position.fromMyPosition(pos))) queue.add(pos);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 4;
        Square[][] maze = new Square[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = new Square();
            }
        }
        maze[0][3].isIce = false;
        maze[4][0].isIce = false;
        maze[3][1].isIce = false;
        maze[2][2].isIce = false;
        Position start = new Position(0, 0);
        Position end = new Position(m-1, n-1);

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }
        System.out.println(String.format("start: %s", start));
        System.out.println(String.format("end: %s", end));
        System.out.println(String.format("least numMoves: %s", leastMovesToExit(
                start,
                end,
                maze
        )));
    }
}

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        else if (obj == this) return true;
        if (!(obj instanceof Position)) return false;
        Position other = (Position) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    static Position fromMyPosition(MyPosition myPosition) {
        return new Position(myPosition.x, myPosition.y);
    }

    @Override
    public String toString() {
        return String.format("position: %s, %s", x, y);
    }
}

class MyPosition {
    int x;
    int y;
    int numMoves;

    MyPosition(int x, int y, int numMoves) {
        this.x = x;
        this.y = y;
        this.numMoves = numMoves;
    }

    MyPosition(Position p) {
        this.x = p.x;
        this.y = p.y;
        this.numMoves = 0;
    }

    boolean samePosition(Position p) {
        return this.x == p.x && this.y == p.y;
    }

    @Override
    public String toString() {
        return String.format("myPosition: %s, %s, %s", x, y, numMoves);
    }


}

class Square {
    // when you move on ice you go up, right, down or left all the way
    // til you hit either the edge of the maze or a space that !isIce
    boolean isIce;

    Square() {
        isIce = true;
    }

    Square(boolean isIce) {
        this.isIce = isIce;
    }

    @Override
    public String toString() {
        return isIce ? "I" : "R";
    }
}