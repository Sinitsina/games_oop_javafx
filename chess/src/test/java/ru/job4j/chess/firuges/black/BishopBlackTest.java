package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void whenPositionA3ThenA3() {
        BishopBlack bishop = new BishopBlack(Cell.A3);
        Cell result = bishop.position();
        assertThat(result, is(Cell.A3));
    }

    @Test
    public void whenCopyA3ThenE1() {
        BishopBlack bishop = new BishopBlack(Cell.A3);
        Figure result = bishop.copy(Cell.E1);
        Cell pos = result.position();
        assertThat(pos, is(Cell.E1));
    }

    @Test
    public void whenMoveFromC1ToG5() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] res = bishop.way(Cell.C1, Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(res, is(expected));
    }

    @Test
    public void whenMoveFromA5ToE1() {
        BishopBlack bishop = new BishopBlack(Cell.A5);
        Cell[] res = bishop.way(Cell.A5, Cell.E1);
        Cell[] expected = {Cell.B4, Cell.C3, Cell.D2, Cell.E1};
        assertThat(res, is(expected));
    }

    @Test (expected = IllegalStateException.class)
    public void whenMoveFromA5ToE4Exception() {
        BishopBlack bishop = new BishopBlack(Cell.A5);
        Cell[] res = bishop.way(Cell.A5, Cell.E4);
    }

}