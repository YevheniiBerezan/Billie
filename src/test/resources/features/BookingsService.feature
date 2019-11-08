Feature: Check if booking service gets called

  @Smoke
  Scenario: Call booking service and get status 200
    Given A POST call with body sent to booking endpoint
    Then Booking endpoint returns status code - 200
    And Booking service request / response fields are not corrupted
    And Booking service response booking ID field has value

  Scenario: Amend booking with new details
    Given A POST call with body sent to booking endpoint
    And Initial booking id is saved
    When We amend the booking with new details
    Then Booking/id endpoint returns status code - 200
    And Updated booking service request fields are correct