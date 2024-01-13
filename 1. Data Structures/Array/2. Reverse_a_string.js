function reverse(str) {
  return str.split("").reverse().join(""); // O(2n)
}

const reverse2 = (str) => [...str].reverse().join("");

console.log(reverse("hkurhahs"));
console.log(reverse2("hkurhahs"));
