$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/HP/Documents/Framework/SeleniumPractice/features/ExcelData.feature");
formatter.feature({
  "line": 1,
  "name": "Excel reader feature",
  "description": "",
  "id": "excel-reader-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "User login to WordpressApplication",
  "description": "",
  "id": "excel-reader-feature;user-login-to-wordpressapplication",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User Lauches the applicaton",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User loads below fixture file at \"C:/Users/HP/Documents/Framework/SeleniumPractice/fixtures/TestData.xlsx\"",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "User closes the wordpress application",
  "keyword": "Then "
});
formatter.match({
  "location": "ReadExcelDataTest.user_Lauches_the_applicaton()"
});
formatter.result({
  "duration": 1070733000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "C:/Users/HP/Documents/Framework/SeleniumPractice/fixtures/TestData.xlsx",
      "offset": 34
    }
  ],
  "location": "ReadExcelDataTest.user_loads_below_fixture_file_at(DataTable)"
});
formatter.result({
  "duration": 6328654699,
  "status": "passed"
});
formatter.match({
  "location": "ReadExcelDataTest.user_closes_the_wordpress_application()"
});
formatter.result({
  "duration": 71301,
  "status": "passed"
});
});