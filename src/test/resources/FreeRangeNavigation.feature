@Navigation
Feature: Navigation bar
      To see the subpages
      Without logging in
      I can click the navigation bar links

      Background: I am on the Free range Testers web without logging in.
       Given I navigate to www.freerangetesters.com
   
      Scenario Outline: I can access the subpages through the navigation bar
          When I go to <section> using the navigation bar
          Examples:
              | section               |
              | Blog                  |
              | Cursos                |
              | Recursos              |
              | Udemy                 |
              | Mentorías             |

      Scenario: Courses are presented correctly to potential customers
        When I go to Cursos using the navigation bar
        And select introduccion al Testing

      @Plans
      Scenario: Users can select plan when signing up
        When I select Elegir Plan
        Then I can validate the options in the checkout page