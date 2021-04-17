package com.company;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

import com.company.models.Item;
import com.company.services.ItemService;
import com.company.stores.ItemStore;
import java.util.ArrayList;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemServiceTestWithAnnotations {

  @Mock private ItemStore itemStore;

  @InjectMocks private ItemService itemService;

  @BeforeMethod
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    Item mockedItem1 = new Item(1L, "Item 1", "Item 1 Desc", 2000);
    Item mockedItem2 = new Item(2L, "Item 2", "Item 2 Desc", 4000);
    List<Item> mockedItems = new ArrayList<>();
    mockedItems.add(mockedItem1);
    mockedItems.add(mockedItem2);

    when(itemStore.readAllItems()).thenReturn(mockedItems);

    when(itemStore.findById(1L)).thenReturn(mockedItem1);
  }

  @Test
  public void getItemById() {
    //
    // When
    //
    Item result = itemService.getById(1L);

    //
    // Verify
    //
    verify(itemStore, times(1)).findById(1L);
    assertEquals(result.getName(), "Item 1");
  }

  @Test
  public void getItemNameUpperCase() {
    //
    // Test
    //
    String result = itemService.getItemNameUpperCase(1L);

    //
    // Assert
    //
    verify(itemStore, times(1)).findById(1L);
    assertEquals(result, "ITEM 1");
  }

  @Test
  public void getAveragePrice() {
    //
    // Test
    //
    int result = itemService.getAveragePrice();

    //
    // Assert
    //
    verify(itemStore, times(1)).readAllItems();
    assertEquals(3000, result);
  }
}
