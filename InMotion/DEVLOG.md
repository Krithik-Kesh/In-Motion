##DEC 3 2025
I completed the basic render screen but I need to figure out how to shape the game panel depending on resolution size picked. 

##Dec 12 2025
Im currently working on the key input response but it doesn't seem to be working. Will keep trying, it seems the game loop isn't updating. So I will look into that. Moreover, we have created icon sprite models via gemini AI, these will be modified and implemented into the game. Just fixed the bug, needed to add startGameThread to the main, it wasnt running the loop.

##Dec 30 2025
Implemented the main character, currently its just a temporary one but Im going to replace it with the real character.

##Jan1st 2026
So now I have completely finished the sprite animation. the sprite animation as of now is extremely simple. The game loop runs 60 times, thus the update() runs 60 times. The reason we want this to run 60 times is because it fits into the 