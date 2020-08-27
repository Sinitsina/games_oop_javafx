package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = this.findBy(source);
        Cell[] steps = this.figures[index].way(source, dest);
        if (isFree(steps)) {
            this.figures[index] = this.figures[index].copy(dest);
        }
    }


    private boolean isFree(Cell[] steps) throws OccupiedCellException {
        for (int index = 0; index != this.figures.length; index++) {
            if (!(figures[index].position().equals(steps[index]))) {
                return true;
            }
        }
        throw new OccupiedCellException();
    }

    public void clean () {
        Arrays.fill(this.figures, null);
        this.index = 0;
    }

    private int findBy (Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
             Figure figure = figures[index];
             if (figure != null && figure.position().equals(cell)) {
                 return index;
             }
        }
        throw new FigureNotFoundException();
        }
    }

