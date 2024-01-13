function reverseStringRecursively(value) {
  if (value === "") {
    return value;
  }
  return reverseStringRecursively(value.substr(1)) + value.charAt(0);
}

console.log(reverseStringRecursively("oobmarT hkurhahs"));

function reverseStringIteratively(value) {
  let reverseStr = "";
  let stringArray = value.split("");

  for (let i = 0; i < value.length; i++) {
    reverseStr = reverseStr + stringArray.pop();
  }

  return reverseStr;
}

console.log(reverseStringIteratively("oobmarT hkurhahs"));
