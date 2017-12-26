package com.inmemorycache.storage.impl;

import com.inmemorycache.storage.InMemoryCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class HashMapCacheTest {

    @InjectMocks
    private InMemoryCache toTest = new HashMapCache();

    @Mock
    private Map<String, Object> cache;

    @Test
    public void get_ShouldReturnTypeError_WhenValueIsNotString() {

        //given
        doReturn(new ArrayList<>()).when(cache).get("key");

        //when
        String result = toTest.get("key");

        //then
        assertEquals("type_error", result);
    }

    @Test
    public void get_ShouldReturnValue_WhenValueExistsAndIsString() {

        //given
        doReturn("value").when(cache).get("key");

        //when
        String result = toTest.get("key");

        //then
        assertEquals("value", result);
    }

    @Test
    public void get_ShouldReturnNil_WhenValueIsNotPresented() {

        //given
        doReturn(null).when(cache).get("key");

        //when
        String result = toTest.get("key");

        //then
        assertEquals("nil", result);
    }

}