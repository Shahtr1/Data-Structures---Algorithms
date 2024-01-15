// Method of finding target value within a list O(n)
var beasts = ["Centaur", "Godzilla", "Mosura", "Minotaur", "Hydra", "Nessie"];

console.log(beasts.indexOf("Godzilla"));

console.log(beasts.findIndex((item) => item === "Godzilla"));

console.log(beasts.find((item) => item === "Godzilla"));

console.log(beasts.includes("Godzilla"));
