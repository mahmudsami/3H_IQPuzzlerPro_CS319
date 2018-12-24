# JOKERS_IQPuzzlerPro_CS319
IQ Puzzler Pro game for the Object-Oriented Software Engineering Course
## Group Members
* Ravan Aliyev
* Mahmud Sami Aydın
* Cihan Erkan
* Subhan Ibrahimli
* Ismayil Mammadov
* Burak Erdem Varol
## Description of the Project
The project is an implementation of IQ Puzzler Pro game. The purpose is develop an object oriented software by team. Following section describe the orijinal game, implementation and some features can be added.
### Description of the IQ Puzzler Pro
The game is single player brain teaser. Physically it contains 12 pieces which can be observed as tromino (1), tetrominos (3)  and pentominos (8). Goal of the game is cover the board by using whole pieces without overlap. For the 2-dimensional case, board has 2 different configuration, one of them is standard 5x11 board and the other is a diagonal board ( its colomns are has height 2,3,4,5,4,3,4,5,4,3,4,5,4,3,2 ).  For the 3-dimensional case, board is 5x5 and the challenge is creating pyramid with all pieces. In total there are 120 levels with mentioned boards, where each level has unique solution[1]. However there is variant of the same game, called Kanoodle[2], has different levels in it. Therefore levels, which can be implemented, are over 200.
### Implementation of the Game
#### Interface
There will be isometric interface which allows player to control easily and provides depth of sight.
#### Modes
There will be three modes of game:
1. **Story Mode:** Player plays original levels consequtively according to level numbers. The player is always challenging with the first level not solved yet.
2. **Creative Mode:** Player can create a puzzle and level checker checks the puzzle whether the puzzle has an unique solution.
3. **Free Mode:** Player play original levels which are already solved in story mode or levels which created by Creative Mode.
#### Control
Mainly control will be drag & drop with mouse. Keyboard will be helper for the rotation issues.
### New Features
1. **Level Checker:** It is a module which test manuel created levels in terms of level criterias.
2. **Achievements:** There are trophies which will be given for some success in the levels such as finish level in certain time or not using undo.
3. **Multiplayer** Players can play game in a multiplayer game mode.
## References
[1] https://engineering.purdue.edu/INSPIRE/Reviews/puzzles/iq-puzzler-pro

[2] https://vidweb.aws.marketlive.com/learningresources_vid/text/pdf/2978_EIguide.pdf
