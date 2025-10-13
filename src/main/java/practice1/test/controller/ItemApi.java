package practice1.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice1.test.dto.ItemDto;
import practice1.test.model.Item;
import practice1.test.service.ItemService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemApi {

    private final ItemService itemService;



    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(itemService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(itemService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody ItemDto item){

        return new ResponseEntity<>(itemService.addItem(item), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable(name = "id") Long id,
                                        @RequestBody ItemDto item){

        return new ResponseEntity<>(  itemService.updateItem(id, item), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable(name = "id") Long id){
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
