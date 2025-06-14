package br.com.botapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryItem {
    private Integer id;
    private Boolean lock;
    private Integer quantity;
}
