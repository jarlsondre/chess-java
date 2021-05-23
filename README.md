## Chess in Java

This is the chess project I made to practice Java and JavaFX. 


Implemented features:
- Only legal moves allowed
- Auto aligning pieces
- Capturing pieces
- Indicator when in check
- Indicator when in check mate
- Castling
- En Passant
- Restarting (slightly bugged)
- Promotion when a pawn reaches the end (auto-queen is enabled)

Bugs:
- If you attempt to castle but can't (because your king will be in check) then the king is moved back, but the rook actually moves. There is a disconnect between the internal board and the GUI
- When restarting the game while it's black's turn, the game will continue to say that it is black's turn even though white has the first move. This is just a graphical bug as white is the only one that can move and after white moves the graphics will work again
