package ru.job4j.chess.exception;

public class BlockedWayException extends RuntimeException {
    public BlockedWayException(String msg) {
        super(msg);
    }
}
