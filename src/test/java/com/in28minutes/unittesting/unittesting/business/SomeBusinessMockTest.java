package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl someBusiness = new SomeBusinessImpl();

    @Mock
    SomeDataService someDataServiceMock = mock(SomeDataService.class);

    @Test
    public void calculateSumUsingDataService_basic() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(6, someBusiness.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_empty() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, someBusiness.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_oneValue() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5, someBusiness.calculateSumUsingDataService());
    }
}