/*
public class Test2 {

    private void newGame() {
        do {
            reset(); // reset in intial state
            shuffle(); // shuffle
        } while (!isSolvable()); // make it until grid be solvable

        gameOver = false;
    }

    private void reset() {
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = (i + 1) % tiles.length;
        }

        // we set blank cell at the last
        blankPos = tiles.length - 1;
    }

    private void shuffle() {
        // don't include the blank tile in the shuffle, leave in the solved position
        int n = nbTiles;

        while (n > 1) {
            int r = RANDOM.nextInt(n--);
            int tmp = tiles[r];
            tiles[r] = tiles[n];
            tiles[n] = tmp;
        }
    }

    // Only half permutations o the puzzle are solvable
// Whenever a tile is preceded by a tile with higher value it counts
// as an inversion. In our case, with the blank tile in the solved position,
// the number of inversions must be even for the puzzle to be solvable
    private boolean isSolvable() {
        int countInversions = 0;

        for (int i = 0; i < ; i++) {
            for (int j = 0; j < i; j++) {
                if (tiles[j] > tiles[i])
                    countInversions++;
            }
        }

        return countInversions % 2 == 0;
    }

    private boolean isSolved() {
        if (tiles[tiles.length - 1] != 0) // if blank tile is not in the solved position ==> not solved
            return false;

        for (int i = nbTiles - 1; i >= 0; i--) {
            if (tiles[i] != i + 1)
                return false;
        }

        return true;
    }
}

 */