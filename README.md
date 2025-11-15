# Minimal Rock Paper Scissors - Java 25 with Maven 4

The smallest possible implementation of Rock Paper Scissors game using Java 25 features and Maven 4.

## Features

- **Ultra-compact**: Complete game in just a few lines of code
- **Java 25**: Leverages the latest Java features including:
  - Unnamed main methods (`void main()`)
  - `var` type inference
  - Modern collections API
- **Maven 4**: Uses Maven for compilation validation with:
  - Maven Wrapper for consistent builds
  - Alternatively, run with any Maven 3 version
- **Direct Execution**: No complex build artifacts - run source directly with `java src/App.java`
- **Single-turn gameplay**: Play one round at a time
- **Smart logic**: Uses modular arithmetic for win/lose detection

## The Code

The entire game fits in 10 lines of readable code:

```java
void main() {
    var u = IO.readln("rock/paper/scissors:\n");
    if (u.equals("exit")) return;
    var c = "rock,paper,scissors".split(",");
    var i = List.of(c).indexOf(u);
    if (i < 0) return;
    var j = new Random().nextInt(3);
    IO.println("Computer: " + c[j]);
    IO.println(i == j ? "Tie!" : (i == (j + 1) % 3 ? "You win!" : "Computer wins!"));
}
```

### Understanding the algorithm

The win logic uses modular arithmetic:
- Rock (0) beats Scissors (2): `0 == (2 + 1) % 3` ✓
- Paper (1) beats Rock (0): `1 == (0 + 1) % 3` ✓  
- Scissors (2) beats Paper (1): `2 == (1 + 1) % 3` ✓

This eliminates the need for complex conditional logic or enums.

## How to Run

### Prerequisites
- Java 25+ (for both compilation and execution)
- Maven 4 (automatically handled by Maven Wrapper - only needed for compilation validation). `pom.xml` is compatible with Maven 3 as well.

### Building and Running with Maven Wrapper

The project uses Maven 4 only for compilation. Running is done directly with Java 25:

```bash
# Build the project (optional - only needed for IDE support or validation)
./mvnw verify

# Run directly with Java 25 (recommended)
echo "rock" | java src/App.java

# Interactive play
java src/App.java

# On Windows
mvnw.cmd verify
echo rock | java src\App.java
```

### Building and Running with local Maven

If you have Maven 3 or Maven 4 installed locally:

```bash
# Compile (optional)
mvn verify

# Run directly
echo "paper" | java src/App.java
```

### Gameplay

1. Type `rock`, `paper`, or `scissors`
2. See the computer's choice and result
3. Type `exit` to quit

## Project Structure

```
├── .mvn/                     # Maven 4 configuration
│   ├── wrapper/             # Maven Wrapper files
│   └── maven.config         # Root project identifier
├── src/
│   └── App.java             # The complete game implementation  
├── mvnw                     # Maven Wrapper script (Unix)
├── mvnw.cmd                 # Maven Wrapper script (Windows)
├── pom.xml                  # Maven 4 configuration for Java 25
└── README.md                # This file
```
