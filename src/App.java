void main() {
    var c = "rock/paper/scissors".split("/");
    var u = IO.readln(String.join("/", c) + ": \n");
    var i = List.of(c).indexOf(u);
    if (i < 0) return;
    var j = new Random().nextInt(3);
    IO.println("Computer: " + c[j]);
    IO.println(i == j ? "Tie!" : (i == (j + 1) % 3 ? "You win!" : "Computer wins!"));
}