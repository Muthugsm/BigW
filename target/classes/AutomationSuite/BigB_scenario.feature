# Candidate Sellmuthu G
 
@tag
Feature: Verify BigW_Loation and Icon functionality

  Scenario: 
    Given The User is in BigW homepage
    
    When User Clicks on SetLocation
    
    And The user Enters "2150" Location
    
    When Select the first Entry
      
    And The user should see the Location
      
    And user navigate to Product Details
    
    And user click the addToCart 
    
    Then Validate the updated Cart Icon 
    
    
       
