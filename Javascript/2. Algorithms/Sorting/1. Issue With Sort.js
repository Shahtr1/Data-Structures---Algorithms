const letters = ["a", "d", "z", "e", "r", "b"];
const basket = [2, 65, 34, 2, 1, 7, 8];

const spanish = ["único", "árbol", "cosas", "fútbol"];

// all numbers get converted to string and their first character representation is used

console.log(letters.sort());

console.log(basket.sort()); // wrong
console.log(basket.sort((a, b) => a - b)); // fixed

console.log(spanish.sort()); // wrong
console.log(spanish.sort((a, b) => a.localeCompare(b))); // fixed

console.log("2".charCodeAt(0));
console.log("68".charCodeAt(0));
console.log("34".charCodeAt(0));
console.log("7".charCodeAt(0));
console.log("a".charCodeAt(0));
console.log("A".charCodeAt(0));
