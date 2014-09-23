### Tic-tac-toe ###

*Implementation of the famous Tic-tac-toe game. The main purpose of the game was to come up with a clever and simple AI. At the end just based on two factors, the computer is able to play "perfectly".
*

**How does the AI work:
**

* Position of the boxes - some of the boxes actually give higher chance of winning as the box is part of more rows/columns/diagonals. For example the centre box is in one row, one column and two diagonals, while the top-middle box is only in one row and one column. We can rank the boxes as follows (the higher the better):
 
     ![TicTacToe-boxes.png](https://bitbucket.org/repo/orkrAB/images/3149865328-TicTacToe-boxes.png)

* Moves played so far - the other factor to take into account is the position of all the noughts and crosses so far. For every row/column/diagonal we can have one of the following combinations (only the count, not the position is important):

     ![TicTacToe.png](https://bitbucket.org/repo/orkrAB/images/2979341655-TicTacToe.png)
     ![TicTacToe-O1.png](https://bitbucket.org/repo/orkrAB/images/848356264-TicTacToe-O1.png)
     ![TicTacToe-O2.png](https://bitbucket.org/repo/orkrAB/images/2706541984-TicTacToe-O2.png)
     ![TicTacToe-X1.png](https://bitbucket.org/repo/orkrAB/images/447179349-TicTacToe-X1.png)
     ![TicTacToe-X2.png](https://bitbucket.org/repo/orkrAB/images/1796123170-TicTacToe-X2.png)
     ![TicTacToe-XO.png](https://bitbucket.org/repo/orkrAB/images/1032977316-TicTacToe-XO.png)

We do through all the boxes and for them - all the rows/columns/diagonals for which the chosen box is part of. Then we are searching for a situation in the following order (if were are playing with crosses):

1) two crosses (we put the third one and win)

2) two noughts (if we don't put one, then the opponent can win next turn)

3) one cross (the next better)

4) one nought (the next better)

5) nothing (the next better)

6) one nought, one cross (there is no point in playing)

Only if we have tight result we go back to the first criteria to decide the best move.

**Languages/Libraries used:
**

* Java (Slick2D)

**Screenshots:
**

![TicTacToe1.png](https://bitbucket.org/repo/orkrAB/images/1471687093-TicTacToe1.png)
![TicTacToe2.png](https://bitbucket.org/repo/orkrAB/images/1728871775-TicTacToe2.png)
![TicTacToe3.png](https://bitbucket.org/repo/orkrAB/images/3137186830-TicTacToe3.png)