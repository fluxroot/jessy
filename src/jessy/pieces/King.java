package jessy.pieces;

import jessy.Board;
import jessy.Color;
import jessy.Coord;
import jessy.NotAField;
import jessy.pieces.Figure;

public final class King extends Figure {

	public King() {
		super();
	}

	public King(Color color) {
		super(color);
	}

	protected char getBasicUnicode() {
		return '\u2654';
	}

	public boolean canMove(final Board board, Coord current, Coord cnew) {
		Coord coordCurrent = new Coord(current.getX(), current.getY());
		Coord coordNew = new Coord(cnew.getX(), cnew.getY());

		try {
			// up
			if (coordNew.getX() == coordCurrent.getX() && coordNew.getY() > coordCurrent.getY()) {
				coordCurrent.increaseY(1);
				if (!isAllowedMove(board, coordCurrent, coordNew)) {
					return false;
				}
				return true;
			}
			// up-right diagonal
			else if (coordNew.getX() > coordCurrent.getX() && coordNew.getY() > coordCurrent.getY()) {
				coordCurrent.increase(1);
				if (!isAllowedMove(board, coordCurrent, coordNew)) {
					return false;
				}
				return true;
			}
			// right
			else if (coordNew.getX() > coordCurrent.getX() && coordNew.getY() == coordCurrent.getY()) {
				coordCurrent.increaseX(1);
				if (!isAllowedMove(board, coordCurrent, coordNew)) {
					return false;
				}
				return true;
			}
			// down-right diagonal
			else if (coordNew.getX() > coordCurrent.getX() && coordNew.getY() < coordCurrent.getY()) {
				coordCurrent.decreaseY(1);
				coordCurrent.increaseX(1);
				if (!isAllowedMove(board, coordCurrent, coordNew)) {
					return false;
				}
				return true;
			}
			// down
			else if (coordNew.getX() == coordCurrent.getX() && coordNew.getY() < coordCurrent.getY()) {
				coordCurrent.decreaseY(1);
				if (!isAllowedMove(board, coordCurrent, coordNew)) {
					return false;
				}
				return true;
			}
			// down-left diagonal
			else if (coordNew.getX() < coordCurrent.getX() && coordNew.getY() < coordCurrent.getY()) {
				coordCurrent.decreaseY(1);
				coordCurrent.decreaseX(1);
				if (!isAllowedMove(board, coordCurrent, coordNew)) {
					return false;
				}
				return true;
			}
			// left
			else if (coordNew.getX() < coordCurrent.getX() && coordNew.getY() == coordCurrent.getY()) {
				coordCurrent.decreaseY(1);
				if (!isAllowedMove(board, coordCurrent, coordNew)) {
					return false;
				}
				return true;
			}
			// up-left diagonal
			else if (coordNew.getX() < coordCurrent.getX() && coordNew.getY() > coordCurrent.getY()) {
				coordCurrent.increaseY(1);
				coordCurrent.decreaseX(1);
				if (!isAllowedMove(board, coordCurrent, coordNew)) {
					return false;
				}
				return true;
			}
		} catch (NotAField ex) {
			// TODO
		}
		return false;
	}
}
