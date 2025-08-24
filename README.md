Java version: 17
The projct uses maven to manage dependencies. Dependency versions are all configured in the pom file.
After setting up the project, run it.
An input message will show up in the console.
Enter the Chess Piece type and its starting position in the format: King, A5
Valid chess piece types are:
1. King
2. Queen
3. Pawn
4. Bishop
5. Rook

Currently, the program outputs moves assuming its a standard board of size 8x8.
The board looks like:
<img width="392" height="404" alt="image" src="https://github.com/user-attachments/assets/603b0fc0-e86e-44a1-87cc-cc7d6290befc" />

For Pawns, the assumption is that they are moving from bottom to top.
