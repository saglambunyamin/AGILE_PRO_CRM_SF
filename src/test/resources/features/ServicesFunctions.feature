Feature: Training functions.
  Agile Story: As a user, I should be able to land on Services menu;
so that I can use Training functions.

  Background:
    When User goes to url
    And User enters valid username
    And User enters valid password
    And User clicks to Login Button and goes to Home page
    And User goes to Services page
    And User clicks to Training tab


  @test1, @wip
Scenario: User can display his/her courses.
When User clicks to My Courses tab
Then User can display the courses

@test2, @wip
Scenario: User can display his/her grades.
When User clicks to Grade Book tab
Then User can display the grades

@test3, @wip
Scenario: User can edit his/her personal data under Student's Profile
When User clicks to Profile tab
Then User can edit personal data under Profile