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