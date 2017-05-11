// https://jsfiddle.net/tylercweng/vu33ufqy/

document.addEventListener("DOMContentLoaded", function () {
  const start = document.getElementById('start');
  start.addEventListener("click", tick);
});

function tick() {
  const numHrs = document.getElementById("hh").value;
  const numMins = document.getElementById("mm").value;
  const numSecs = document.getElementById("ss").value;
  const startDate = new Date().getTime();
  const endDate = startDate +
                  (numHrs * 1000 * 60 * 60) +
                  (numMins * 1000 * 60) +
                  (numSecs * 1000);
  let diff = endDate - startDate;

  const pad = int => {
    const str = int.toString();
    return (str.length < 2) ? "0" + str : str;
  };

  window.setInterval(function() {
    let hh = Math.floor(diff / (1000 * 60 * 60 )) > 0
               ? Math.floor(diff / (1000 * 60 * 60 ))
               : 0;
    let mm = Math.floor((diff % (1000 * 60 * 60 )) / (1000 * 60)) > 0
               ? Math.floor((diff % (1000 * 60 * 60 )) / (1000 * 60))
               : 0;
    let ss = Math.floor((diff % (1000 * 60)) / (1000)) > 0
               ? Math.floor((diff % (1000 * 60)) / (1000))
               : 0;

    document.getElementById("timer").innerHTML = (
      pad(hh) + " hours, " +
      pad(mm) + " minutes, " +
      pad(ss) + " seconds remaining"
    );

    diff -= 1000;
  }, 1000);
}
