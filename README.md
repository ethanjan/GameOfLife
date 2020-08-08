# Game of Life
This program utilizes a 20x20 grid to simulate the famous "Game of Life" developed by John Conway.

## Implementation
This program is based on a 22x22 two-dimensional array, of which the middle 20x20 portion is reserved for the simulation. This program reads input from an input file (named "life100.txt") in order to create the starting conditions for the program, and it also has methods designed to determine the number of cells that are still alive. During every generation, this program simulates the Game of Life in order to determine which cells live on to see the next generation.

## Prerequisites
Because this program reads input from the file named "life100.txt", it is necessary to understand how to properly input values into this file. The first line represents the number of grid spaces to be used in the program. For each of the subsequent lines, the first number represents the row number, and the second number represents the column number; together, these numbers make up the location of a single live cell in the beginning of the simulation.

## Usage
In order to utilize this program, it is necessary to first download this project and Eclipse and to import this project within Eclipse. Afterwards, it is necessary to execute this program within Eclipse. Furthermore, to change the starting parameters of this program, it is necessary to change the values in the file named "life100.txt." The number of generations to be simulated can also be altered within the tester class.