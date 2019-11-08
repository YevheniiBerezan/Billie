Feature: Check if booking service gets called

  Scenario: Call booking service and get status 200
    Given A POST call with body sent to booking endpoint
    Then Booking endpoint returns status code - 200
    And Booking service request / response fields are not corrupted
    And Booking service response booking ID field has value


  Scenario: Call booking service with no body and get status 500
	  Given A POST call with no body sent to booking endpoint
	  Then Booking endpoint returns status code - 500