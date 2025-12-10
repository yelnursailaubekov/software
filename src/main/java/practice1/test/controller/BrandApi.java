package practice1.test.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice1.test.dto.BrandDto;
import practice1.test.dto.ItemDto;
import practice1.test.service.BrandService;
import practice1.test.service.ItemService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandApi {

    private final BrandService service;



    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody BrandDto dto){

        return new ResponseEntity<>(service.add(dto), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable(name = "id") Long id,
                                        @RequestBody BrandDto dto){

        return new ResponseEntity<>(  service.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable(name = "id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
