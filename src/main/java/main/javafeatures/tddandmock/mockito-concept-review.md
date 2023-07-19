## Mockito Concepts review

- We can mock using [Mockito.mock()](CalcService1Test.java) and [@Mock](CalcService2Test.java), the different is that @Mock needs to initializa the Mocks in a setup method [Example]()
- We can create a Mock and define a behavior `when(mock.method()).thenReturn(something)`, if you don't define a behavior it will return `null` [Example](MockSingleElementTest.java)
- You can use `verify()` to check if a specific method was called in the Mock with a specific parameter. You can also use `VerificationModeFactory.times()` to check how many times that method was called, along with `verify()` [Example](VerifyInteractionTest.java)
- Instead of a Mock, you can create a Spy, that is a concrete class BUT you can override the methods you want with mocked behavior. [Example](MockitoSpyTest.java)

Source: https://www.digitalocean.com/community/tutorials/mockito-tutorial