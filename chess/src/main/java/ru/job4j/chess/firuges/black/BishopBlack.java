package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.getX() - source.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - source.getX()) / Math.abs(dest.getX() - source.getX());
        int deltaY = (dest.getY() - source.getY()) / Math.abs(dest.getY() - source.getY());
        for (int index = 0; index < size; index++) {
            int x = source.getX() + ((index+1) * deltaX);
            int y = source.getY() + ((index+1) * deltaY);
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if(Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY())) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
