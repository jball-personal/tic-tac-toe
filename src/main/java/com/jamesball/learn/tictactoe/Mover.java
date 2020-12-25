package com.jamesball.learn.tictactoe;

public class Mover {

    private final Asker asker;
    private final MoveParser parser;

    public Mover(Asker asker, MoveParser parser) {
        this.asker = asker;
        this.parser = parser;
    }

    public void move(Board board, PlayerMark mark) {
        String input = asker.ask("Enter square (1-9): ");

        while (true) {
            try {
                int square =  parser.parse(input);

                board.setMark(square, mark);

                break;
            } catch (InvalidInputException exception) {
                input = asker.ask("Invalid square, try again: ");
            }
        }
    }
}
