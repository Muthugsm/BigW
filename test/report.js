$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/JB JK/Pictures/eclipsss/BigW_Test/src/resource/java/AutomationSuite/BigB_scenario.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# Candidate Sellmuthu G"
    }
  ],
  "line": 4,
  "name": "Verify BigW_Loation and Icon functionality",
  "description": "",
  "id": "verify-bigw-loation-and-icon-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@tag"
    }
  ]
});
formatter.before({
  "duration": 34290947643,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "",
  "description": "",
  "id": "verify-bigw-loation-and-icon-functionality;",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "The User is in BigW homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User Clicks on SetLocation",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "The user Enters \"2150\" Location",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Select the first Entry",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "The user should see the Location",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "user navigate to Product Details",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "user click the addToCart",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "Validate the updated Cart Icon",
  "keyword": "Then "
});
formatter.match({
  "location": "BigW_HomePage_Test.the_User_is_in_BigW_homepage()"
});
formatter.result({
  "duration": 4317630950,
  "status": "passed"
});
formatter.match({
  "location": "BigW_HomePage_Test.user_Clicks_on_SetLocation()"
});
formatter.result({
  "duration": 919569391,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2150",
      "offset": 17
    }
  ],
  "location": "BigW_HomePage_Test.the_user_Enters_Location(String)"
});
formatter.result({
  "duration": 471274916,
  "status": "passed"
});
formatter.match({
  "location": "BigW_HomePage_Test.select_the_first_Entry()"
});
formatter.result({
  "duration": 2393861370,
  "status": "passed"
});
formatter.match({
  "location": "BigW_HomePage_Test.the_user_should_see_the_Location()"
});
formatter.result({
  "duration": 120209473,
  "status": "passed"
});
formatter.match({
  "location": "BigW_HomePage_Test.user_navigate_to_Product_Details()"
});
formatter.result({
  "duration": 9879842779,
  "status": "passed"
});
formatter.match({
  "location": "BigW_HomePage_Test.user_click_the_addToCart()"
});
formatter.result({
  "duration": 2800436208,
  "status": "passed"
});
formatter.match({
  "location": "BigW_HomePage_Test.validate_the_updated_Cart_Icon()"
});
formatter.result({
  "duration": 922077934,
  "status": "passed"
});
});