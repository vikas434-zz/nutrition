package co.rivatech.nutrition.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Nonnull;

import co.rivatech.nutrition.model.Block;
import co.rivatech.nutrition.service.BlockService;
import io.swagger.annotations.ApiOperation;

/**
 * @author vranjan
 * @created 08/08/2021
 */
@RestController
@RequestMapping("/v1/block")
public class BlockResource {

    //TODO TDD based validations and exceptions

    @Autowired
    private BlockService blockService;

    @GetMapping("/")
    @ApiOperation(value = "Get lists of all the blocks.")
    public List<Block> getAllDistrict() {
       return blockService.getAllBlocks();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a block")
    public ResponseEntity<Block> addDistrict(@Nonnull @RequestBody Block block) {
        return ResponseEntity.ok(blockService.addBlock(block));
    }

}
