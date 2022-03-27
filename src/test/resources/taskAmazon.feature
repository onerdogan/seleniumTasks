Feature: Visit a page and click on a link

  @test
  Scenario: Visit a page and check the page with logo
    Given go to amazon and validate
    Then sign in
    Then search "samsung"
    Then select S22 and add prices textfile
    Then add product to shoping list and validate
    Then delete product from list and control this