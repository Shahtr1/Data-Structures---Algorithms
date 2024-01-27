function LongestWord(sen) {
  // code goes here
  let longestWord = "";
  let selectedWord = "";
  for (let i = 0; i < sen.length; i++) {
    if (isAlpha(sen[i])) {
      selectedWord += sen[i];
      if (selectedWord.length > longestWord.length) {
        longestWord = selectedWord;
      }
    } else {
      selectedWord = "";
    }
  }
  return longestWord;
}

function isAlpha(char) {
  return !!char.match(/[a-zA-Z]/);
}

const str1 = "fun&!! time";
const str2 = "time!! 3";
console.log(LongestWord(str2));
