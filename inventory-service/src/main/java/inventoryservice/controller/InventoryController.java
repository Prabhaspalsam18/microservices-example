package inventoryservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @RequestMapping
    public String getInventory() {
        System.out.println("getInventory called");
        return "inventory";
    }
}
