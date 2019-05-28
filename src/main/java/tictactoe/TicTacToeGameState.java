package tictactoe;

import framework.logic.GameState;

public class TicTacToeGameState extends GameState {

    private char[][] fields = new char[3][3];
    private String winner;

    public TicTacToeGameState() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.fields[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean isTurnRepeated() {
        return false;
    }

    @Override
    public void setTurnRepeated(boolean repeated) {

    }

    @Override
    public String getScore() {
        return winner;
    }

    public boolean occupyField(Field field, char player) {
        if (this.fields[field.getCol()][field.getRow()] == ' ') {
            this.fields[field.getCol()][field.getRow()] = player;
            field.setOccupied(player == 'X');
            return true;
        } else {
            return false;
        }
    }

    public boolean isFieldFree(Field field) {
        return this.fields[field.getCol()][field.getRow()] == ' ';
    }

    public boolean isOver() {
        for (char player : new char[]{'X', 'O'}) {
            for (int i = 0; i < 3; i++) {
                if ((fields[0][i] == player && fields[1][i] == player && fields[2][i] == player) || (fields[i][0] == player && fields[i][1] == player && fields[i][2] == player)) {
                    winner = String.valueOf(player);
                    return true;
                }
            }
            if ((fields[0][0] == player && fields[1][1] == player && fields[2][2] == player) || (fields[0][2] == player && fields[1][1] == player && fields[2][0] == player)) {
                winner = String.valueOf(player);
                return true;
            }
        }
        return false;
    }

}
