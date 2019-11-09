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
    Then Update booking/id endpoint returns status code - 200
    And Updated booking service request fields are correct

  Scenario: Get booking by id
    Given A POST call with body sent to booking endpoint
    And Initial booking id is saved
    When I call booking service by id
    Then Get booking/id endpoint returns status code - 200
    And Get Booking/id service requests fields are not corrupted

  Scenario: Delete booking
    Given A POST call with body sent to booking endpoint
    And Initial booking id is saved
    When I call delete booking endpoint with existing id
    And I call booking service by id
    Then Delete booking/id endpoint returns status code - 201
    And Get booking/id endpoint returns status code - 404
    And I receive 'Not Found' when searching for non existing booking
