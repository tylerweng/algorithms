const XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;

const coolNumsSum = 70601040511;

const baseUrl = "http://dev.getethos.com/code";
let str = "";
const letters = [];

for (let i = 1; i <= 100; i++) {
  const url = baseUrl + i.toString();
  const xhr = new XMLHttpRequest();
  xhr.open("POST", url, false);
  xhr.setRequestHeader("X-COOL-SUM", coolNumsSum);
  xhr.onreadystatechange = function() {
    if (xhr.status !== 404) {
      const res = xhr.responseText;
      if (res.length === 1) {
        str += res;
        console.log(str);
      }
    }
  }
  xhr.send();
}

console.log(str);
// ilovejavascript
