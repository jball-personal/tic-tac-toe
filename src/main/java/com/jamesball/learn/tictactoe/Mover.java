package com.jamesball.learn.tictactoe;

public class Mover {

    private final MoveAsker asker;
    private final MoveParser parser;

    public Mover(MoveAsker asker, MoveParser parser) {
        this.asker = asker;
        this.parser = parser;
    }

    public void move(Board board, char mark) {
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
