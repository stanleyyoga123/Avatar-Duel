# IF2210 Avatar Duel

This is a game project based of class assignments maintained and developed by a team consists of 5 people.


***Prerequisites***
---
Java Development Kit 8 and Gradle Build Tools 6.3

***Build and Run***
---
On Windows:
Run command prompt on Avatar-Duel directory and run this command: `gradlew run`

On Linux:
Run command prompt on Avatar-Duel directory and run this command: `./gradlew run`


What happen is when you use `gradlew run` or `./gradlew run`, it will start the main function in this app.
For this app, the main function lives in `AvatarDuel.java`.

## Documentation

Source code can be accessed in the `src` directory. This program is built with several packages which will be explained below:

#### Controller

This package handles the interface and layout of the program. This package consist of these classes: `ArenaController`, `CardHandController`, `CardRender`, `CharacterController`, `CloseCardLayoutController`, `MidFieldController`, `Utility`, and interface `CardLayout`.

#### Model

Model package builds basic components of the program. This package also has attribute package and type package.

Attribute package consists of these classes:

* `Attribute` defines attack, defense, and power of cards.
* `Deck` defines cards on decks.
* `MidDeck` defines cards being played on middle deck.
* `Power` defines amount of powers from players.
* `RemainingPower` defines remaining amount of powers from players.

Type package consists of these enumerations:

* `Effect`: Aura, Destroy, Power Up
* `Element`: Water, Fire, Air, Earth, Energy

`Card` is an abstract parent class for cards. 
This class has `name`, `element`, and `description` as attributes and can be modified with getter and setter. `Character`, `Land`, and `Skill` inherit `Card`. Character has additional `attribute` attribute, and `Skill` has additional `effect` and `attribute` attributes.

`HandDeck` inherits `Deck` from attribute package. This class defines cards belong to players.

`Player` defines player's stats, including hand cards, middle deck cards, power, and health.

####
## Credit

All images and description are taken from [Avatar Wikia](https://avatar.fandom.com/wiki/Avatar_Wiki)
