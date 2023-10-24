$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/epicModule.feature");
formatter.feature({
  "line": 2,
  "name": "Epic module creation",
  "description": "",
  "id": "epic-module-creation",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@SmokeTest"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Create Epic module",
  "description": "",
  "id": "epic-module-creation;create-epic-module",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "the user is on signin page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the user enters valid details and clicks on signin",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the user is on homePage",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "the user hovers on menu",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the user clicks on project",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the user is on projectPage",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "the user hovers on execute menu",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "the user clicks on epics",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "the user is on epicModulePage",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.the_user_is_on_signin_page()"
});
formatter.result({
  "duration": 3874696700,
  "error_message": "java.lang.AssertionError: session not created: This version of ChromeDriver only supports Chrome version 93\nCurrent browser version is 118.0.5993.70 with binary path C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-U91VT5D\u0027, ip: \u0027192.168.137.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002714.0.2\u0027\nDriver info: driver.version: ChromeDriver\nremote stacktrace: Backtrace:\n\tOrdinal0 [0x008EA2D3+2663123]\n\tOrdinal0 [0x0087A491+2204817]\n\tOrdinal0 [0x00762118+1057048]\n\tOrdinal0 [0x0078041A+1180698]\n\tOrdinal0 [0x0077C335+1164085]\n\tOrdinal0 [0x00779B7F+1153919]\n\tOrdinal0 [0x007A9D8F+1351055]\n\tOrdinal0 [0x007A99FA+1350138]\n\tOrdinal0 [0x007A589B+1333403]\n\tOrdinal0 [0x00781F74+1187700]\n\tOrdinal0 [0x00782DC9+1191369]\n\tGetHandleVerifier [0x00A830D6+1610054]\n\tGetHandleVerifier [0x00B2B53B+2299307]\n\tGetHandleVerifier [0x00978DA9+519705]\n\tGetHandleVerifier [0x00977759+513993]\n\tOrdinal0 [0x0088112D+2232621]\n\tOrdinal0 [0x008855F8+2250232]\n\tOrdinal0 [0x00885732+2250546]\n\tOrdinal0 [0x0088E591+2286993]\n\tBaseThreadInitThunk [0x75F17BA9+25]\n\tRtlInitializeExceptionChain [0x771DBC5B+107]\n\tRtlClearBits [0x771DBBDF+191]\n\r\n\tat org.testng.Assert.fail(Assert.java:99)\r\n\tat com.selenium.baseclass.baseClass.reportFail(baseClass.java:166)\r\n\tat com.selenium.baseclass.baseClass.invokeBrowser(baseClass.java:60)\r\n\tat com.selenium.stepdefinition.stepDefinition.the_user_is_on_signin_page(stepDefinition.java:27)\r\n\tat ✽.Given the user is on signin page(Features/epicModule.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "stepDefinition.the_user_enters_valid_details_and_clicks_on_signin()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.the_user_is_on_homepage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.the_user_hovers_on_menu()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.the_user_clicks_on_project()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.the_user_is_on_projectpage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.the_user_hovers_on_execute_menu()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.the_user_clicks_on_epics()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.the_user_is_on_epicmodulepage()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 18,
  "name": "Generating id in Epics module",
  "description": "",
  "id": "epic-module-creation;generating-id-in-epics-module",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 19,
  "name": "the user is on epicModulePage",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on add button",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "the user enters Name \u003cname\u003e ,Date \u003cdate\u003e ,Description \u003cdesc\u003e ,Priority \u003cpriority\u003e and Size \u003csize\u003e in respective fields",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "the user clicks on Save button",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "the Epic id is generated",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "user enters invalid details or leaves mandatory fields empty",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "user clears the name field",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "user clears the date field",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "user clicks on Save button",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user handles the Alerts",
  "keyword": "Then "
});
formatter.examples({
  "line": 32,
  "name": "",
  "description": "",
  "id": "epic-module-creation;generating-id-in-epics-module;",
  "rows": [
    {
      "cells": [
        "name",
        "date",
        "desc",
        "priority",
        "size"
      ],
      "line": 33,
      "id": "epic-module-creation;generating-id-in-epics-module;;1"
    },
    {
      "cells": [
        "Testing Team2",
        "03-Sep-2021",
        "Description",
        "Medium",
        "M"
      ],
      "line": 34,
      "id": "epic-module-creation;generating-id-in-epics-module;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 34,
  "name": "Generating id in Epics module",
  "description": "",
  "id": "epic-module-creation;generating-id-in-epics-module;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "the user is on epicModulePage",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "the user clicks on add button",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "the user enters Name Testing Team2 ,Date 03-Sep-2021 ,Description Description ,Priority Medium and Size M in respective fields",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "the user clicks on Save button",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "the Epic id is generated",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "user enters invalid details or leaves mandatory fields empty",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "user clears the name field",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "user clears the date field",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "user clicks on Save button",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "the user handles the Alerts",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.the_user_is_on_epicmodulepage()"
});
formatter.result({
  "duration": 3003663200,
  "error_message": "java.lang.NullPointerException: Cannot invoke \"com.selenium.pageclass.projectPage.gotoEpicModulePage()\" because \"com.selenium.stepdefinition.stepDefinition.projectpage\" is null\r\n\tat com.selenium.stepdefinition.stepDefinition.the_user_is_on_epicmodulepage(stepDefinition.java:49)\r\n\tat ✽.Given the user is on epicModulePage(Features/epicModule.feature:19)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "stepDefinition.the_user_clicks_on_add_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Testing Team2",
      "offset": 21
    },
    {
      "val": "03-Sep-2021",
      "offset": 41
    },
    {
      "val": "Description",
      "offset": 66
    },
    {
      "val": "Medium",
      "offset": 88
    },
    {
      "val": "M",
      "offset": 104
    }
  ],
  "location": "stepDefinition.the_user_enters_name_date_description_priority_and_size_in_respective_fields(String,String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.the_user_clicks_on_save_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.the_epic_id_is_generated()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.user_enters_invalid_details_or_leaves_mandatory_fields_empty()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.user_clears_the_name_field()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.user_clears_the_date_field()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.user_clicks_on_save_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "stepDefinition.the_user_handles_the_alerts()"
});
formatter.result({
  "status": "skipped"
});
});