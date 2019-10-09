package ru.job4j;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import ru.job4j.chess.Logic;
import ru.job4j.chess.exception.BlockedWayException;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

public class LogicTest {

    @Test
    public void whenMoveC1ToG5ThenTrue() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        assertThat(logic.move(Cell.C1, Cell.G5), is(true));
    }

    @Test
    public void whenFigureOnTheWayThenBlockedWayException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnWhite(Cell.E3));
        try {
            logic.move(Cell.C1, Cell.G5);
        } catch (BlockedWayException bwe) {
            assertThat(bwe.getMessage(), is("Another Figure on the Way"));
        }
    }

    @Test
    public void whenC1ToC6ThenFigureNotFoundException() {
        Logic logic = new Logic();
        try {
            logic.move(Cell.C1, Cell.C6);
        } catch (FigureNotFoundException fne) {
            assertThat(fne.getMessage(), is("The Figure was not found"));
        }
    }
}
