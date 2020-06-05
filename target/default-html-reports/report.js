$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Account_Summary.feature");
formatter.feature({
  "name": "Account Summary",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@account_summary"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepdefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with valid credentials",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepdefs.the_user_logs_in_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Account Summary Page and Account Types",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@account_summary"
    }
  ]
});
formatter.step({
  "name": "The page title should be \"Zero - Account Summary\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepdefs.the_page_title_should_be(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepdefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with valid credentials",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepdefs.the_user_logs_in_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Account Types",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@account_summary"
    }
  ]
});
formatter.step({
  "name": "the system should display following account types",
  "rows": [
    {},
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.AccountSummaryDefs.the_system_should_display_following_account_types(java.util.List\u003cjava.lang.String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the login page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepdefs.the_user_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in with valid credentials",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.LoginStepdefs.the_user_logs_in_with_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Credit Account Columns",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@account_summary"
    }
  ]
});
formatter.step({
  "name": "the system credit account table must have",
  "rows": [
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.AccountSummaryDefs.the_system_credit_account_table_must_have(java.util.List\u003cjava.lang.String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});