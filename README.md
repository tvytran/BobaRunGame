# Boing Boing Boba

A Java-based 2D game where players navigate through various levels collecting stars and avoiding enemy tea objects while manipulating boba pearls.

## Game Overview

In Boing Boing Boba, you control a character that moves around the screen, collecting stars for points while avoiding different types of tea that act as enemies. You can place or remove boba pearls as obstacles or pathways to navigate the game world. The game consists of 5 levels with increasing difficulty, each with unique layouts and challenges.

## Game Elements

- **Player Character**: A boba-themed character controlled by the user
- **Bobas**: Black pearls that can be placed or removed by the player, which serve as barriers or tools
- **Stars**: Collectible items that give the player points
- **Jelly Cubes**: Special collectible items that appear after reaching certain point thresholds
- **String Jellies**: Moving collectible items that bounce around the screen
- **Enemy Teas**: Various types of tea (Thai Tea, Jasmine Tea, Matcha Tea, Oolong Tea) that move around the screen and cause game over if they collide with the player

## Controls

- **Arrow Keys** or **WASD**: Move the player character
- **F**: Place boba pearls in the direction the player is facing (creates a line until reaching a wall or obstacle)
- **E**: Remove a nearby boba pearl
- **B**: Begin the game (from instructions screen)
- **R**: Restart the game (after game over or winning)

## Levels

1. **Level 1**: Introduction level with Thai Tea enemies
2. **Level 2**: Features Jasmine Tea enemy with a central wall of bobas
3. **Level 3**: Features Matcha Tea enemy with more complex boba arrangements
4. **Level 4**: Features Oolong Tea enemy that moves intermittently
5. **Level 5**: Final level with multiple types of enemies

## Gameplay Mechanics

- **Point System**: Collect stars and jellies to gain points
- **Level Progression**: Each level is completed when a certain point threshold is reached
- **Enemy Movement**: Different tea enemies have unique movement patterns - some follow you, some bounce around
- **Collision Detection**: The game handles collisions between the player, enemies, collectibles, and boba pearls
- **Game Over**: Occurs when the player collides with any enemy tea
- **Victory**: Achieved when all five levels are completed

## Technical Implementation

The game is built using Java Swing for graphics rendering and utilizes object-oriented programming concepts with the following main classes:

- `TranProj8b`: Main game class handling initialization, game loop, and input
- `TranPlayer`: Player character class
- `TranBoba`: Class for boba pearl objects
- `TranStar`, `TranJellyCube`, `TranStringJelly`: Different collectible classes
- `TranThaiTea`, `TranJasmineTea`, `TranMatchaTea`, `TranOolongTea`: Enemy classes

## Running the Game

1. Ensure you have Java installed on your system
2. Compile all the `.java` files
3. Run the `TranProj8b` class

```bash
javac *.java
java TranProj8b
```

## Images and Resources

The game requires the following image resources (which should be in the same directory as the `.class` files):
- Boba.png
- Star.png
- JellyCube.png
- JellyString.png
- ReverseJellyString.png
- ThaiTea.png
- ReverseThaiTea.png
- JasmineTea.png
- ReverseJasmineTea.png
- MatchaTea.png
- ReverseMatchaTea.png
- OolongTea.png
- ReverseOolongTea.png
- bobaUp.png
- bobaDown.png
- bobaLeft.png
- bobaRight.png
- bobaForward.png
- Directions.png
- gameOver.png
- win.png

## Credits

This game was created as a Java programming project showcasing object-oriented design principles, collision detection, and game development concepts.
