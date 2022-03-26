Feature: Visit a page and click on a link

  @test
  Scenario: Visit a page and check the page title
    Given go to amazon and validate
    Then sign in
    Then search "samsung"
    Then select S22 and add price textfile
    Then add to list and create shoping list