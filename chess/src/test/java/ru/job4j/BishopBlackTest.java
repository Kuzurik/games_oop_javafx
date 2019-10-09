package ru.job4j;


import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.exception.IllegalStateException;

public class BishopBlackTest {

    @Test
    public void whenFigureC1ToG5ReturnArrayD2E3F4G5(){
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5 };
        assertThat(result, is(expected));
    }

    @Test
    public void whenFigureC1ToG5ReturnArrayF4E3D2C1(){
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        Cell[] result = bishopBlack.way(Cell.G5, Cell.C1);
        Cell[] expected = new Cell[] {Cell.F4, Cell.E3, Cell.D2, Cell.C1 };
        assertThat(result, is(expected));
    }


    @Test
    public void whenPositionC1ReturnC1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell result = bishopBlack.position();
        Cell expected = Cell.C1;
        assertThat(result, is(expected));
    }

    @Test
    public void whenC1ToG5ReturnTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean result = bishopBlack.isDiagonal(Cell.C1, Cell.G5);
        assertThat(result, is(true));
    }

    @Test
    public void whenCopyHasSamePosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell cell = Cell.C1;
        assertThat(bishopBlack.copy(Cell.C1).position(), is(cell));
    }

    @Test
    public void whenC1ToC6ThanIllegalStateException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        try {
            bishopBlack.way(Cell.C1, Cell.C6);
        }catch (IllegalStateException ise){
            assertThat(ise.getMessage(), is("Could not way by diagonal from C1 to C6"));
        }
    }

}
