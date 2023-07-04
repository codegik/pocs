module.exports.addSeconds = function (time, plusSeconds) {
  const dateTime = time.split(" ");

  const sliceDate = dateTime[0].split("-");
  const sliceTime = dateTime[1].split(":");

  const oneMin = 60;
  const oneHour = 60 * oneMin;
  const oneDay = 24 * oneHour;
  const oneMonth = 30 * oneDay;
  const oneYear = 12 * oneMonth;
  const wholeYear = 365 * oneYear;

  const restSec = plusSeconds % 60;
  const restMin = (plusSeconds % oneHour) / oneMin;
  const restHour = (plusSeconds % oneDay) / oneHour;
  const restDay = (plusSeconds % oneMonth) / oneDay;
  const restMonth = (plusSeconds % oneYear) / oneMonth;
  const restYear = (plusSeconds % wholeYear) / oneYear;

  const sec = parseInt(sliceTime[2]) + parseInt(restSec);
  const min = parseInt(sliceTime[1]) + parseInt(restMin);
  const hour = parseInt(sliceTime[0]) + parseInt(restHour);
  const day = parseInt(sliceDate[2]) + parseInt(restDay);
  const month = parseInt(sliceDate[1]) + parseInt(restMonth);
  const year = parseInt(sliceDate[0]) + parseInt(restYear);

  return (
    ("0000" + year).slice(-4) +
    "-" +
    ("00" + month).slice(-2) +
    "-" +
    ("00" + day).slice(-2) +
    " " +
    ("00" + hour).slice(-2) +
    ":" +
    ("00" + min).slice(-2) +
    ":" +
    ("00" + sec).slice(-2)
  );
};
