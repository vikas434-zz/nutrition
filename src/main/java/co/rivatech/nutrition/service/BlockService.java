package co.rivatech.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import co.rivatech.nutrition.exception.ResourceNotFoundException;
import co.rivatech.nutrition.model.Block;
import co.rivatech.nutrition.repository.BlockRepository;
import springfox.documentation.annotations.Cacheable;

/**
 * @author vranjan
 * created 07/08/2021
 */
@Service
public class BlockService {

    @Autowired
    private BlockRepository blockRepository;

    @Cacheable("blocks")
    public List<Block> getAllBlocks() {
        List<Block> blocks = new ArrayList<>();
        Iterable<Block> items = blockRepository.findAll();
        items.forEach(blocks::add);
        return blocks;
    }

    public Block addBlock(final Block block) {
        blockRepository.save(block);
        return block;
    }

    public Block getBlockById(final int blockId) {
        return blockRepository.findById(blockId)
                              .orElseThrow(() -> new ResourceNotFoundException(String.format("No block found with id %s",
                                                                                             blockId)));
    }

    public List<Block> getBlockByDistrictId(final int districtId) {
        List<Block> blocks = blockRepository.findByDistrictId(districtId);
        if (blocks.isEmpty()) {
            throw new ResourceNotFoundException(String.format("No block found with district id %s", districtId));
        }
        return blocks;
    }
}
