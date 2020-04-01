Feature: Lab4
Scenario: Login successfully
    Given Open login page
    When Try to login with Username: 'tran.trongtien.54' and Password: '53230eb89891d8ebe75c0d296841789fae3b7bb8' 
    Then Check if login is success

Scenario: Search
    When Try to search: 'facebook'
    Then Check result of searching

Scenario: Check Title
		Given Open home page
    Then Check title home page
    
Scenario: Check Test Post
		Given Open profile page
    Then Check test post
    
Scenario: Test Like
		When Do a like
    Then Check like
    
Scenario: Login failed
    Given Logout
    When Try to login with Username: 'tran.trongtien.54' and Password: '53230eb89891d8ebe75c' 
    Then Check if login is failed
    And Shut down driver
    
