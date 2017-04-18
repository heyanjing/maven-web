var data = [
  {
    "name": "Pete",
    "address": {
      "street": "12 Pike Place",
      "city": "Seattle",
      "ZIP": "98101"
    }
  },
  {
    "name": "Heidi",
    "address": {
      "street": "5000 Broadway",
      "city": "Sidney",
      "country": "Australia"
    }
  }
];
data={
    "name": "Pete",
    "address": {
      "street": "12 Pike Place",
      "city": "Seattle",
      "ZIP": "98101"
    },
    "arr":[1,2,3,4]
};
$("#tpl").html(
  $('#teamTemplate').render(data)
);
